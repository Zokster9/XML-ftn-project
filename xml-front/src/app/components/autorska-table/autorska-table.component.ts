import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ObrazacAutorskoDeloDTO } from 'src/app/models/autorska/ObrazacAutorskoDeloDTO';
import { ResenjeZahtevaDTO } from 'src/app/models/ResenjeZahtevaDto';
import { AutorskaService } from 'src/app/services/autorska.service';
import AutorskaUtil from 'src/app/util/autorska-util';
import * as xml2js from 'xml2js';
import { saveAs } from 'file-saver';

@Component({
  selector: 'app-autorska-table',
  templateUrl: './autorska-table.component.html',
  styleUrls: ['./autorska-table.component.css']
})
export class AutorskaTableComponent {

  obrasciAutorska : ObrazacAutorskoDeloDTO[] = [];
  resenjaZahteva: ResenjeZahtevaDTO[] = [];
  pocetniDatum!: Date;
  krajnjiDatum!: Date;
  tekst!: string;
  upit!: string;

  ngOnInit(): void {
    this.autorskaService.dobaviSve().subscribe(data => {
      const parser = new xml2js.Parser({strict: true, trim: true});
      parser.parseString(data.toString(), (err, result) => {
        let obrasci = result.List.item;
        let autorskaUtil = new AutorskaUtil();
        for (var obrazac of obrasci) {
          let obrazacAutorskoDeloDTO : ObrazacAutorskoDeloDTO;   
          obrazacAutorskoDeloDTO = autorskaUtil.konvertujOdgovor(obrazac);
          this.obrasciAutorska.push(obrazacAutorskoDeloDTO);
        }
      })
    })
  }

  constructor(
    private autorskaService: AutorskaService,
    private router: Router
  ){}

  kreirajIzvestaj() {

  }

  pretraziPoTekstu() {
    this.autorskaService.dobaviPoTekstu(this.tekst).subscribe(data => {
      const parser = new xml2js.Parser({strict: true, trim: true});
      parser.parseString(data.toString(), (err, result) => {
        this.obrasciAutorska = [];
        let zahtevi = result.List.item;
        let autorskaUtil: AutorskaUtil = new AutorskaUtil();
        if (zahtevi !== undefined) {
          for (var zahtev of zahtevi) {
            let obrazacAutorskoDeloDTO : ObrazacAutorskoDeloDTO;   
            obrazacAutorskoDeloDTO = autorskaUtil.konvertujOdgovor(zahtev);
            this.obrasciAutorska.push(obrazacAutorskoDeloDTO);
          }
        }else {
          alert("Nema rezultata pretrage");
        }
      })
    })
  }

  resetuj() {
    this.autorskaService.dobaviSve().subscribe(data => {
      const parser = new xml2js.Parser({strict: true, trim: true});
      parser.parseString(data.toString(), (err, result) => {
        let obrasci = result.List.item;
        let autorskaUtil = new AutorskaUtil();
        for (var obrazac of obrasci) {
          let obrazacAutorskoDeloDTO : ObrazacAutorskoDeloDTO;   
          obrazacAutorskoDeloDTO = autorskaUtil.konvertujOdgovor(obrazac);
          this.obrasciAutorska.push(obrazacAutorskoDeloDTO);
        }
      })
    })
  }

  pretraziPoMetapodacima() {
    this.autorskaService.dobaviPoMetapodacima(this.upit).subscribe(data => {
      const parser = new xml2js.Parser({strict: true, trim: true});
      parser.parseString(data.toString(), (err, result) => {
        this.obrasciAutorska = [];
        let zahtevi = result.List.item;
        let autorskaUtil: AutorskaUtil = new AutorskaUtil();
        if (zahtevi !== undefined) {
          for (var zahtev of zahtevi) {
            let obrazacAutorskoDeloDTO : ObrazacAutorskoDeloDTO;   
            obrazacAutorskoDeloDTO = autorskaUtil.konvertujOdgovor(zahtev);
            this.obrasciAutorska.push(obrazacAutorskoDeloDTO);
          }
        }else {
          alert("Nema rezultata pretrage");
        }
      })
    })
  }

  dobaviHTML(brojAutorskog: string) {
    this.autorskaService.dobaviHTML(brojAutorskog).subscribe(data => {
      const parser = new xml2js.Parser({strict: true, trim: true});
      parser.parseString(data.toString(), (err, result) => {
        window.open('http://localhost:9002/html/' + brojAutorskog + '.html');
      })
    });
  }

  dobaviPDF(brojAutorskog: string) {
    this.autorskaService.dobaviPDF(brojAutorskog).subscribe(data => {
      const parser = new xml2js.Parser({strict: true, trim: true});
      parser.parseString(data.toString(), (err, result) => {
        window.open('http://localhost:9002/pdf/' + brojAutorskog + '.pdf');
      })
    });
  }

  dobaviRDF(brojAutorskog: string) {
    const nazivFajla = brojAutorskog + '.rdf';
    this.autorskaService.dobaviRDF(brojAutorskog).subscribe(data => {
      const blob = new Blob([data], {type:'text/xml'});
      saveAs(blob, nazivFajla);
    })
  }

  dobaviJSON(brojAutorskog: string) {
    const nazivFajla = brojAutorskog + '.rdf';
    this.autorskaService.dobaviJSON(brojAutorskog).subscribe(data => {
      xml2js.parseString(data, (error, result) => {
        const jsonString = JSON.stringify(result);
        const blob = new Blob([jsonString], {type:'application/json'});
        saveAs(blob, nazivFajla);
      })
    })
  }

  proveriPostojanjeResenja(brojAutorskog: string): boolean {
    return true;
  }

  prikaziResenje(brojAutorskog: string) {

  }

  otvoriModal(brojAutorskog: string) {

  }

}

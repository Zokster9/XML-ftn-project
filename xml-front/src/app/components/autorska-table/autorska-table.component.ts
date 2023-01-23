import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ObrazacAutorskoDeloDTO } from 'src/app/models/autorska/ObrazacAutorskoDeloDTO';
import { ResenjeZahtevaDTO } from 'src/app/models/ResenjeZahtevaDto';
import { AutorskaService } from 'src/app/services/autorska.service';
import AutorskaUtil from 'src/app/util/autorska-util';
import * as xml2js from 'xml2js';
import { saveAs } from 'file-saver';
import { TokenService } from 'src/app/services/token.service';
import { ResenjeZahtevaService } from 'src/app/services/resenje-zahteva.service';
import ResenjaZahtevaUtil from 'src/app/util/resenja-util';
import { IzvestajDatumiDTO } from 'src/app/models/ReportDatesDto';

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
  modalOtvoren = false;
  odabranoAutorsko!: string;
  tekst!: string;
  upit!: string;
  uloga!: string;
  loaded = false;

  ngOnInit(): void {
    if (this.tokenService.getToken() === null) {
      this.router.navigate(['/']);
    } else {
      this.uloga = this.tokenService.getRole() as string;
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
      this.resenjaZahtevaService.dobaviSvaResenjaAutorska().subscribe(data => {
        const parser = new xml2js.Parser({strict: true, trim: true});
        parser.parseString(data.toString(), (err, result) => {
          let resenja = result.List.item;
          let resenjeZahtevaUtil = new ResenjaZahtevaUtil();
          if (resenja !== undefined) {
            for (var resenje of resenja) {
              let resenjeZahteva : ResenjeZahtevaDTO = resenjeZahtevaUtil.transformisiResenjeZahteva(resenje);
              this.resenjaZahteva.push(resenjeZahteva);
            }
          }
        })
      })
      this.loaded = true;
    }
  }

  constructor(
    private autorskaService: AutorskaService,
    private tokenService: TokenService,
    private resenjaZahtevaService: ResenjeZahtevaService,
    private router: Router
  ){}

  kreirajIzvestaj() {
    const izvestajDatumiDTO : IzvestajDatumiDTO = {
      pocetniDatum: this.pocetniDatum,
      krajnjiDatum: this.krajnjiDatum
    }
    this.resenjaZahtevaService.kreirajIzvestajAutorska(izvestajDatumiDTO).subscribe(data => {
      window.open('http://localhost:9002/pdf/izvestaj.pdf');
    })
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
    for (let resenje of this.resenjaZahteva) {
      if (resenje.referenca === brojAutorskog) return true;
    }
    return false;
  }

  prikaziResenje(brojAutorskog: string) {
    this.resenjaZahtevaService.prikaziResenjeKojeReferenciraNaZahtevAutorsko(brojAutorskog).subscribe(data => {
      const parser = new xml2js.Parser({strict: true, trim: true});
      parser.parseString(data.toString(), (err, result) => {
        window.open('http://localhost:9002/html/' + brojAutorskog + '_resenje.html');
      })
    })
  }

  otvoriModal(brojAutorskog: string) {
    this.odabranoAutorsko = brojAutorskog;
    this.modalOtvoren = true;
  }

  zatvoriModal(resenjeZahtevaDTO: ResenjeZahtevaDTO) {
    this.resenjaZahteva.push(resenjeZahtevaDTO);
    this.samoZatvoriModal();
  }

  samoZatvoriModal() {
    this.modalOtvoren = false;
  }

}

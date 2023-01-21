import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ReportDatesDto } from 'src/app/models/ReportDatesDto';
import { ZahtevZaPriznanjePatentaDto } from 'src/app/models/ZahtevZaPriznanjePatentaDTO';
import { PatentService } from 'src/app/services/patent.service';
import { ResenjeZahtevaService } from 'src/app/services/resenje-zahteva.service';
import * as xml2js from 'xml2js';
import { saveAs } from 'file-saver';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-patent-pdf-html-table',
  templateUrl: './patent-pdf-html-table.component.html',
  styleUrls: ['./patent-pdf-html-table.component.css']
})
export class PatentPdfHtmlTableComponent implements OnInit {

  zahteviZaPriznanjePatenta: ZahtevZaPriznanjePatentaDto[] = [];
  linkovi: ZahtevZaPriznanjePatentaDto[] = [];
  modalOpened = false;
  modalLinksOpened = false;
  odabraniZahtev!: ZahtevZaPriznanjePatentaDto;
  startDate!: string;
  endDate!: string;
  text!: string;
  query!: string;
  loggedPerson!: string;

  ngOnInit(): void {
    
    this.loggedPerson = this.tokenService.getRole() as string;
    let token = this.tokenService.getToken() as string;

    if (this.tokenService.getRole() === "sluzbenik"){
      this.patentService.getAllPatenti(token).subscribe(data => {
        const parser = new xml2js.Parser({strict: true, trim: true});
        parser.parseString(data.toString(), (err, result) => {
          let zahtevi = result.List.item;
          if (zahtevi !== undefined) {
            for (var zahtev of zahtevi) {
              let zahtevZaPriznanjePatenta : ZahtevZaPriznanjePatentaDto;   
              zahtevZaPriznanjePatenta = this.patentService.convertResponseToPatent(zahtev);
              this.zahteviZaPriznanjePatenta.push(zahtevZaPriznanjePatenta);
            }
          }
        })
      })
    }
    else if (this.tokenService.getRole() === "korisnik") {
      this.patentService.getAllPatentiByKorisnik(token).subscribe(data => {
        const parser = new xml2js.Parser({strict: true, trim: true});
        parser.parseString(data.toString(), (err, result) => {
          let zahtevi = result.List.item;
          if (zahtevi !== undefined) {
            for (var zahtev of zahtevi) {
              let zahtevZaPriznanjePatenta : ZahtevZaPriznanjePatentaDto;   
              zahtevZaPriznanjePatenta = this.patentService.convertResponseToPatent(zahtev);
              this.zahteviZaPriznanjePatenta.push(zahtevZaPriznanjePatenta);
            }
          }
        })
      })
    }
  }

  constructor(
    private patentService: PatentService,
    private resenjeZahtevaService: ResenjeZahtevaService,
    private tokenService: TokenService,
    private router: Router
  ) {}

  showHTML(zahtev : ZahtevZaPriznanjePatentaDto) {
    this.patentService.showHTML(zahtev.podaciOPrijavama.novaPrijava.brojPrijave).subscribe(data => {
      const parser = new xml2js.Parser({strict: true, trim: true});
      parser.parseString(data.toString(), (err, result) => {
        console.log(result);
        const patentNumber = result.ZahtevZaPriznanjePatentaCreationDto.podaciOPrijavama[0].novaPrijava[0].brojPrijave[0];
        window.open('http://localhost:9000/html/' + patentNumber + '.html');
      })
    });
  }

  showPDF(zahtev : ZahtevZaPriznanjePatentaDto) {
    this.patentService.showPDF(zahtev.podaciOPrijavama.novaPrijava.brojPrijave).subscribe(data => {
      const parser = new xml2js.Parser({strict: true, trim: true});
      parser.parseString(data.toString(), (err, result) => {
        const patentNumber = result.ZahtevZaPriznanjePatentaCreationDto.podaciOPrijavama[0].novaPrijava[0].brojPrijave[0];
        window.open('http://localhost:9000/pdf/' + patentNumber + '.pdf');
      })
    })
  }

  showRDF(zahtev : ZahtevZaPriznanjePatentaDto) {
    let token = this.tokenService.getToken() as string;
    const patentNumber = zahtev.podaciOPrijavama.novaPrijava.brojPrijave;
    const fileName = patentNumber + '.rdf';
    this.patentService.showRDF(zahtev, token).subscribe(data => {
      const blob = new Blob([data], {type:'text/xml'});
      saveAs(blob, fileName);
    })
    //const patentNumber = zahtev.podaciOPrijavama.novaPrijava.brojPrijave;
    //window.open('http://localhost:9000/rdf/' + patentNumber + '.rdf');
  }

  showJSON(zahtev : ZahtevZaPriznanjePatentaDto) {
    let token = this.tokenService.getToken() as string;
    const patentNumber = zahtev.podaciOPrijavama.novaPrijava.brojPrijave;
    const fileName = patentNumber + '.json';
    this.patentService.showRDF(zahtev, token).subscribe(data => {
      xml2js.parseString(data, (error, result) => {
        const jsonString = JSON.stringify(result);
        const blob = new Blob([jsonString], {type:'application/json'});
        saveAs(blob, fileName);
      })

    })
    //const patentNumber = zahtev.podaciOPrijavama.novaPrijava.brojPrijave;
    //window.open('http://localhost:9000/json/' + patentNumber + '.json');
  }

  showReferencedDocuments(zahtev: ZahtevZaPriznanjePatentaDto) {
    const patentNumber = zahtev.podaciOPrijavama.novaPrijava.brojPrijave;
    this.linkovi.splice(0, this.linkovi.length);
    this.patentService.showReferencedDocuments(patentNumber).subscribe(data => {
      const parser = new xml2js.Parser({strict: true, trim: true});
      parser.parseString(data.toString(), (err, result) => {
        let zahtevi = result.List.item;
        if (zahtevi != undefined) {
          for (var zahtev of zahtevi) {
            let zahtevZaPriznanjePatenta : ZahtevZaPriznanjePatentaDto;   
            zahtevZaPriznanjePatenta = this.patentService.convertResponseToPatent(zahtev);
            this.linkovi.push(zahtevZaPriznanjePatenta);
          }
          this.modalLinksOpened = true;
        }
      })
    })
  }

  showPatentsThatReferenceTo(zahtev: ZahtevZaPriznanjePatentaDto) {
    const patentNumber = zahtev.podaciOPrijavama.novaPrijava.brojPrijave;
    this.linkovi.splice(0, this.linkovi.length);
    this.patentService.showPatentsThatReferenceTo(patentNumber).subscribe(data => {
      const parser = new xml2js.Parser({strict: true, trim: true});
      parser.parseString(data.toString(), (err, result) => {
        let zahtevi = result.List.item;
        if (zahtevi != undefined) {
          for (var zahtev of zahtevi) {
            let zahtevZaPriznanjePatenta : ZahtevZaPriznanjePatentaDto;   
            zahtevZaPriznanjePatenta = this.patentService.convertResponseToPatent(zahtev);
            this.linkovi.push(zahtevZaPriznanjePatenta);
          }
          this.modalLinksOpened = true;
        }
      })
    })
  }

  showResenjeZahtevaThatReferencesTo(zahtev: ZahtevZaPriznanjePatentaDto) {
    const patentNumber = zahtev.podaciOPrijavama.novaPrijava.brojPrijave;
    this.resenjeZahtevaService.showResenjeZahtevaThatReferencesTo(patentNumber).subscribe(data => {
      const parser = new xml2js.Parser({strict: true, trim: true});
      parser.parseString(data.toString(), (err, result) => {
        console.log(result);
        const patentNumber = result.ResenjeZahtevaDto.referenca[0];
        window.open('http://localhost:9000/html/' + patentNumber + '_resenje.html');
      })
    })
  }

  openModal(zahtev : ZahtevZaPriznanjePatentaDto) {
    this.odabraniZahtev = zahtev;
    this.modalOpened = true;
  }

  closeModal() {
    this.modalOpened = false;
  }

  closeModalLinks() {
    this.modalLinksOpened = false;
  }

  createReport() {
    let token = this.tokenService.getToken() as string;
    const reportDatesDto : ReportDatesDto = {
      startDate: this.startDate,
      endDate: this.endDate
    }
    this.resenjeZahtevaService.createReport(reportDatesDto, token).subscribe(data => {
      window.open('http://localhost:9000/pdf/izvestaj.pdf');
    })
  }

  findPatentsByText() {
    let token = this.tokenService.getToken() as string;
    this.patentService.getPatentsByText(this.text, token).subscribe(data => {
      const parser = new xml2js.Parser({strict: true, trim: true});
      parser.parseString(data.toString(), (err, result) => {
        this.zahteviZaPriznanjePatenta.splice(0, this.zahteviZaPriznanjePatenta.length);
        let zahtevi = result.List.item;
        if (zahtevi !== undefined) {
          for (var zahtev of zahtevi) {
            let zahtevZaPriznanjePatenta : ZahtevZaPriznanjePatentaDto;   
            zahtevZaPriznanjePatenta = this.patentService.convertResponseToPatent(zahtev);
            this.zahteviZaPriznanjePatenta.push(zahtevZaPriznanjePatenta);
          }
        }
      })
    })
  }

  findPatentsByMetadata() {
    let token = this.tokenService.getToken() as string;
    this.patentService.getPatentsByMetadata(this.query, token).subscribe(data => {
      const parser = new xml2js.Parser({strict: true, trim: true});
      parser.parseString(data.toString(), (err, result) => {
        this.zahteviZaPriznanjePatenta.splice(0, this.zahteviZaPriznanjePatenta.length);
        let zahtevi = result.List.item;
        if (zahtevi !== undefined){
          for (var zahtev of zahtevi) {
            let zahtevZaPriznanjePatenta : ZahtevZaPriznanjePatentaDto;   
            zahtevZaPriznanjePatenta = this.patentService.convertResponseToPatent(zahtev);
            this.zahteviZaPriznanjePatenta.push(zahtevZaPriznanjePatenta);
          }
        }
      })
    })
  }

  reset() {
    this.reloadPage();
  }

  reloadPage() {
    this.router.routeReuseStrategy.shouldReuseRoute = () => false;
    this.router.onSameUrlNavigation = 'reload';
    this.router.navigate(['/pregledaj-patente']);
  }
}

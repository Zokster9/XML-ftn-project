import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ReportDatesDto } from 'src/app/models/ReportDatesDto';
import { ZahtevZaPriznanjePatentaDto } from 'src/app/models/ZahtevZaPriznanjePatentaDTO';
import { PatentService } from 'src/app/services/patent.service';
import { ResenjeZahtevaService } from 'src/app/services/resenje-zahteva.service';
import * as xml2js from 'xml2js';

@Component({
  selector: 'app-patent-pdf-html-table',
  templateUrl: './patent-pdf-html-table.component.html',
  styleUrls: ['./patent-pdf-html-table.component.css']
})
export class PatentPdfHtmlTableComponent implements OnInit {

  zahteviZaPriznanjePatenta: ZahtevZaPriznanjePatentaDto[] = [];
  modalOpened = false;
  odabraniZahtev!: ZahtevZaPriznanjePatentaDto;
  startDate!: string;
  endDate!: string;
  text!: string;
  query!: string;

  ngOnInit(): void {
    this.patentService.getAllPatenti().subscribe(data => {
      const parser = new xml2js.Parser({strict: true, trim: true});
      parser.parseString(data.toString(), (err, result) => {
        console.log(result);
        let zahtevi = result.List.item;
        for (var zahtev of zahtevi) {
          let zahtevZaPriznanjePatenta : ZahtevZaPriznanjePatentaDto;   
          zahtevZaPriznanjePatenta = this.patentService.convertResponseToPatent(zahtev);
          this.zahteviZaPriznanjePatenta.push(zahtevZaPriznanjePatenta);
        }
      })
    })
  }

  constructor(
    private patentService: PatentService,
    private resenjeZahtevaService: ResenjeZahtevaService,
    private router: Router
  ) {}

  showHTML(zahtev : ZahtevZaPriznanjePatentaDto) {
    this.patentService.showHTML(zahtev).subscribe(data => {
      const parser = new xml2js.Parser({strict: true, trim: true});
      parser.parseString(data.toString(), (err, result) => {
        const patentNumber = result.ZahtevZaPriznanjePatentaCreationDto.podaciOPrijavama[0].novaPrijava[0].brojPrijave[0];
        window.open('http://localhost:9000/html/' + patentNumber + '.html');
      })
    });
  }

  showPDF(zahtev : ZahtevZaPriznanjePatentaDto) {
    this.patentService.showPDF(zahtev).subscribe(data => {
      const parser = new xml2js.Parser({strict: true, trim: true});
      parser.parseString(data.toString(), (err, result) => {
        const patentNumber = result.ZahtevZaPriznanjePatentaCreationDto.podaciOPrijavama[0].novaPrijava[0].brojPrijave[0];
        window.open('http://localhost:9000/pdf/' + patentNumber + '.pdf');
      })
    })
  }

  showRDF(zahtev : ZahtevZaPriznanjePatentaDto) {
    const patentNumber = zahtev.podaciOPrijavama.novaPrijava.brojPrijave;
    window.open('http://localhost:9000/rdf/' + patentNumber + '.rdf');
  }

  showJSON(zahtev : ZahtevZaPriznanjePatentaDto) {
    const patentNumber = zahtev.podaciOPrijavama.novaPrijava.brojPrijave;
    window.open('http://localhost:9000/json/' + patentNumber + '.json');
  }

  openModal(zahtev : ZahtevZaPriznanjePatentaDto) {
    this.odabraniZahtev = zahtev;
    this.modalOpened = true;
  }

  closeModal() {
    this.modalOpened = false;
  }

  createReport() {
    const reportDatesDto : ReportDatesDto = {
      startDate: this.startDate,
      endDate: this.endDate
    }
    this.resenjeZahtevaService.createReport(reportDatesDto).subscribe(data => {
      window.open('http://localhost:9000/pdf/izvestaj.pdf');
    })
  }

  findPatentsByText() {
    this.patentService.getPatentsByText(this.text).subscribe(data => {
      const parser = new xml2js.Parser({strict: true, trim: true});
      parser.parseString(data.toString(), (err, result) => {
        this.zahteviZaPriznanjePatenta.splice(0, this.zahteviZaPriznanjePatenta.length);
        let zahtevi = result.List.item;
        for (var zahtev of zahtevi) {
          let zahtevZaPriznanjePatenta : ZahtevZaPriznanjePatentaDto;   
          zahtevZaPriznanjePatenta = this.patentService.convertResponseToPatent(zahtev);
          this.zahteviZaPriznanjePatenta.push(zahtevZaPriznanjePatenta);
        }
      })
    })
  }

  findPatentsByMetadata() {
    this.patentService.getPatentsByMetadata(this.query).subscribe(data => {
      const parser = new xml2js.Parser({strict: true, trim: true});
      parser.parseString(data.toString(), (err, result) => {
        this.zahteviZaPriznanjePatenta.splice(0, this.zahteviZaPriznanjePatenta.length);
        let zahtevi = result.List.item;
        for (var zahtev of zahtevi) {
          let zahtevZaPriznanjePatenta : ZahtevZaPriznanjePatentaDto;   
          zahtevZaPriznanjePatenta = this.patentService.convertResponseToPatent(zahtev);
          this.zahteviZaPriznanjePatenta.push(zahtevZaPriznanjePatenta);
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
    this.router.navigate(['/view-patent-pdf-html']);
  }
}

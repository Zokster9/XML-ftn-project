import { Component, OnInit } from '@angular/core';
import { ZahtevZaPriznanjePatentaDto } from 'src/app/models/ZahtevZaPriznanjePatentaDTO';
import { PatentService } from 'src/app/services/patent.service';
import * as xml2js from 'xml2js';

@Component({
  selector: 'app-patent-pdf-html-table',
  templateUrl: './patent-pdf-html-table.component.html',
  styleUrls: ['./patent-pdf-html-table.component.css']
})
export class PatentPdfHtmlTableComponent implements OnInit {

  zahteviZaPriznanjePatenta: ZahtevZaPriznanjePatentaDto[] = [];

  ngOnInit(): void {
    this.patentService.getAllPatenti().subscribe(data => {
      const parser = new xml2js.Parser({strict: true, trim: true});
      parser.parseString(data.toString(), (err, result) => {
        let zahtevi = result.List.item;
        for (var zahtev of zahtevi) {
          console.log(zahtev);
          let zahtevZaPriznanjePatenta : ZahtevZaPriznanjePatentaDto;
          
          zahtevZaPriznanjePatenta = this.patentService.convertResponseToPatent(zahtev);
          this.zahteviZaPriznanjePatenta.push(zahtevZaPriznanjePatenta);
          
        }
      })
    })
  }

  constructor(
    private patentService: PatentService
  ) {}

  showHTML(zahtev : ZahtevZaPriznanjePatentaDto) {
    this.patentService.showHTML(zahtev).subscribe(data => {
      console.log(data);
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

}

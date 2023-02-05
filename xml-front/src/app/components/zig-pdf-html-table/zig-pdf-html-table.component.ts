import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ResenjeZahtevaDTO } from 'src/app/models/ResenjeZahtevaDto';
import { ZahtevZaPriznanjeZigaDTO } from 'src/app/models/zig/ZahtevZaPriznanjeZigaDTO';
import { TokenService } from 'src/app/services/token.service';
import { ZigService } from 'src/app/services/zig.service';
import * as xml2js from 'xml2js';
import { saveAs } from 'file-saver';
import { ResenjeZahtevaService } from 'src/app/services/resenje-zahteva.service';
import ResenjaZahtevaUtil from 'src/app/util/resenja-util';
import { IzvestajDatumiDTO } from 'src/app/models/ReportDatesDto';

@Component({
  selector: 'app-zig-pdf-html-table',
  templateUrl: './zig-pdf-html-table.component.html',
  styleUrls: ['./zig-pdf-html-table.component.css']
})
export class ZigPdfHtmlTableComponent implements OnInit {

  zahteviZig : ZahtevZaPriznanjeZigaDTO[] = [];
  resenjaZahteva: ResenjeZahtevaDTO[] = [];
  pocetniDatum!: Date;
  krajnjiDatum!: Date;
  modalOtvoren = false;
  odabranZahtevZig!: string;
  tekst!: string;
  upit!: string;
  uloga!: string;
  loaded = false;

  constructor(
    private readonly tokenService: TokenService,
    private readonly router: Router,
    private readonly zigService: ZigService,
    private resenjaZahtevaService: ResenjeZahtevaService,
  ) {}

  ngOnInit(): void {
    if (this.tokenService.getToken() === null) {
      this.router.navigate(['/']);
    } else {
      this.uloga = this.tokenService.getRole() as string;
      this.zigService.getAllZigovi().subscribe({
        next: response => {
          const parser = new xml2js.Parser({ strict: true, trim: true });
          parser.parseString(response.toString(), (err, result) => {
            let zahtevi = result.List.item;
            for (var zahtev of zahtevi) {
              let zahtevZaPriznanjeZigaDTO: ZahtevZaPriznanjeZigaDTO;
              zahtevZaPriznanjeZigaDTO = this.zigService.convertResponseToZig(zahtev);
              this.zahteviZig.push(zahtevZaPriznanjeZigaDTO);
            }
          });
        }
      });
      this.resenjaZahtevaService.getAllResenjaZig().subscribe({
        next: response => {
          const parser = new xml2js.Parser({strict: true, trim: true});
          parser.parseString(response.toString(), (err, result) => {
            let resenja = result.List.item;
            let resenjeZahtevaUtil = new ResenjaZahtevaUtil();
            if (resenja !== undefined) {
              for (var resenje of resenja) {
                let resenjeZahteva: ResenjeZahtevaDTO = resenjeZahtevaUtil.transformisiResenjeZahteva(resenje);
                this.resenjaZahteva.push(resenjeZahteva);
              }
            }
          });
        }
      });
      this.loaded = true;
    }
  }

  kreirajIzvestaj() {
    const izvestajDatumiDTO : IzvestajDatumiDTO = {
      pocetniDatum: this.pocetniDatum,
      krajnjiDatum: this.krajnjiDatum
    }
    this.resenjaZahtevaService.createIzvestajZig(izvestajDatumiDTO).subscribe({
      next: () => {
        window.open('http://localhost:9004/pdf/izvestaj.pdf');
      }
    });
  }

  pretraziPoTekstu() {
    this.zigService.getByText(this.tekst).subscribe({
      next: response => {
        const parser = new xml2js.Parser({strict: true, trim: true});
        parser.parseString(response.toString(), (err, result) => {
          this.zahteviZig = [];
          let zahtevi = result.List.item;
          if (zahtevi !== undefined) {
            for (var zahtev of zahtevi) {
              let zahtevZaPriznanjeZigaDTO: ZahtevZaPriznanjeZigaDTO;
              zahtevZaPriznanjeZigaDTO = this.zigService.convertResponseToZig(zahtev);
              this.zahteviZig.push(zahtevZaPriznanjeZigaDTO);
            }
          } else {
            alert("Nema rezultata pretrage");
          }
        });
      }
    });
  }

  resetuj() {
    this.zigService.getAllZigovi().subscribe({
      next: response => {
        const parser = new xml2js.Parser({ strict: true, trim: true });
        parser.parseString(response.toString(), (err, result) => {
          let zahtevi = result.List.item;
          this.zahteviZig = [];
          for (var zahtev of zahtevi) {
            let zahtevZaPriznanjeZigaDTO: ZahtevZaPriznanjeZigaDTO;
            zahtevZaPriznanjeZigaDTO = this.zigService.convertResponseToZig(zahtev);
            this.zahteviZig.push(zahtevZaPriznanjeZigaDTO);
          }
        });
      }
    });
  }

  pretraziPoMetapodacima() {
    this.zigService.getByMetadata(this.upit).subscribe({
      next: response => {
        const parser = new xml2js.Parser({strict: true, trim: true});
        parser.parseString(response.toString(), (err, result) => {
          this.zahteviZig = [];
          let zahtevi = result.List.item;
          if (zahtevi !== undefined) {
            for (var zahtev of zahtevi) {
              let zahtevZaPriznanjeZigaDTO: ZahtevZaPriznanjeZigaDTO;
              zahtevZaPriznanjeZigaDTO = this.zigService.convertResponseToZig(zahtev);
              this.zahteviZig.push(zahtevZaPriznanjeZigaDTO);
            }
          } else {
            alert("Nema rezultata pretrage");
          }
        });
      }
    });
  }

  dobaviHTML(brojZiga: string) {
    this.zigService.showHTML(brojZiga).subscribe({
      next: response => {
        const parser = new xml2js.Parser({strict: true, trim: true});
        parser.parseString(response.toString(), (err, result) => {
          window.open('http://localhost:9004/html/' + brojZiga + '.html');
        });
      }
    });
  }

  dobaviPDF(brojZiga: string) {
    this.zigService.showPDF(brojZiga).subscribe({
      next: response => {
        const parser = new xml2js.Parser({strict: true, trim: true});
        parser.parseString(response.toString(), (err, result) => {
          window.open('http://localhost:9004/pdf/' + brojZiga + '.pdf');
        });
      }
    });
  }

  dobaviRDF(brojZiga: string) {
    const nazivFajla = brojZiga + '.rdf';
    this.zigService.showRDF(brojZiga).subscribe({
      next: data => {
        const blob = new Blob([data], { type: 'text/xml' });
        saveAs(blob, nazivFajla);
      }
    });
  }

  dobaviJSON(brojZiga: string) {
    const nazivFajla = brojZiga + '.json';
    this.zigService.showJSON(brojZiga).subscribe({
      next: data => {
        xml2js.parseString(data, (error, result) => {
          const jsonString = JSON.stringify(result);
          const blob = new Blob([jsonString], { type: 'application/json' });
          saveAs(blob, nazivFajla);
        });
      }
    });
  }

  proveriPostojanjeResenja(brojZiga: string): boolean {
    for (let resenje of this.resenjaZahteva) {
      if (resenje.referenca === brojZiga) return true;
    }
    return false;
  }

  prikaziResenje(brojZiga: string) {
    this.resenjaZahtevaService.showResenjeKojeReferenciraNaZahtevZig(brojZiga).subscribe({
      next: response => {
        const parser = new xml2js.Parser({strict: true, trim: true});
        parser.parseString(response.toString(), (err, result) => {
          window.open('http://localhost:9004/html/' + brojZiga + '_resenje.html');
        });
      }
    });
  }

  otvoriModal(brojZiga: string) {
    this.odabranZahtevZig = brojZiga;
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

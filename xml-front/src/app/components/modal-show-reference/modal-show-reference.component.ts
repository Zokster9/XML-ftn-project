import { Component, EventEmitter, Input, Output } from '@angular/core';
import { ResenjeZahtevaDto } from 'src/app/models/ResenjeZahtevaDto';
import { ZahtevZaPriznanjePatentaDto } from 'src/app/models/ZahtevZaPriznanjePatentaDTO';
import { PatentService } from 'src/app/services/patent.service';
import * as xml2js from 'xml2js';

@Component({
  selector: 'app-modal-show-reference',
  templateUrl: './modal-show-reference.component.html',
  styleUrls: ['./modal-show-reference.component.css']
})
export class ModalShowReferenceComponent {

  
  @Input() zahtevi! : ZahtevZaPriznanjePatentaDto[];

  @Input() resenjeZahteva! : ResenjeZahtevaDto;
  
  @Output() modalLinksClosed = new EventEmitter();

  displayStyle = "None";

  constructor(
    private patentService: PatentService
  ) {}

  ngOnInit(): void {
    this.displayStyle = "Block";
  }

  closeModalLinks() {
    this.modalLinksClosed.emit();
  }

  showHTML(zahtev: ZahtevZaPriznanjePatentaDto) {
    event?.preventDefault();
    this.patentService.showHTML(zahtev).subscribe(data => {
      const parser = new xml2js.Parser({strict: true, trim: true});
      parser.parseString(data.toString(), (err, result) => {
        const patentNumber = result.ZahtevZaPriznanjePatentaCreationDto.podaciOPrijavama[0].novaPrijava[0].brojPrijave[0];
        window.open('http://localhost:9000/html/' + patentNumber + '.html');
      })
    });
  }
}

import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { ResenjeZahtevaDTO, ResenjeZahtevaDto } from 'src/app/models/ResenjeZahtevaDto';
import { ZahtevZaPriznanjePatentaDto } from 'src/app/models/ZahtevZaPriznanjePatentaDTO';
import { ResenjeZahtevaService } from 'src/app/services/resenje-zahteva.service';
import { TokenService } from 'src/app/services/token.service';
import ResenjaZahtevaUtil from 'src/app/util/resenja-util';
import * as xml2js from 'xml2js';

@Component({
  selector: 'app-modal-accept-decline-request',
  templateUrl: './modal-accept-decline-request.component.html',
  styleUrls: ['./modal-accept-decline-request.component.css']
})
export class ModalAcceptDeclineRequestComponent implements OnInit {

  @Input() servis! : string;

  @Input() brojAutorskog! : string;

  @Input() zahtev! : ZahtevZaPriznanjePatentaDto;

  @Output() autorskoResenjeDodato = new EventEmitter<ResenjeZahtevaDTO>();

  @Output() modalClosed = new EventEmitter();

  displayStyle = "None";

  form = this.formBuilder.group({
    prihvaceno: ['prihvati'],
    obrazlozenje: ['']
  })

  constructor(
    private formBuilder: FormBuilder,
    private resenjeZahtevaService: ResenjeZahtevaService,
    private tokenService: TokenService,
    private router: Router
  ) {}
  ngOnInit(): void {
    this.displayStyle = "Block";
  }

  closeModal() {
    this.modalClosed.emit();
  }

  submit() {
    if (this.servis === 'autorska') {
      this.posaljiAutorsko();
    }else if (this.servis === 'patent') {
      this.submitPatent();
    }else {

    }
  }

  posaljiAutorsko() {
    let prihvaceno;
    if (this.form.controls["prihvaceno"].value === 'prihvati') {
      prihvaceno = true;
    }
    else
    {
      prihvaceno = false;
    }
    let resenjeZahteva: ResenjeZahtevaDTO = {
      zahtevJePrihvacen: prihvaceno,
      obrazlozenje: this.form.value.obrazlozenje as string,
      referenca: this.brojAutorskog
    };
    this.resenjeZahtevaService.kreirajResenjeAutorska(resenjeZahteva).subscribe(data => {
      const parser = new xml2js.Parser({strict: true, trim: true});
      parser.parseString(data.toString(), (err, result) => {
        let resenjeZahteva: ResenjeZahtevaDTO | undefined;
        let resenjeZahtevaUtil = new ResenjaZahtevaUtil();
        resenjeZahteva = resenjeZahtevaUtil.transformisiResenjeZahteva(result.ResenjeZahtevaDTO);
        this.autorskoResenjeDodato.emit(resenjeZahteva);
      })
    })
  }

  submitPatent() {
    let prihvaceno;
    if (this.form.controls["prihvaceno"].value === 'prihvati') {
      prihvaceno = true;
    }
    else
    {
      prihvaceno = false;
    }
    let token = this.tokenService.getToken() as string;
    const resenjeZahteva : ResenjeZahtevaDto = {
      datumResenja: '',
      obrazlozenje: this.form.value.obrazlozenje as string,
      referenca : this.zahtev.podaciOPrijavama.novaPrijava.brojPrijave,
      sifra : '',
      zahtevJePrihvacen: prihvaceno
    }
    console.log(resenjeZahteva);
    this.resenjeZahtevaService.addResenjeZahteva(resenjeZahteva, token).subscribe(data => {
      console.log(data);
      this.reloadPage();
    })
  }

  reloadPage() {
    this.router.routeReuseStrategy.shouldReuseRoute = () => false;
    this.router.onSameUrlNavigation = 'reload';
    this.router.navigate(['/pregledaj-patente']);
  }
}

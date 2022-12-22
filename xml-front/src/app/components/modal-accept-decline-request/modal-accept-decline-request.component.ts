import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ZahtevZaPriznanjePatentaDto } from 'src/app/models/ZahtevZaPriznanjePatentaDTO';

@Component({
  selector: 'app-modal-accept-decline-request',
  templateUrl: './modal-accept-decline-request.component.html',
  styleUrls: ['./modal-accept-decline-request.component.css']
})
export class ModalAcceptDeclineRequestComponent implements OnInit {

  //@Input() zahtev! : ZahtevZaPriznanjePatentaDto;

  displayStyle = "None";

  form = this.formBuilder.group({
    prihvaceno: ['prihvati'],
    obrazlozenje: ['']
  })

  constructor(
    private formBuilder: FormBuilder,
  ) {}
  ngOnInit(): void {
    this.displayStyle = "Block";
  }

  closeModal() {

  }

  submit() {

  }
}

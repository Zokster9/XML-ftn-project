import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit{

  registrationForm = this.formBuilder.group({
    mejl: '',
    ime: '',
    prezime: '',
    sifra: '',
    korisnikJeSluzbenik: false
  });

  constructor(
    private formBuilder: FormBuilder,
    ) { }

  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  register() {

  }

}

import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { KorisnikDTO } from 'src/app/models/KorisnikDto';
import { UserService } from 'src/app/services/user.service';

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
    private formBuilder: FormBuilder, private userService: UserService
    ) { }

  ngOnInit(): void {

  }

  register() {
    const korisnikDTO: KorisnikDTO = {
      ime: this.registrationForm.value.ime as string,
      prezime: this.registrationForm.value.prezime as string,
      korisnickoIme: this.registrationForm.value.mejl as string,
      sifra: this.registrationForm.value.sifra as string,
      korisnikJeSluzbenik: this.registrationForm.value.korisnikJeSluzbenik as boolean
    }
    this.userService.registracija(korisnikDTO).subscribe(data => {
      console.log(data);
    })
  }

}

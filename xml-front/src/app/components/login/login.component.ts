import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { DecodedToken } from 'src/app/models/DecodedToken';
import { LoginDTO } from 'src/app/models/LoginDto';
import { UserService } from 'src/app/services/user.service';
import * as xml2js from 'xml2js';
import jwtDecode from 'jwt-decode';
import { TokenService } from 'src/app/services/token.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm = this.formBuilder.group({
    email: '',
    password: '',
  });

  constructor(private formBuilder: FormBuilder, private userService: UserService,
     private tokenService: TokenService, private router: Router) {}


  ngOnInit(): void {
  
  }

  login() {
    const loginDTO : LoginDTO = {
      korisnickoIme: this.loginForm.value.email as string,
      lozinka: this.loginForm.value.password as string
    }
    this.userService.prijava(loginDTO).subscribe(data => {
      const parser = new xml2js.Parser({strict: true, trim: true});
      parser.parseString(data.toString(), (err, result) => {
        const token = result.TokenDTO.accessToken[0];
        let decodedToken: DecodedToken = jwtDecode(token);
        this.tokenService.setToken(token, decodedToken.role);
        if (this.tokenService.getRole() === 'korisnik') {
          this.router.navigate(['/kreiraj-patent']);
        }
        else {
          this.router.navigate(['/pregledaj-patente']);
        }
      })
    });
  }
}

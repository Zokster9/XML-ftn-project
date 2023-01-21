import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit{

  loggedPerson!: string;

  constructor(private tokenService: TokenService, private router: Router) {}

  ngOnInit(): void {
    if (this.tokenService.getRole() === "sluzbenik") {
      this.loggedPerson = "sluzbenik";
    }
    else if (this.tokenService.getRole() === "korisnik") {
      this.loggedPerson = "korisnik";
    }
    else {
      this.loggedPerson = "neulogovan";
    }
  }

  public logout() {
    sessionStorage.clear();
    this.router.navigate(['/prijava']);
  }


}

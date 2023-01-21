import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { KorisnikDTO } from "../models/KorisnikDto";
import * as JsonToXML from "js2xmlparser";
import { LoginDTO } from "../models/LoginDto";

const TOKEN_KEY = 'AuthToken';

const ROLE_KEY = 'Role';

@Injectable({
    providedIn: 'root'
})
export class UserService {

    constructor(private httpClient: HttpClient) { }

    public registracija(korisnikDTO: KorisnikDTO) {
        const xmlZahtev = JsonToXML.parse("korisnikDTO", korisnikDTO);
        return this.httpClient.post('http://localhost:9003/korisnici/registracija', xmlZahtev,
         {headers: new HttpHeaders().set('Content-Type', 'application/xml'), responseType:'text'});
    }

    public prijava(loginDTO: LoginDTO) {
        const xmlZahtev = JsonToXML.parse("loginDTO", loginDTO);
        return this.httpClient.post('http://localhost:9003/auth/login', xmlZahtev,
        {headers: new HttpHeaders().set('Content-Type', 'application/xml'), responseType:'text'});
    }
}
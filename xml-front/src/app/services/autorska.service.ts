import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from "@angular/core";
import { environment } from 'src/environments/environment';
import * as JsonToXML from "js2xmlparser";
import { ObrazacAutorskoDeloCreationDTO } from '../models/autorska/ObrazacAutorskoDeloCreationDTO';
import { TokenService } from './token.service';

@Injectable({
    providedIn: 'root'
  })
export class AutorskaService {

    private url = environment.autorskaApiUrl;

    constructor(private httpClient: HttpClient, private tokenService: TokenService) {}

    kreirajObrazacZaAutorska(obrazacAutorskoDeloCreationDTO: ObrazacAutorskoDeloCreationDTO) {
        const xmlZahtev = JsonToXML.parse("obrazacAutorskoDeloCreationDTO", obrazacAutorskoDeloCreationDTO);
        console.log(xmlZahtev);
        const xmlOdgovor = this.httpClient.post(this.url + '/autorska/dodaj-autorska', xmlZahtev, {headers: new HttpHeaders().set('Content-Type', 'application/xml').set('Authorization', this.tokenService.getToken() as string), responseType:'text'});
        return xmlOdgovor;
    }

    dobaviSve() {
        const xmlOdgovor = this.httpClient.get(this.url + '/autorska/dobavi-sve', {headers: new HttpHeaders().set('Content-Type', 'application/xml').set('Authorization', this.tokenService.getToken() as string), responseType:'text'});
        return xmlOdgovor;
    }

    dobaviObrazacAutorska(brojPrijave: string) {
        const xmlOdgovor = this.httpClient.get(this.url + '/autorska/dobavi-autorsko/' + brojPrijave, {headers: new HttpHeaders().set('Content-Type', 'application/xml'), responseType:'text'});
        return xmlOdgovor;
    }

    dobaviHTML(brojPrijave: string) {
        const xmlOdgovor = this.httpClient.get(this.url + '/autorska/dobavi-html/' + brojPrijave, {headers: new HttpHeaders().set('Content-Type', 'application/xml').set('Authorization', this.tokenService.getToken() as string), responseType:'text'});
        return xmlOdgovor;
    }

    dobaviPDF(brojPrijave: string) {
        const xmlOdgovor = this.httpClient.get(this.url + '/autorska/dobavi-pdf/' + brojPrijave, {headers: new HttpHeaders().set('Content-Type', 'application/xml').set('Authorization', this.tokenService.getToken() as string), responseType:'text'});
        return xmlOdgovor;
    }

    dobaviRDF(brojPrijave: string) {
        const xmlOdgovor = this.httpClient.get(this.url + '/autorska/dobavi-rdf/' + brojPrijave, {headers: new HttpHeaders().set('Content-Type', 'application/xml').set('Authorization', this.tokenService.getToken() as string), responseType:'text'});
        return xmlOdgovor;
    }

    dobaviJSON(brojPrijave: string) {
        const xmlOdgovor = this.httpClient.get(this.url + '/autorska/dobavi-json/' + brojPrijave, {headers: new HttpHeaders().set('Content-Type', 'application/xml').set('Authorization', this.tokenService.getToken() as string), responseType:'text'});
        return xmlOdgovor;
    }

    dobaviPoTekstu(tekst: string) {
        const xmlOdgovor = this.httpClient.get(this.url + '/autorska/dobavi-tekst/' + tekst, {headers: new HttpHeaders().set('Content-Type', 'application/xml').set('Authorization', this.tokenService.getToken() as string), responseType:'text'});
        return xmlOdgovor;
    }

    dobaviPoMetapodacima(upit: string) {
        const xmlOdgovor = this.httpClient.get(this.url + '/autorska/dobavi-metapodaci/' + upit, {headers: new HttpHeaders().set('Content-Type', 'application/xml').set('Authorization', this.tokenService.getToken() as string), responseType:'text'});
        return xmlOdgovor;
    }
}
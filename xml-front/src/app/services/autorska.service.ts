import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from "@angular/core";
import { environment } from 'src/environments/environment';
import * as JsonToXML from "js2xmlparser";
import { ObrazacAutorskoDeloCreationDTO } from '../models/autorska/ObrazacAutorskoDeloCreationDTO';

@Injectable({
    providedIn: 'root'
  })
export class AutorskaService {

    private url = environment.autorskaApiUrl;

    constructor(private httpClient: HttpClient) {}

    kreirajObrazacZaAutorska(obrazacAutorskoDeloCreationDTO: ObrazacAutorskoDeloCreationDTO) {
        const xmlZahtev = JsonToXML.parse("obrazacAutorskoDeloCreationDTO", obrazacAutorskoDeloCreationDTO);
        console.log(xmlZahtev);
        const xmlOdgovor = this.httpClient.post(this.url + '/autorska/dodaj-autorska', xmlZahtev, {headers: new HttpHeaders().set('Content-Type', 'application/xml'), responseType:'text'});
        return xmlOdgovor;
    }

    dobaviObrazacAutorska(brojPrijave: string) {
        const xmlOdgovor = this.httpClient.get(this.url + '/autorska/dobavi-autorsko/' + brojPrijave, {headers: new HttpHeaders().set('Content-Type', 'application/xml'), responseType:'text'});
        return xmlOdgovor;
    }
    
}
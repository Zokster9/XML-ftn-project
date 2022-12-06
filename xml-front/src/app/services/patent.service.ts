import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { ZahtevZaPriznanjePatentaDto } from '../models/ZahtevZaPriznanjePatentaDTO';
import * as JsonToXML from "js2xmlparser";


@Injectable({
  providedIn: 'root'
})
export class PatentService {
    
  private url = environment.apiUrl;

  constructor(private httpClient: HttpClient) { }

  public addPatent(zahtevZaPriznanjePatentaCreationDto: ZahtevZaPriznanjePatentaDto) {
    const xmlZahtev = JsonToXML.parse("zahtevZaPriznanjePatentaCreationDto", zahtevZaPriznanjePatentaCreationDto);
    const xmlOdgovor = this.httpClient.post(this.url + '/patenti/add-patent', xmlZahtev, {headers: new HttpHeaders().set('Content-Type', 'application/xml'), responseType:'text'});
    return xmlOdgovor;
  }
}
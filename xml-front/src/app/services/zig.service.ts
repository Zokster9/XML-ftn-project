import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { ZahtevZaPriznanjeZigaDTO } from '../models/zig/ZahtevZaPriznanjeZigaDTO';
import * as JsonToXML from "js2xmlparser";
import { TokenService } from './token.service';

@Injectable({
  providedIn: 'root'
})
export class ZigService {

  private url = environment.zigApiUrl;

  constructor(
    private httpClient: HttpClient,
    private tokenService: TokenService
  ) { }

  addZig(zahtevZaPriznanjeZigaDTO: ZahtevZaPriznanjeZigaDTO) {
    const xmlZahtev = JsonToXML.parse("zahtevZaPriznanjeZigaDTO", zahtevZaPriznanjeZigaDTO, {
      
    });
    console.log(xmlZahtev)
    console.log(this.tokenService.getToken() as string);
    return this.httpClient.post(this.url + "/zigovi/", xmlZahtev, {
      headers: new HttpHeaders().set('Content-Type', 'application/xml').set('Authorization', this.tokenService.getToken() as string),
      responseType: 'text'
    })
  }
}

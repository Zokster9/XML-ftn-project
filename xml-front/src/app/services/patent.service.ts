import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { ZahtevZaPriznanjePatentaDto } from '../models/ZahtevZaPriznanjePatentaDTO';

const cabecera = {headers: new HttpHeaders({'Content-Type' : 'application/xml', 'Accept' : 'application/xml'})};

@Injectable({
  providedIn: 'root'
})
export class PatentService {
    
  private url = environment.apiUrl;

  constructor(private httpClient: HttpClient) { }

  public addPatent(zahtevZaPriznanjePatentaCreationDto: ZahtevZaPriznanjePatentaDto) {
    return this.httpClient.post<ZahtevZaPriznanjePatentaDto>(this.url + '/patenti/add-patent', zahtevZaPriznanjePatentaCreationDto, cabecera)
  }
}
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { ZahtevZaPriznanjePatentaDto } from '../models/ZahtevZaPriznanjePatentaDTO';
import * as JsonToXML from "js2xmlparser";
import { PodaciOPrijavamaDto } from '../models/PodaciOPrijavamaDto';
import { PodnosilacDto } from '../models/PodnosilacDto';
import { NovaPrijavaDto } from '../models/NovaPrijavaDto';
import { DodatnaPrijavaDto } from '../models/DodatnaPrijavaDto';
import { PriznanjePravaPrvenstvaDto } from '../models/PriznanjePravaPrvenstvaDto';
import { NazivPronalaskaDto } from '../models/NazivPronalaskaDto';
import { AdresaDto } from '../models/AdresaDto';
import { KontaktPodaciDto } from '../models/KontaktPodaciDto';
import { NacinDostavljanjaDto } from '../models/NacinDostavljanjaDto';
import { PronalazacDto } from '../models/PronalazacDto';
import { PunomocnikDto } from '../models/PunomocnikDto';
import { PriznanjaPravaPrvenstvaDto } from '../models/PriznanjaPravaPrvenstvaDto';


@Injectable({
  providedIn: 'root'
})
export class PatentService {
    
  private url = environment.apiUrl;

  constructor(private httpClient: HttpClient) { }


  public convertResponseToPatent(response : any) : ZahtevZaPriznanjePatentaDto{

    const novaPrijava : NovaPrijavaDto = {
      brojPrijave : response.podaciOPrijavama[0].novaPrijava[0].brojPrijave[0],
      datumPrijave : response.podaciOPrijavama[0].novaPrijava[0].datumPrijave[0],
      priznatiDatumPrijave : response.podaciOPrijavama[0].novaPrijava[0].priznatiDatumPrijave[0]
    }

    const dodatnaPrijava : DodatnaPrijavaDto = {
      tipPrijave : response.podaciOPrijavama[0].dodatnaPrijava[0].tipPrijave[0],
      brojPrvobitnePrijave : response.podaciOPrijavama[0].dodatnaPrijava[0].brojPrvobitnePrijave[0],
      datumPodnosenjaPrijave : response.podaciOPrijavama[0].dodatnaPrijava[0].datumPodnosenjaPrijave[0]
    }

    const priznanjePravaPrvenstva: PriznanjePravaPrvenstvaDto[] = [];

    for (let p of response.podaciOPrijavama[0].priznanjaPravaPrvenstva[0].priznanjaPravaPrvenstva) {
      const jednoPriznanjePravaPrvenstva: PriznanjePravaPrvenstvaDto = {
        datumPrijave: p.datumPrijave[0],
        brojRanijePrijave: p.brojRanijePrijave[0],
        dvoslovnaOznakaDrzaveOrganizacije: p.dvoslovnaOznakaDrzaveOrganizacije[0]
      }
      priznanjePravaPrvenstva.push(jednoPriznanjePravaPrvenstva);
    }

    const priznanjaPravaPrvenstva: PriznanjaPravaPrvenstvaDto = {
      priznanjaPravaPrvenstva: priznanjePravaPrvenstva
    }

    const podaciOPrijavama : PodaciOPrijavamaDto = {
      novaPrijava : novaPrijava,
      dodatnaPrijava : dodatnaPrijava,
      priznanjaPravaPrvenstva : priznanjaPravaPrvenstva
    }

    const nazivPronalaska : NazivPronalaskaDto = {
      engleskiNaziv : response.nazivPronalaska[0].engleskiNaziv[0],
      srpskiNaziv : response.nazivPronalaska[0].srpskiNaziv[0]
    }

    const adresaPodnosilac : AdresaDto = {
      drzava : response.podnosilac[0].adresa[0].drzava[0],
      mesto : response.podnosilac[0].adresa[0].mesto[0],
      postanskiBroj : response.podnosilac[0].adresa[0].postanskiBroj[0],
      ulicaIBroj : response.podnosilac[0].adresa[0].ulicaIBroj[0],
    }

    const kontaktPodaciPodnosilac : KontaktPodaciDto = {
      brojFaksa : response.podnosilac[0].kontaktPodaci[0].brojFaksa[0],
      brojTelefona : response.podnosilac[0].kontaktPodaci[0].brojTelefona[0],
      ePosta : response.podnosilac[0].kontaktPodaci[0].ePosta[0]
    }
    let adresaNacinDostavljanja;
    if (response.podnosilac[0].nacinDostavljanja[0].nacinDostavljanja[0] === "elektronski") {
      adresaNacinDostavljanja = {
        drzava : '',
        mesto : '',
        postanskiBroj : '',
        ulicaIBroj : '',
      };
    }
    else {
      adresaNacinDostavljanja  = {
        drzava : response.podnosilac[0].nacinDostavljanja[0].adresa[0].drzava[0],
        mesto : response.podnosilac[0].nacinDostavljanjaesa[0].adresa[0].mesto[0],
        postanskiBroj : response.podnosilac[0].nacinDostavljanja[0].adresa[0].postanskiBroj[0],
        ulicaIBroj : response.podnosilac[0].nacinDostavljanja[0].adresa[0].ulicaIBroj[0],
      }
    }

    const nacinDostavljanja : NacinDostavljanjaDto = {
      nacinDostavljanja : response.podnosilac[0].nacinDostavljanja[0].nacinDostavljanja[0],
      adresa : adresaNacinDostavljanja,
      email : response.podnosilac[0].nacinDostavljanja[0].email[0]
    }
    

    const podnosilac : PodnosilacDto = {
      naziv : response.podnosilac[0].naziv[0],
      podnosilacJePronalazac : response.podnosilac[0].podnosilacJePronalazac[0],
      drzavljanstvo : response.podnosilac[0].drzavljanstvo[0],
      adresa : adresaPodnosilac,
      kontaktPodaci : kontaktPodaciPodnosilac,
      nacinDostavljanja : nacinDostavljanja
    }


    const kontaktPodaciPronalazac : KontaktPodaciDto = {
      brojFaksa : response.pronalazac[0].kontaktPodaci[0].brojFaksa[0],
      brojTelefona : response.pronalazac[0].kontaktPodaci[0].brojTelefona[0],
      ePosta : response.pronalazac[0].kontaktPodaci[0].ePosta[0]
    }

    
    const adresaPronalazac : AdresaDto = {
      drzava : response.pronalazac[0].adresa[0].drzava[0],
      mesto : response.pronalazac[0].adresa[0].mesto[0],
      postanskiBroj : response.pronalazac[0].adresa[0].postanskiBroj[0],
      ulicaIBroj : response.pronalazac[0].adresa[0].ulicaIBroj[0],
    }


    const pronalazac : PronalazacDto = {
      naziv : response.pronalazac[0].naziv[0],
      zeliBitiUPrijavi : response.pronalazac[0].zeliBitiUPrijavi[0],
      adresa : adresaPronalazac,
      kontaktPodaci : kontaktPodaciPronalazac
    }


    const kontaktPodaciPunomocnik : KontaktPodaciDto = {
      brojFaksa : response.punomocnik[0].kontaktPodaci[0].brojFaksa[0],
      brojTelefona : response.punomocnik[0].kontaktPodaci[0].brojTelefona[0],
      ePosta : response.punomocnik[0].kontaktPodaci[0].ePosta[0]
    }

    
    const adresaPunomocnik : AdresaDto = {
      drzava : response.punomocnik[0].adresa[0].drzava[0],
      mesto : response.punomocnik[0].adresa[0].mesto[0],
      postanskiBroj : response.punomocnik[0].adresa[0].postanskiBroj[0],
      ulicaIBroj : response.punomocnik[0].adresa[0].ulicaIBroj[0],
    }

    const punomocnik : PunomocnikDto = {
      naziv : response.punomocnik[0].naziv[0],
      tipPunomocnika : response.punomocnik[0].tipPunomocnika[0],
      zajednickiPredstavnik : response.punomocnik[0].zajednickiPredstavnik[0],
      kontaktPodaci : kontaktPodaciPunomocnik,
      adresa : adresaPunomocnik
    }

    const zahtevZaPriznanjePatenta : ZahtevZaPriznanjePatentaDto = {
      nazivPronalaska : nazivPronalaska,
      podaciOPrijavama : podaciOPrijavama,
      podnosilac : podnosilac,
      pronalazac : pronalazac,
      punomocnik : punomocnik
    }

    return zahtevZaPriznanjePatenta;
    
  }

  public addPatent(zahtevZaPriznanjePatentaCreationDto: ZahtevZaPriznanjePatentaDto) {
    const xmlZahtev = JsonToXML.parse("zahtevZaPriznanjePatentaCreationDto", zahtevZaPriznanjePatentaCreationDto);
    const xmlOdgovor = this.httpClient.post(this.url + '/patenti/add-patent', xmlZahtev, {headers: new HttpHeaders().set('Content-Type', 'application/xml'), responseType:'text'});
    return xmlOdgovor;
  }

  public getPatent() {
    const xmlOdgovor = this.httpClient.get(this.url + '/patenti/get-patent', {headers: new HttpHeaders().set('Content-Type', 'application/xml'), responseType:'text'});
    return xmlOdgovor;
  }

  public getAllPatenti() {
    const xmlOdgovor = this.httpClient.get(this.url + '/patenti/get-all-patenti', {headers: new HttpHeaders().set('Content-Type', 'application/xml'), responseType: 'text'});
    return xmlOdgovor;
  }

  public showHTML(zahtev : ZahtevZaPriznanjePatentaDto) {
    const xmlZahtev = JsonToXML.parse("zahtevZaPriznanjePatentaCreationDto", zahtev);
    const xmlOdgovor = this.httpClient.post(this.url + '/patenti/create-patent-html', xmlZahtev, {headers: new HttpHeaders().set('Content-type', 'application/xml'), responseType: 'text'});
    return xmlOdgovor;
  }

  public showPDF(zahtev : ZahtevZaPriznanjePatentaDto) {
    const xmlZahtev = JsonToXML.parse("zahtevZaPriznanjePatentaCreationDto", zahtev);
    return this.httpClient.post(this.url + '/patenti/create-patent-pdf', xmlZahtev, {headers: new HttpHeaders().set('Content-type', 'application/xml'), responseType: 'text'});
  }
}
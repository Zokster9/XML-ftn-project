import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { ZahtevZaPriznanjeZigaDTO } from '../models/zig/ZahtevZaPriznanjeZigaDTO';
import * as JsonToXML from "js2xmlparser";
import { TokenService } from './token.service';
import { PodnosiociPrijaveDTO } from '../models/zig/PodnosiociPrijaveDTO';
import { FizickoLiceDTO } from '../models/zig/FizickoLiceDTO';
import { PravnoLiceDTO } from '../models/zig/PravnoLiceDTO';
import { ZigDTO } from '../models/zig/ZigDTO';
import { NaznaceneBojeDTO } from '../models/zig/NaznaceneBojeDTO';
import { BojaDTO } from '../models/zig/BojaDTO';
import { KlaseRobeIUslugaDTO } from '../models/zig/KlaseRobeIUslugaDTO';
import { PlaceneTakseDTO } from '../models/zig/PlaceneTakseDTO';
import { PodaciOPrijaviDTO } from '../models/zig/PodaciOPrijaviDTO';

@Injectable({
  providedIn: 'root'
})
export class ZigService {

  private url = environment.zigApiUrl;

  constructor(
    private httpClient: HttpClient,
    private tokenService: TokenService
  ) { }

  convertResponseToZig(response: any): ZahtevZaPriznanjeZigaDTO | null {
    const fizickiPodnosiociPrijave: FizickoLiceDTO[] = [];
    for (let fizickiPodnosilac of response.podnosiociPrijave[0].fizickiPodnosiociPrijave[0].fizickiPodnosiociPrijave) {
      fizickiPodnosiociPrijave.push({
        ime: fizickiPodnosilac.ime[0],
        prezime: fizickiPodnosilac.prezime[0],
        adresa: {
          broj: fizickiPodnosilac.adresa[0].broj[0],
          drzava: fizickiPodnosilac.adresa[0].drzava[0],
          mesto: fizickiPodnosilac.adresa[0].mesto[0],
          postanskiBroj: fizickiPodnosilac.adresa[0].postanskiBroj[0],
          ulica: fizickiPodnosilac.adresa[0].ulica[0],
        },
        kontaktPodaci: {
          brojFaksa: fizickiPodnosilac.kontaktPodaci[0].brojFaksa[0],
          brojTelefona: fizickiPodnosilac.kontaktPodaci[0].brojTelefona[0],
          email: fizickiPodnosilac.kontaktPodaci[0].email[0],
        }
      });
    }
    
    const pravniPodnosiociPrijave: PravnoLiceDTO[] = [];
    for (let pravniPodnosilac of response.podnosiociPrijave[0].pravniPodnosiociPrijave[0].pravniPodnosiociPrijave) {
      pravniPodnosiociPrijave.push({
        naziv: pravniPodnosilac.naziv[0],
        adresa: {
          broj: pravniPodnosilac.adresa[0].broj[0],
          drzava: pravniPodnosilac.adresa[0].drzava[0],
          mesto: pravniPodnosilac.adresa[0].mesto[0],
          postanskiBroj: pravniPodnosilac.adresa[0].postanskiBroj[0],
          ulica: pravniPodnosilac.adresa[0].ulica[0],
        },
        kontaktPodaci: {
          brojFaksa: pravniPodnosilac.kontaktPodaci[0].brojFaksa[0],
          brojTelefona: pravniPodnosilac.kontaktPodaci[0].brojTelefona[0],
          email: pravniPodnosilac.kontaktPodaci[0].email[0],
        }
      });
    }
    const podnosiociPrijave: PodnosiociPrijaveDTO = {
      fizickiPodnosiociPrijave: {
        fizickiPodnosioci: fizickiPodnosiociPrijave,
      },
      pravniPodnosiociPrijave: {
        pravniPodnosioci: pravniPodnosiociPrijave,
      }
    };

    let punomocnik: FizickoLiceDTO | undefined = undefined;
    if (response.punomocnik[0]) {
      punomocnik = {
        ime: response.punomocnik[0].ime[0],
        prezime: response.punomocnik[0].prezime[0],
        adresa: {
          broj: response.punomocnik[0].adresa[0].broj[0],
          drzava: response.punomocnik[0].adresa[0].drzava[0],
          mesto: response.punomocnik[0].adresa[0].mesto[0],
          postanskiBroj: response.punomocnik[0].adresa[0].postanskiBroj[0],
          ulica: response.punomocnik[0].adresa[0].ulica[0],
        },
        kontaktPodaci: {
          brojFaksa: response.punomocnik[0].kontaktPodaci[0].brojFaksa[0],
          brojTelefona: response.punomocnik[0].kontaktPodaci[0].brojTelefona[0],
          email: response.punomocnik[0].kontaktPodaci[0].email[0],
        }
      }
    }

    let fizickiZajednickiPredstavnikPodnosiocaPrijave: FizickoLiceDTO | undefined = undefined;
    if (response.fizickiZajednickiPredstavnikPodnosiocaPrijave[0]) {
      fizickiZajednickiPredstavnikPodnosiocaPrijave = {
        ime: response.fizickiZajednickiPredstavnikPodnosiocaPrijave[0].ime[0],
        prezime: response.fizickiZajednickiPredstavnikPodnosiocaPrijave[0].prezime[0],
        adresa: {
          broj: response.fizickiZajednickiPredstavnikPodnosiocaPrijave[0].adresa[0].broj[0],
          drzava: response.fizickiZajednickiPredstavnikPodnosiocaPrijave[0].adresa[0].drzava[0],
          mesto: response.fizickiZajednickiPredstavnikPodnosiocaPrijave[0].adresa[0].mesto[0],
          postanskiBroj: response.fizickiZajednickiPredstavnikPodnosiocaPrijave[0].adresa[0].postanskiBroj[0],
          ulica: response.fizickiZajednickiPredstavnikPodnosiocaPrijave[0].adresa[0].ulica[0],
        },
        kontaktPodaci: {
          brojFaksa: response.fizickiZajednickiPredstavnikPodnosiocaPrijave[0].kontaktPodaci[0].brojFaksa[0],
          brojTelefona: response.fizickiZajednickiPredstavnikPodnosiocaPrijave[0].kontaktPodaci[0].brojTelefona[0],
          email: response.fizickiZajednickiPredstavnikPodnosiocaPrijave[0].kontaktPodaci[0].email[0],
        }
      }
    }

    let pravniZajednickiPredstavnikPodnosiocaPrijave: PravnoLiceDTO | undefined = undefined;
    if (response.pravniZajednickiPredstavnikPodnosiocaPrijave[0]) {
      pravniZajednickiPredstavnikPodnosiocaPrijave = {
        naziv: response.pravniZajednickiPredstavnikPodnosiocaPrijave[0].naziv[0],
        adresa: {
          broj: response.pravniZajednickiPredstavnikPodnosiocaPrijave[0].adresa[0].broj[0],
          drzava: response.pravniZajednickiPredstavnikPodnosiocaPrijave[0].adresa[0].drzava[0],
          mesto: response.pravniZajednickiPredstavnikPodnosiocaPrijave[0].adresa[0].mesto[0],
          postanskiBroj: response.pravniZajednickiPredstavnikPodnosiocaPrijave[0].adresa[0].postanskiBroj[0],
          ulica: response.pravniZajednickiPredstavnikPodnosiocaPrijave[0].adresa[0].ulica[0],
        },
        kontaktPodaci: {
          brojFaksa: response.pravniZajednickiPredstavnikPodnosiocaPrijave[0].kontaktPodaci[0].brojFaksa[0],
          brojTelefona: response.pravniZajednickiPredstavnikPodnosiocaPrijave[0].kontaktPodaci[0].brojTelefona[0],
          email: response.pravniZajednickiPredstavnikPodnosiocaPrijave[0].kontaktPodaci[0].email[0],
        }
      }
    }

    let naznaceneBoje: NaznaceneBojeDTO | undefined = undefined;
    if (response.zig[0].naznaceneBoje[0].boja) {
      naznaceneBoje = {
        boja: {
          boja: response.zig[0].naznaceneBoje[0].boja[0].boja,
        }
      }
    }

    const zig: ZigDTO = {
      tipZiga: {
        individualniZig: response.zig[0].tipZiga[0].individualniZig[0],
        kolektivniZig: response.zig[0].tipZiga[0].kolektivniZig[0],
        zigGarancije: response.zig[0].tipZiga[0].zigGarancije[0],
      },
      tipZnaka: {
        verbalniZnak: response.zig[0].tipZnaka[0].verbalniZnak[0],
        grafickiZnak: response.zig[0].tipZnaka[0].grafickiZnak[0],
        kombinovaniZnak: response.zig[0].tipZnaka[0].kombinovaniZnak[0],
        trodimenzionalniZnak: response.zig[0].tipZnaka[0].trodimenzionalniZnak[0],
        drugaVrstaZnaka: response.zig[0].tipZnaka[0].drugaVrstaZnaka[0],
      },
      izgledZnaka: {
        imageUrl: response.zig[0].izgledZnaka[0].imageUrl[0],
      },
      naznaceneBoje,
      transliteracijaZnaka: response.zig[0].transliteracijaZnaka[0],
      prevodZnaka: response.zig[0].prevodZnaka[0],
      opisZnaka: response.zig[0].opisZnaka[0],
    }

    const klaseRobeIUsluga: KlaseRobeIUslugaDTO = {
      klasa: {
        klasa: response.klaseRobeIUsluga[0].klasa[0].klasa,
      }
    };

    const pravoPrvenstvaIOsnov: string | undefined = response.pravoPrvenstvaIOsnov[0];

    const placeneTakse: PlaceneTakseDTO = {
      osnovnaTaksa: response.placeneTakse[0].osnovnaTaksa[0],
      taksaZaKlase: {
        brojKlasa: response.placeneTakse[0].taksaZaKlase[0].brojKlasa[0],
        vrednost: response.placeneTakse[0].taksaZaKlase[0].vrednost[0],
      },
      taksaZaGrafickoResenje: response.placeneTakse[0].taksaZaGrafickoResenje[0],
      ukupnaTaksa: response.placeneTakse[0].ukupnaTaksa[0],
    }

    const podaciOPrijavi: PodaciOPrijaviDTO = {
      priloziUzZahtev: {
        primerakZnaka: this.returnPrilogUzZahtev(response.podaciOPrijavi[0].priloziUzZahtev[0].primerakZnaka[0]),
        spisakRobeIUsluga: this.returnPrilogUzZahtev(response.podaciOPrijavi[0].priloziUzZahtev[0].spisakRobeIUsluga[0]),
        punomocje: this.returnPrilogUzZahtev(response.podaciOPrijavi[0].priloziUzZahtev[0].punomocje[0]),
        generalnoPunomocjeRanijePrilozeno: response.podaciOPrijavi[0].priloziUzZahtev[0].generalnoPunomocjeRanijePrilozeno[0],
        punomocjeCeBitiNaknadnoDostavljeno: response.podaciOPrijavi[0].priloziUzZahtev[0].punomocjeCeBitiNaknadnoDostavljeno[0],
        opstiAktOKolektivnomZigu: this.returnPrilogUzZahtev(response.podaciOPrijavi[0].priloziUzZahtev[0].opstiAktOKolektivnomZigu[0]),
        dokazOPravuPrvenstva: this.returnPrilogUzZahtev(response.podaciOPrijavi[0].priloziUzZahtev[0].dokazOPravuPrvenstva[0]),
        dokazOUplatiTakse: this.returnPrilogUzZahtev(response.podaciOPrijavi[0].priloziUzZahtev[0].dokazOUplatiTakse[0]),
      },
      brojPrijaveZiga: response.podaciOPrijavi[0].brojPrijaveZiga[0],
      datumPodnosenja: response.podaciOPrijavi[0].datumPodnosenja[0],
      datumPrihvatanja: response.podaciOPrijavi[0].datumPrihvatanja[0],
    }

    return {
      podnosiociPrijave,
      punomocnik,
      fizickiZajednickiPredstavnikPodnosiocaPrijave,
      pravniZajednickiPredstavnikPodnosiocaPrijave,
      pravoPrvenstvaIOsnov,
      klaseRobeIUsluga,
      placeneTakse,
      podaciOPrijavi,
      zig,
    };
  }

  private returnPrilogUzZahtev(prilog: any) {
    if (prilog) {
      return {
        nazivDokumenta: prilog.nazivDokumenta[0],
        putanjaDokumenta: prilog.putanjaDokumenta[0],
      }
    }
    return undefined
  }

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

  getAllZigovi() {
    return this.httpClient.get(this.url + "/zigovi/", {
      headers: new HttpHeaders()
        .set('Content-Type', 'application/xml')
        .set('Authorization', this.tokenService.getToken() as string), responseType: 'text'
    });
  }
}

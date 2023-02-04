import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { environment } from "src/environments/environment";
import { ResenjeZahtevaDTO, ResenjeZahtevaDto } from "../models/ResenjeZahtevaDto";
import * as JsonToXML from "js2xmlparser";
import { IzvestajDatumiDTO, ReportDatesDto } from "../models/ReportDatesDto";
import { TokenService } from "./token.service";

@Injectable({
    providedIn: 'root'
})
export class ResenjeZahtevaService {

    private url = environment.apiUrl;

    private autorskaUrl = environment.autorskaApiUrl;

    private zigUrl = environment.zigApiUrl;

    constructor(private httpClient: HttpClient, private tokenService: TokenService) { }

    public addResenjeZahteva(resenjeZahtevaDto: ResenjeZahtevaDto, token: string) {
        const xmlZahtev = JsonToXML.parse("resenjeZahtevaDto", resenjeZahtevaDto);
        const xmlOdgovor = this.httpClient.post(this.url + '/resenja-zahteva/add-resenje-zahteva', xmlZahtev, {headers: new HttpHeaders().set('Content-Type', 'application/xml').set('Authorization', token), responseType:'text'});
        return xmlOdgovor;
    }

    public createReport(reportDatesDto: ReportDatesDto, token: string) {
        const xmlZahtev = JsonToXML.parse("reportDatesDto", reportDatesDto);
        const xmlOdgovor = this.httpClient.post(this.url + '/resenja-zahteva/create-report', xmlZahtev, {headers: new HttpHeaders().set('Content-Type', 'application/xml').set('Authorization', token), responseType:'text'});
        return xmlOdgovor;
    }

    public showResenjeZahtevaThatReferencesTo(number: string) {
        return this.httpClient.get(`http://localhost:9000/resenja-zahteva/get-resenje-zahteva-that-references-to/${number}`,{headers: new HttpHeaders().set('Content-type', 'application/xml'), responseType: 'text'});
    }

    public dobaviSvaResenjaAutorska() {
        return this.httpClient.get(this.autorskaUrl + '/resenja-zahteva/dobavi-sve', {headers: new HttpHeaders().set('Content-type', 'application/xml').set('Authorization', this.tokenService.getToken() as string), responseType: 'text'});
    }

    public kreirajResenjeAutorska(resenjeZahtevaDTO: ResenjeZahtevaDTO) {
        const xmlZahtev = JsonToXML.parse("resenjeZahtevaDTO", resenjeZahtevaDTO);
        const xmlOdgovor = this.httpClient.post(this.autorskaUrl + '/resenja-zahteva/dodaj-resenje-zahteva', xmlZahtev, {headers: new HttpHeaders().set('Content-Type', 'application/xml').set('Authorization', this.tokenService.getToken() as string), responseType:'text'});
        return xmlOdgovor;
    }

    public kreirajIzvestajAutorska(izvestajDatumiDTO: IzvestajDatumiDTO) {
        const xmlZahtev = JsonToXML.parse("izvestajDatumiDTO", izvestajDatumiDTO);
        const xmlOdgovor = this.httpClient.post(this.autorskaUrl + '/resenja-zahteva/kreiraj-izvestaj', xmlZahtev, {headers: new HttpHeaders().set('Content-Type', 'application/xml').set('Authorization', this.tokenService.getToken() as string), responseType:'text'});
        return xmlOdgovor;
    }

    public prikaziResenjeKojeReferenciraNaZahtevAutorsko(brojAutorskog: string) {
        const xmlOdgovor = this.httpClient.get(this.autorskaUrl + '/resenja-zahteva/dobavi-po-broju-zahteva/' + brojAutorskog, {headers: new HttpHeaders().set('Content-Type', 'application/xml').set('Authorization', this.tokenService.getToken() as string), responseType:'text'});
        return xmlOdgovor;
    }

    public generisiIzvestajAutorska(izvestajDatumiDTO: IzvestajDatumiDTO) {
        const xmlZahtev = JsonToXML.parse("izvestajDatumiDTO", izvestajDatumiDTO);
        const xmlOdgovor = this.httpClient.post(this.autorskaUrl + '/resenja-zahteva/kreiraj-izvestaj', xmlZahtev, {headers: new HttpHeaders().set('Content-Type', 'application/xml').set('Authorization', this.tokenService.getToken() as string), responseType:'text'});
        return xmlOdgovor;
    }

    public getAllResenjaZig() {
        return this.httpClient.get(this.zigUrl + '/resenja-zahteva/', {
            headers: new HttpHeaders().set('Content-type', 'application/xml')
                .set('Authorization', this.tokenService.getToken() as string), responseType: 'text'
        });
    }

    public addResenjeZig(resenjeZahtevaDTO: ResenjeZahtevaDTO) {
        const xmlZahtev = JsonToXML.parse("resenjeZahtevaDTO", resenjeZahtevaDTO);
        return this.httpClient.post(this.zigUrl + '/resenja-zahteva/', xmlZahtev, {
            headers: new HttpHeaders().set('Content-Type', 'application/xml')
                .set('Authorization', this.tokenService.getToken() as string), responseType: 'text'
        });
    }

    public createIzvestajZig(izvestajDatumiDTO: IzvestajDatumiDTO) {
        const xmlZahtev = JsonToXML.parse("izvestajDatumiDTO", izvestajDatumiDTO);
        return this.httpClient.post(this.zigUrl + '/resenja-zahteva/kreiraj-izvestaj', xmlZahtev, {
            headers: new HttpHeaders().set('Content-Type', 'application/xml')
                .set('Authorization', this.tokenService.getToken() as string), responseType: 'text'
        });
    }

    public showResenjeKojeReferenciraNaZahtevZig(brojZiga: string) {
        return this.httpClient.get(this.zigUrl + '/resenja-zahteva/' + brojZiga, {
            headers: new HttpHeaders().set('Content-Type', 'application/xml')
                .set('Authorization', this.tokenService.getToken() as string), responseType: 'text'
        });
    }

    public generateIzvestajZig(izvestajDatumiDTO: IzvestajDatumiDTO) {
        const xmlZahtev = JsonToXML.parse("izvestajDatumiDTO", izvestajDatumiDTO);
        return this.httpClient.post(this.zigUrl + '/resenja-zahteva/kreiraj-izvestaj', xmlZahtev, {
            headers: new HttpHeaders().set('Content-Type', 'application/xml')
                .set('Authorization', this.tokenService.getToken() as string), responseType: 'text'
        });
    }
}
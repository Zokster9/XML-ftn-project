import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { environment } from "src/environments/environment";
import { ResenjeZahtevaDto } from "../models/ResenjeZahtevaDto";
import * as JsonToXML from "js2xmlparser";
import { ReportDatesDto } from "../models/ReportDatesDto";

@Injectable({
    providedIn: 'root'
})
export class ResenjeZahtevaService {

    private url = environment.apiUrl;

    constructor(private httpClient: HttpClient) { }

    public addResenjeZahteva(resenjeZahtevaDto: ResenjeZahtevaDto) {
        const xmlZahtev = JsonToXML.parse("resenjeZahtevaDto", resenjeZahtevaDto);
        const xmlOdgovor = this.httpClient.post(this.url + '/resenja-zahteva/add-resenje-zahteva', xmlZahtev, {headers: new HttpHeaders().set('Content-Type', 'application/xml'), responseType:'text'});
        return xmlOdgovor;
    }

    public createReport(reportDatesDto: ReportDatesDto) {
        const xmlZahtev = JsonToXML.parse("reportDatesDto", reportDatesDto);
        const xmlOdgovor = this.httpClient.post(this.url + '/resenja-zahteva/create-report', xmlZahtev, {headers: new HttpHeaders().set('Content-Type', 'application/xml'), responseType:'text'});
        return xmlOdgovor;
    }
}
import { PodaciOAutoruDTO } from "./PodaciOAutoruDTO";

export interface PodaciOAutorskomDeluDTO {
    naslov: string;
    alternativniNaslov: string;
    vrsta: string;
    formaZapisa: string;
    stvorenoURadnomOdnosu: boolean;
    anonimniAutor: boolean;
    autori: PodaciOAutoruDTO[];
    naslovAutorskogDelaPrerade: string;
}
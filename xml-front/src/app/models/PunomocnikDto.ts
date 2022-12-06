import { AdresaDto } from "./AdresaDto";
import { KontaktPodaciDto } from "./KontaktPodaciDto";

export interface PunomocnikDto {
    tipPunomocnika: string;
    zajednickiPredstavnik: boolean;
    naziv: string;
    adresa: AdresaDto;
    kontaktPodaci: KontaktPodaciDto
}
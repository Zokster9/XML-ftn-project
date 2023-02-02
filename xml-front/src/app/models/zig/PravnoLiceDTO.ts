import { AdresaDTO } from "./AdresaDTO";
import { KontaktPodaciDTO } from "./KontaktPodaciDTO";

export interface PravnoLiceDTO {
    naziv: string;
    adresa: AdresaDTO;
    kontaktPodaci: KontaktPodaciDTO;
}
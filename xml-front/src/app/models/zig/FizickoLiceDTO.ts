import { AdresaDTO } from "./AdresaDTO";
import { KontaktPodaciDTO } from "./KontaktPodaciDTO";

export interface FizickoLiceDTO {
    ime: string;
    prezime: string;
    adresa: AdresaDTO;
    kontaktPodaci: KontaktPodaciDTO;
}
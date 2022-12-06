import { AdresaDto } from "./AdresaDto";
import { KontaktPodaciDto } from "./KontaktPodaciDto";

export interface PronalazacDto {
    naziv: string;
    adresa: AdresaDto;
    kontaktPodaci: KontaktPodaciDto;
    zeliBitiUPrijavi: boolean;
}
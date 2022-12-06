import { AdresaDto } from "./AdresaDto";
import { KontaktPodaciDto } from "./KontaktPodaciDto";
import { NacinDostavljanjaDto } from "./NacinDostavljanjaDto";

export interface PodnosilacDto {
    naziv: string;
    drzavljanstvo: string;
    adresa: AdresaDto;
    kontaktPodaci: KontaktPodaciDto;
    podnosilacJePronalazac: boolean;
    nacinDostavljanja: NacinDostavljanjaDto;
}
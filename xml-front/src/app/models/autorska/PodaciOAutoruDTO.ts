import { AdresaDTO } from "../AdresaDto";

export interface PodaciOAutoruDTO {
    ime: string;
    prezime: string;
    drzavljanstvo?: string;
    godinaSmrti?: string;
    adresa?: AdresaDTO;
}
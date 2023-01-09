import { AdresaDTO } from "../AdresaDto";

export interface FizickoLiceDTO {
    email: string;
    telefon: string;
    ime: string;
    prezime: string;
    drzavljanstvo: string;
    adresaLica: AdresaDTO
}
import { AdresaDTO } from "../AdresaDto";

export interface PravnoLiceDTO {
    email: string;
    telefon: string;
    poslovnoIme: string;
    sediste: AdresaDTO;
}
export interface ResenjeZahtevaDto {
    datumResenja: string,
    zahtevJePrihvacen: boolean,
    sifra: string,
    obrazlozenje: string,
    referenca: string
}

export interface ResenjeZahtevaDTO {
    datumResenja: number;
    zahtevJePrihvacen: boolean;
    sifra?: string;
    obrazlozenje?: string;
    referenca: string;
    imeSluzbenika: string;
    prezimeSluzbenika: string;
}
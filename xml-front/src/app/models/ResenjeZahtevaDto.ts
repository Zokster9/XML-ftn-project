export interface ResenjeZahtevaDto {
    datumResenja: string,
    zahtevJePrihvacen: boolean,
    sifra: string,
    obrazlozenje: string,
    referenca: string
}

export interface ResenjeZahtevaDTO {
    brojResenjaZahteva?: string;
    datumResenja?: Date;
    zahtevJePrihvacen: boolean;
    sifra?: string;
    obrazlozenje?: string;
    referenca: string;
    imeSluzbenika?: string;
    prezimeSluzbenika?: string;
}
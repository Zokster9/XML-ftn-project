import { TaksaZaKlaseDTO } from "./TaksaZaKlaseDTO";

export interface PlaceneTakseDTO {
    osnovnaTaksa: number;
    taksaZaKlase: TaksaZaKlaseDTO;
    taksaZaGrafickoResenje: number;
    ukupnaTaksa: number;
}
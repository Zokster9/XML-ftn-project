import { PriloziUzZahtevDTO } from "./PriloziUzZahtevDTO";

export interface PodaciOPrijaviDTO {
    priloziUzZahtev: PriloziUzZahtevDTO;
    brojPrijaveZiga?: string;
    datumPodnosenja?: Date;
    datumPrihvatanja?: Date;
}
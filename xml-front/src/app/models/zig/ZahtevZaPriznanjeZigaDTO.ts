import { KlaseRobeIUslugaDTO } from "./KlaseRobeIUslugaDTO";
import { LiceDTO } from "./LiceDTO";
import { PlaceneTakseDTO } from "./PlaceneTakseDTO";
import { PodaciOPrijaviDTO } from "./PodaciOPrijaviDTO";
import { PodnosiociPrijaveDTO } from "./PodnosiociPrijaveDTO";
import { ZigDTO } from "./ZigDTO";

export interface ZahtevZaPriznanjeZigaDTO {
    podnosiociPrijave: PodnosiociPrijaveDTO;
    punomocnik: LiceDTO;
    zajednickiPredstavnikPodnosiocaPrijave: LiceDTO;
    zig: ZigDTO;
    klaseRobeIUsluga: KlaseRobeIUslugaDTO;
    pravoPrvenstvaIOsnov: string;
    placeneTakse: PlaceneTakseDTO;
    podaciOPrijavi: PodaciOPrijaviDTO
}
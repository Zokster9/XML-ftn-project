import { FizickoLiceDTO } from "./FizickoLiceDTO";
import { KlaseRobeIUslugaDTO } from "./KlaseRobeIUslugaDTO";
import { PlaceneTakseDTO } from "./PlaceneTakseDTO";
import { PodaciOPrijaviDTO } from "./PodaciOPrijaviDTO";
import { PodnosiociPrijaveDTO } from "./PodnosiociPrijaveDTO";
import { PravnoLiceDTO } from "./PravnoLiceDTO";
import { ZigDTO } from "./ZigDTO";

export interface ZahtevZaPriznanjeZigaDTO {
    podnosiociPrijave: PodnosiociPrijaveDTO;
    punomocnik?: FizickoLiceDTO;
    fizickiZajednickiPredstavnikPodnosiocaPrijave?: FizickoLiceDTO;
    pravniZajednickiPredstavnikPodnosiocaPrijave?: PravnoLiceDTO;
    zig: ZigDTO;
    klaseRobeIUsluga: KlaseRobeIUslugaDTO;
    pravoPrvenstvaIOsnov?: string;
    placeneTakse: PlaceneTakseDTO;
    podaciOPrijavi: PodaciOPrijaviDTO
}
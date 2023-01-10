import { FizickoLiceDTO } from "./FizickoLiceDTO";
import { PodaciOAutorskomDeluDTO } from "./PodaciOAutorskomDeluDTO";
import { PravnoLiceDTO } from "./PravnoLiceDTO";
import { PriloziUzPrijavuDTO } from "./PriloziUzPrijavuDTO";
import { PunomocnikDTO } from "./PunomocnikDTO";

export interface ObrazacAutorskoDeloDTO {
    brojPrijave: string;
    datumPrijave: number;
    fizickoLiceDTO?: FizickoLiceDTO;
    pravnoLiceDTO?: PravnoLiceDTO;
    punomocnikDTO?: PunomocnikDTO;
    podaciOAutorskomDeluDTO: PodaciOAutorskomDeluDTO;
    priloziUzPrijavuDTO?: PriloziUzPrijavuDTO;
    podnosilacAutor: boolean;
}
import { NazivPronalaskaDto } from "./NazivPronalaskaDto";
import { PodaciOPrijavamaDto } from "./PodaciOPrijavamaDto";
import { PodnosilacDto } from "./PodnosilacDto";
import { PronalazacDto } from "./PronalazacDto";
import { PunomocnikDto } from "./PunomocnikDto";

export interface ZahtevZaPriznanjePatentaDto {

    podaciOPrijavama: PodaciOPrijavamaDto;
    nazivPronalaska:  NazivPronalaskaDto;
    podnosilac: PodnosilacDto;
    pronalazac: PronalazacDto;
    punomocnik: PunomocnikDto;
}
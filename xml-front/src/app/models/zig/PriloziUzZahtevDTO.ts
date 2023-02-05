import { PrilogUzZahtevDTO } from "./PrilogUzZahtevDTO";

export interface PriloziUzZahtevDTO {
    primerakZnaka?: PrilogUzZahtevDTO;
    spisakRobeIUsluga?: PrilogUzZahtevDTO;
    punomocje?: PrilogUzZahtevDTO;
    generalnoPunomocjeRanijePrilozeno: boolean;
    punomocjeCeBitiNaknadnoDostavljeno: boolean;
    opstiAktOKolektivnomZigu?: PrilogUzZahtevDTO;
    dokazOPravuPrvenstva?: PrilogUzZahtevDTO;
    dokazOUplatiTakse?: PrilogUzZahtevDTO;
}
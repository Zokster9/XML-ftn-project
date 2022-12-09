import { DodatnaPrijavaDto } from "./DodatnaPrijavaDto";
import { NovaPrijavaDto } from "./NovaPrijavaDto"
import { PriznanjePravaPrvenstvaDto } from "./PriznanjePravaPrvenstvaDto";

export interface PodaciOPrijavamaDto {
    novaPrijava: NovaPrijavaDto;
    dodatnaPrijava: DodatnaPrijavaDto;
    priznanjaPravaPrvenstva: PriznanjePravaPrvenstvaDto[];
}
import { DodatnaPrijavaDto } from "./DodatnaPrijavaDto";
import { NovaPrijavaDto } from "./NovaPrijavaDto"
import { PriznanjaPravaPrvenstvaDto } from "./PriznanjaPravaPrvenstvaDto";
import { PriznanjePravaPrvenstvaDto } from "./PriznanjePravaPrvenstvaDto";

export interface PodaciOPrijavamaDto {
    novaPrijava: NovaPrijavaDto;
    dodatnaPrijava: DodatnaPrijavaDto;
    priznanjaPravaPrvenstva: PriznanjaPravaPrvenstvaDto;
}
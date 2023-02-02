import { IzgledZnakaDTO } from "./IzgledZnakaDTO";
import { NaznaceneBojeDTO } from "./NaznaceneBojeDTO";
import { TipZigaDTO } from "./TipZigaDTO";
import { TipZnakaDTO } from "./TipZnakaDTO";

export interface ZigDTO {
    tipZiga: TipZigaDTO;
    tipZnaka: TipZnakaDTO;
    izgledZnaka: IzgledZnakaDTO;
    naznaceneBoje?: NaznaceneBojeDTO;
    transliteracijaZnaka?: string;
    prevodZnaka?: string;
    opisZnaka?: string;
}
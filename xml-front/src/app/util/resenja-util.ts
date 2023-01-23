import { ResenjeZahtevaDTO } from "../models/ResenjeZahtevaDto";

export default class ResenjaZahtevaUtil {

    transformisiResenjeZahteva(odgovor: any) : ResenjeZahtevaDTO {
        let resenjeZahteva : ResenjeZahtevaDTO = {
            brojResenjaZahteva: odgovor.brojResenjaZahteva[0],
            datumResenja: new Date(odgovor.datumResenja[0]),
            zahtevJePrihvacen: Boolean(odgovor.zahtevJePrihvacen[0]),
            sifra: odgovor.sifra[0],
            obrazlozenje: odgovor.obrazlozenje[0],
            imeSluzbenika: odgovor.imeSluzbenika[0],
            prezimeSluzbenika: odgovor.prezimeSluzbenika[0],
            referenca: odgovor.referenca[0]
        };
        return resenjeZahteva;
    }
}
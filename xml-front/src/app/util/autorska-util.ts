import { FormArray, FormControl, FormGroup } from "@angular/forms";
import { AdresaDTO } from "../models/AdresaDto";
import { FizickoLiceDTO } from "../models/autorska/FizickoLiceDTO";
import { ObrazacAutorskoDeloDTO } from "../models/autorska/ObrazacAutorskoDeloDTO";
import { PodaciOAutorskomDeluDTO } from "../models/autorska/PodaciOAutorskomDeluDTO";
import { PodaciOAutoruDTO } from "../models/autorska/PodaciOAutoruDTO";
import { PravnoLiceDTO } from "../models/autorska/PravnoLiceDTO";
import { PriloziUzPrijavuDTO } from "../models/autorska/PriloziUzPrijavuDTO";
import { PunomocnikDTO } from "../models/autorska/PunomocnikDTO";

export default class AutorskaUtil {
    
    kreirajAdresu(drzava: string, grad: string, ulica: string, broj: number, postanskiBroj: number) : AdresaDTO {
        let adresa: AdresaDTO = {
            drzava: drzava,
            grad: grad,
            ulica: ulica,
            broj: broj,
            postanskiBroj: postanskiBroj
        }
        return adresa;
    }

    kreirajFizickoLice(autorskaForm: FormGroup) : FizickoLiceDTO {
        let adresa: AdresaDTO = this.kreirajAdresu(((autorskaForm.controls['podnosilac'] as FormGroup).controls['fizickoLice'] as FormGroup).controls['adresaLica'].value.drzava, 
        ((autorskaForm.controls['podnosilac'] as FormGroup).controls['fizickoLice'] as FormGroup).controls['adresaLica'].value.grad,
        ((autorskaForm.controls['podnosilac'] as FormGroup).controls['fizickoLice'] as FormGroup).controls['adresaLica'].value.ulica,
        ((autorskaForm.controls['podnosilac'] as FormGroup).controls['fizickoLice'] as FormGroup).controls['adresaLica'].value.broj,
        ((autorskaForm.controls['podnosilac'] as FormGroup).controls['fizickoLice'] as FormGroup).controls['adresaLica'].value.postanskiBroj);
        let fizickoLice: FizickoLiceDTO = {
            email: autorskaForm.controls['podnosilac'].value.email,
            telefon: autorskaForm.controls['podnosilac'].value.telefon,
            ime: (autorskaForm.controls['podnosilac'] as FormGroup).controls['fizickoLice'].value.ime,
            prezime: (autorskaForm.controls['podnosilac'] as FormGroup).controls['fizickoLice'].value.prezime,
            drzavljanstvo: (autorskaForm.controls['podnosilac'] as FormGroup).controls['fizickoLice'].value.drzavljanstvo,
            adresaLica: adresa
        }
        return fizickoLice;
    }

    kreirajPravnoLice(email: string, telefon: string, pravnoLiceForm: FormGroup): PravnoLiceDTO {
        let adresa: AdresaDTO = this.kreirajAdresu((pravnoLiceForm.controls['sediste'] as FormGroup).value.drzava,
        (pravnoLiceForm.controls['sediste'] as FormGroup).value.grad,
        (pravnoLiceForm.controls['sediste'] as FormGroup).value.ulica,
        (pravnoLiceForm.controls['sediste'] as FormGroup).value.broj,
        (pravnoLiceForm.controls['sediste'] as FormGroup).value.postanskiBroj);
        let pravnoLice: PravnoLiceDTO = {
            email: email,
            telefon: telefon,
            poslovnoIme: pravnoLiceForm.value.poslovnoIme,
            sediste: adresa
        }
        return pravnoLice;
    }

    kreirajPunomocnika(punomocnikForm: FormGroup): PunomocnikDTO {
        let adresa: AdresaDTO = this.kreirajAdresu((punomocnikForm.controls['adresa'] as FormGroup).value.drzava,
        (punomocnikForm.controls['adresa'] as FormGroup).value.grad,
        (punomocnikForm.controls['adresa'] as FormGroup).value.ulica,
        (punomocnikForm.controls['adresa'] as FormGroup).value.broj,
        (punomocnikForm.controls['adresa'] as FormGroup).value.postanskiBroj);
        let punomocnik: PunomocnikDTO = {
            ime: punomocnikForm.value.ime,
            prezime: punomocnikForm.value.prezime,
            adresa: adresa
        }
        return punomocnik;
    }

    kreirajPodatkeOAutorskomDelu(podaciOAutorskomDeluForm: FormGroup, fizickoLiceForm: FormGroup) : PodaciOAutorskomDeluDTO {
        let podaciOAutorskomDelu: PodaciOAutorskomDeluDTO = {
            naslov: podaciOAutorskomDeluForm.value.naslov,
            alternativniNaslov: podaciOAutorskomDeluForm.value.alternativniNaslov,
            vrsta: podaciOAutorskomDeluForm.value.vrsta,
            formaZapisa: podaciOAutorskomDeluForm.value.formaZapisa,
            stvorenoURadnomOdnosu: (podaciOAutorskomDeluForm.value.stvorenoURadnomOdnosu as string) === 'da' ? true : false,
            anonimniAutor: (podaciOAutorskomDeluForm.value.anonimniAutor as string) === 'da' ? true : false,
            naslovAutorskogDelaPrerade: podaciOAutorskomDeluForm.value.naslovAutorskogDelaPrerade,
            autori: this.krerajPodatkeOAutoru(podaciOAutorskomDeluForm, (podaciOAutorskomDeluForm.controls['autori'] as FormArray).controls as FormControl[], fizickoLiceForm),
            nacinKoriscenja: podaciOAutorskomDeluForm.value.nacinKoriscenja
        }
        return podaciOAutorskomDelu;
    }

    krerajPodatkeOAutoru(podaciOAutorskomDeluForm: FormGroup, autoriFormArray: FormControl[], fizickoLiceForm: FormGroup): PodaciOAutoruDTO[] {
        let autori: PodaciOAutoruDTO[] = [];
        if ((podaciOAutorskomDeluForm.value.anonimniAutor as string) === 'da') return autori;
        else {
            if ((podaciOAutorskomDeluForm.value.autorPodnosilac as string) === 'da') {
                let adresa: AdresaDTO = this.kreirajAdresu((fizickoLiceForm.controls['adresaLica'] as FormGroup).value.drzava,
                (fizickoLiceForm.controls['adresaLica'] as FormGroup).value.grad,
                (fizickoLiceForm.controls['adresaLica'] as FormGroup).value.ulica,
                (fizickoLiceForm.controls['adresaLica'] as FormGroup).value.broj,
                (fizickoLiceForm.controls['adresaLica'] as FormGroup).value.postanskiBroj);
                let autor: PodaciOAutoruDTO = {
                    ime: fizickoLiceForm.value.ime,
                    prezime: fizickoLiceForm.value.prezime,
                    drzavljanstvo: fizickoLiceForm.value.drzavljanstvo,
                    adresa: adresa
                }
                autori.push(autor);
            }else {
                for (let autor of autoriFormArray) {
                    if (autor.value.autorZiv === 'ne') {
                        let autorDTO: PodaciOAutoruDTO = {
                            ime: autor.value.ime,
                            prezime: autor.value.prezime,
                            godinaSmrti: autor.value.godinaSmrti
                        }
                        autori.push(autorDTO);
                    }else {
                        let adresa: AdresaDTO = this.kreirajAdresu(autor.get('adresa')?.value.drzava,
                        autor.get('adresa')?.value.grad,
                        autor.get('adresa')?.value.ulica,
                        autor.get('adresa')?.value.broj,
                        autor.get('adresa')?.value.postanskiBroj);
                        let autorDTO: PodaciOAutoruDTO = {
                            ime: autor.value.ime,
                            prezime: autor.value.prezime,
                            drzavljanstvo: autor.value.drzavljanstvo,
                            adresa: adresa
                        }
                        autori.push(autorDTO);
                    }
                }
            }
        }
        return autori;
    }

    kreirajPrilogeUzPrijavu(priloziUzPrijavuForm: FormGroup): PriloziUzPrijavuDTO {
        let priloziUzPrijavu: PriloziUzPrijavuDTO = {
            opisAutorskogDela: priloziUzPrijavuForm.value.opisAutorskogDela,
            primerAutorskogDela: priloziUzPrijavuForm.value.primerAutorskogDela
        }
        return priloziUzPrijavu;
    }

    konvertujOdgovor(odgovor: any) : ObrazacAutorskoDeloDTO {
        let fizickoLice: FizickoLiceDTO | undefined;
        let pravnoLice: PravnoLiceDTO | undefined;
        let punomocnik: PunomocnikDTO | undefined;
        if (odgovor.fizickoLiceDTO[0] !== '') {
            fizickoLice = this.konvertujFizickoLice(odgovor);
        }else {
            pravnoLice = this.konvertujPravnoLice(odgovor);
        }
        if (odgovor.punomocnikDTO[0] !== '') {
            punomocnik = this.konvertujPunomocnika(odgovor);
        }
        let podaciOAutorskomDelu: PodaciOAutorskomDeluDTO = this.konvertujPodatkeOAutorskomDelu(odgovor);
        let priloziUzPrijavu: PriloziUzPrijavuDTO = this.konvertujPrilogeUzPrijavu(odgovor);
        let brojPrijave: string = odgovor.brojPrijave[0];
        let datumPrijave: Date = new Date(odgovor.datumPrijave[0]);
        let podnosilacAutor: boolean = Boolean(odgovor.podnosilacAutor[0]);
        return this.kreirajObrazac(brojPrijave, datumPrijave, fizickoLice, pravnoLice, punomocnik, podaciOAutorskomDelu, priloziUzPrijavu, podnosilacAutor);
    }

    kreirajObrazac(brojPrijave: string, datumPrijave: Date, fizickoLice: FizickoLiceDTO | undefined, pravnoLice: PravnoLiceDTO | undefined, punomocnik: PunomocnikDTO | undefined, podaciOAutorskomDelu: PodaciOAutorskomDeluDTO, priloziUzPrijavu: PriloziUzPrijavuDTO, podnosilacAutor: boolean): ObrazacAutorskoDeloDTO {
        if (fizickoLice === undefined) {
          if (punomocnik === undefined) return {brojPrijave: brojPrijave, datumPrijave: datumPrijave, pravnoLiceDTO: pravnoLice, podaciOAutorskomDeluDTO: podaciOAutorskomDelu, priloziUzPrijavuDTO: priloziUzPrijavu, podnosilacAutor: podnosilacAutor};
          else return {brojPrijave: brojPrijave, datumPrijave: datumPrijave, pravnoLiceDTO: pravnoLice, podaciOAutorskomDeluDTO: podaciOAutorskomDelu, priloziUzPrijavuDTO: priloziUzPrijavu, podnosilacAutor: podnosilacAutor};
        } else {
          if (punomocnik === undefined) return {brojPrijave: brojPrijave, datumPrijave: datumPrijave, fizickoLiceDTO: fizickoLice, podaciOAutorskomDeluDTO: podaciOAutorskomDelu, priloziUzPrijavuDTO: priloziUzPrijavu, podnosilacAutor: podnosilacAutor};
          else return {brojPrijave: brojPrijave, datumPrijave: datumPrijave, fizickoLiceDTO: fizickoLice, punomocnikDTO: punomocnik, podaciOAutorskomDeluDTO: podaciOAutorskomDelu, priloziUzPrijavuDTO: priloziUzPrijavu, podnosilacAutor: podnosilacAutor};
        }
      }

    konvertujFizickoLice(odgovor: any): FizickoLiceDTO {
        let fizickoLice: FizickoLiceDTO = {
            email: odgovor.fizickoLiceDTO[0].email[0],
            telefon: odgovor.fizickoLiceDTO[0].telefon[0],
            ime: odgovor.fizickoLiceDTO[0].ime[0],
            prezime: odgovor.fizickoLiceDTO[0].prezime[0],
            drzavljanstvo: odgovor.fizickoLiceDTO[0].drzavljanstvo[0],
            adresaLica: {
                postanskiBroj: Number(odgovor.fizickoLiceDTO[0].adresaLica[0].postanskiBroj[0]),
                drzava: odgovor.fizickoLiceDTO[0].adresaLica[0].drzava[0],
                grad: odgovor.fizickoLiceDTO[0].adresaLica[0].grad[0],
                ulica: odgovor.fizickoLiceDTO[0].adresaLica[0].ulica[0],
                broj: Number(odgovor.fizickoLiceDTO[0].adresaLica[0].broj[0])
            } 
        }
        return fizickoLice;
    }

    konvertujPravnoLice(odgovor: any) : PravnoLiceDTO {
        let pravnoLice: PravnoLiceDTO = {
            email: odgovor.pravnoLiceDTO[0].email[0],
            telefon: odgovor.pravnoLiceDTO[0].telefon[0],
            poslovnoIme: odgovor.pravnoLiceDTO[0].poslovnoIme[0],
            sediste: {
                postanskiBroj: Number(odgovor.pravnoLiceDTO[0].sediste[0].postanskiBroj[0]),
                drzava: odgovor.pravnoLiceDTO[0].sediste[0].drzava[0],
                grad: odgovor.pravnoLiceDTO[0].sediste[0].grad[0],
                ulica: odgovor.pravnoLiceDTO[0].sediste[0].ulica[0],
                broj: Number(odgovor.pravnoLiceDTO[0].sediste[0].broj[0])
            }
        }
        return pravnoLice;
    }

    konvertujPunomocnika(odgovor: any) : PunomocnikDTO {
        let punomocnik: PunomocnikDTO = {
            ime: odgovor.punomocnikDTO[0].ime[0],
            prezime: odgovor.punomocnikDTO[0].prezime[0],
            adresa: {
                postanskiBroj: Number(odgovor.punomocnikDTO[0].adresa[0].postanskiBroj[0]),
                drzava: odgovor.punomocnikDTO[0].adresa[0].drzava[0],
                grad: odgovor.punomocnikDTO[0].adresa[0].grad[0],
                ulica: odgovor.punomocnikDTO[0].adresa[0].ulica[0],
                broj: Number(odgovor.punomocnikDTO[0].adresa[0].broj[0])
            }
        }
        return punomocnik;
    }

    konvertujPodatkeOAutorskomDelu(odgovor: any) : PodaciOAutorskomDeluDTO {
        let podaciOAutorskomDelu: PodaciOAutorskomDeluDTO = {
            naslov: odgovor.podaciOAutorskomDeluDTO[0].naslov[0],
            alternativniNaslov: odgovor.podaciOAutorskomDeluDTO[0].alternativniNaslov[0],
            vrsta: odgovor.podaciOAutorskomDeluDTO[0].vrsta[0],
            formaZapisa: odgovor.podaciOAutorskomDeluDTO[0].formaZapisa[0],
            stvorenoURadnomOdnosu: Boolean(odgovor.podaciOAutorskomDeluDTO[0].stvorenoURadnomOdnosu[0]),
            anonimniAutor: Boolean(odgovor.podaciOAutorskomDeluDTO[0].anonimniAutor[0]),
            naslovAutorskogDelaPrerade: odgovor.podaciOAutorskomDeluDTO[0].naslovAutorskogDelaPrerade[0],
            nacinKoriscenja: odgovor.podaciOAutorskomDeluDTO[0].nacinKoriscenja[0],
            autori: this.konvertujAutore(odgovor)
        }
        return podaciOAutorskomDelu;
    }

    konvertujAutore(odgovor: any): PodaciOAutoruDTO[] {
        let autori: PodaciOAutoruDTO[] = [];
        for (let autor of odgovor.podaciOAutorskomDeluDTO[0].autori) {
            let objekatAutor: PodaciOAutoruDTO;
            if (autor.godinaSmrti[0] === '') {
                objekatAutor = {
                    ime: autor.ime[0],
                    prezime: autor.prezime[0],
                    drzavljanstvo: autor.drzavljanstvo[0],
                    adresa: {
                        postanskiBroj: Number(autor.adresa[0].postanskiBroj[0]),
                        drzava: autor.adresa[0].drzava[0],
                        grad: autor.adresa[0].grad[0],
                        ulica: autor.adresa[0].ulica[0],
                        broj: Number(autor.adresa[0].broj[0])
                    }
                }
            }
            else {
                objekatAutor = {
                    ime: autor.ime[0],
                    prezime: autor.prezime[0],
                    godinaSmrti: autor.godinaSmrti[0]
                }
            }
            autori.push(objekatAutor);
        }
        return autori;
    }

    konvertujPrilogeUzPrijavu(odgovor: any): PriloziUzPrijavuDTO {
        let priloziUzPrijavu : PriloziUzPrijavuDTO = {
            opisAutorskogDela: odgovor.priloziUzPrijavuDTO[0].opisAutorskogDela[0],
            primerAutorskogDela: odgovor.priloziUzPrijavuDTO[0].primerAutorskogDela[0]
        }
        return priloziUzPrijavu;
    } 

}
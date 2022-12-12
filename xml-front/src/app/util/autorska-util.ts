import { FormArray, FormControl, FormGroup } from "@angular/forms";
import { AdresaDTO } from "../models/AdresaDto";
import { FizickoLiceDTO } from "../models/autorska/FizickoLiceDTO";
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
            autori: this.krerajPodatkeOAutoru(podaciOAutorskomDeluForm, (podaciOAutorskomDeluForm.controls['autori'] as FormArray).controls as FormControl[], fizickoLiceForm)
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
}
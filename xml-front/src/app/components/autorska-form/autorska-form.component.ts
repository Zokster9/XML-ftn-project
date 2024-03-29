import { Component } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { FizickoLiceDTO } from 'src/app/models/autorska/FizickoLiceDTO';
import { ObrazacAutorskoDeloCreationDTO } from 'src/app/models/autorska/ObrazacAutorskoDeloCreationDTO';
import { ObrazacAutorskoDeloDTO } from 'src/app/models/autorska/ObrazacAutorskoDeloDTO';
import { PodaciOAutorskomDeluDTO } from 'src/app/models/autorska/PodaciOAutorskomDeluDTO';
import { PravnoLiceDTO } from 'src/app/models/autorska/PravnoLiceDTO';
import { PriloziUzPrijavuDTO } from 'src/app/models/autorska/PriloziUzPrijavuDTO';
import { PunomocnikDTO } from 'src/app/models/autorska/PunomocnikDTO';
import { AutorskaService } from 'src/app/services/autorska.service';
import AutorskaUtil from 'src/app/util/autorska-util';
import * as xml2js from 'xml2js';

@Component({
  selector: 'app-autorska-form',
  templateUrl: './autorska-form.component.html',
  styleUrls: ['./autorska-form.component.css']
})
export class AutorskaFormComponent{

  autorskaForm = this.formBuilder.group({
    podnosilac : this.formBuilder.group({
      email: '',
      telefon: '',
      vrstaPodnosioca: 'fizickoLice',
      fizickoLice: this.formBuilder.group({
        ime: '',
        prezime: '',
        drzavljanstvo: '',
        adresaLica: this.formBuilder.group({
          drzava: '',
          grad: '',
          ulica: '',
          broj: null,
          postanskiBroj: null
        })
      }),
      pravnoLice: this.formBuilder.group({
        poslovnoIme: '',
        sediste: this.formBuilder.group({
          drzava: '',
          grad: '',
          ulica: '',
          broj: null,
          postanskiBroj: null
        })
      })
    }),
    punomocnik: this.formBuilder.group({
      prekoPunomocnika: 'ne',
      ime: '',
      prezime: '',
      adresa: this.formBuilder.group({
        drzava: '',
        grad: '',
        ulica: '',
        broj: null,
        postanskiBroj: null
      })
    }),
    podaciOAutorskomDelu: this.formBuilder.group({
      naslov: '',
      alternativniNaslov: '',
      vrsta: '',
      formaZapisa: '',
      stvorenoURadnomOdnosu: 'da',
      anonimniAutor: 'ne',
      autorPodnosilac: 'da',
      autori: this.formBuilder.array([]),
      naslovAutorskogDelaPrerade: '',
      nacinKoriscenja: ''
    }),
    priloziUzPrijavu: this.formBuilder.group({
      opisAutorskogDela: '',
      primerAutorskogDela: ''
    })
  });

  autorPodnosilacClick = false;

  constructor(
    private formBuilder: FormBuilder,
    private autorskaService: AutorskaService
  ) {}

  get autori() {
    return (this.autorskaForm.controls['podaciOAutorskomDelu'] as FormGroup).controls['autori'] as FormArray;
  }

  autorJePodnosilacClick() {
    this.autori.clear();
  }

  autorNijePodnosilacClick() {
    const autor = this.formBuilder.group({
      ime: '',
      prezime: '',
      drzavljanstvo: '',
      godinaSmrti: null,
      autorZiv: 'da',
      adresa: this.formBuilder.group({
        drzava: '',
        grad: '',
        ulica: '',
        broj: null,
        postanskiBroj: null
      })
    });
    this.autori.push(autor);
  }

  dodajAutora() {
    const autor = this.formBuilder.group({
      ime: '',
      prezime: '',
      drzavljanstvo: '',
      godinaSmrti: null,
      autorZiv: 'da',
      adresa: this.formBuilder.group({
        drzava: '',
        grad: '',
        ulica: '',
        broj: null,
        postanskiBroj: null
      })
    });
    this.autori.push(autor);
  }

  obrisiAutora(i: number) {
    this.autori.removeAt(i);
  }

  dodajZahtev() {
    let obrazacAutorskoDeloCreationDTO: ObrazacAutorskoDeloCreationDTO = this.kreirajPodatke();
    let obrazacAutorskoDeloDTO: ObrazacAutorskoDeloDTO;
    this.autorskaService.kreirajObrazacZaAutorska(obrazacAutorskoDeloCreationDTO).subscribe((xmlText) => {
      console.log(xmlText);
      const parser = new xml2js.Parser({strict: true, trim: true});
        parser.parseString(xmlText.toString(), (err, result) => {
          obrazacAutorskoDeloDTO = result.ObrazacAutorskoDeloDTO;
        })
      alert("Uspesno ste poslali zahtev za priznanje autorskog dela");
    }, error => {
      alert("GRESKA!");
    })
  }

  kreirajPodatke(): ObrazacAutorskoDeloCreationDTO {
    let autorskaUtil = new AutorskaUtil();
    let fizickoLice: FizickoLiceDTO | undefined;
    let pravnoLice: PravnoLiceDTO | undefined;
    if (this.autorskaForm.controls['podnosilac'].value.vrstaPodnosioca === 'fizickoLice') {
      fizickoLice = autorskaUtil.kreirajFizickoLice(this.autorskaForm);
    }else {
      pravnoLice = autorskaUtil.kreirajPravnoLice(this.autorskaForm.controls['podnosilac'].value.email as string, this.autorskaForm.controls['podnosilac'].value.telefon as string, this.autorskaForm.controls['podnosilac'].controls['pravnoLice']);
    }
    let punomocnik: PunomocnikDTO | undefined;
    if (this.autorskaForm.controls['punomocnik'].value.prekoPunomocnika === 'da') punomocnik = autorskaUtil.kreirajPunomocnika(this.autorskaForm.controls['punomocnik']);
    let podaciOAutorskomDelu: PodaciOAutorskomDeluDTO = autorskaUtil.kreirajPodatkeOAutorskomDelu(this.autorskaForm.controls['podaciOAutorskomDelu'], this.autorskaForm.controls['podnosilac'].controls['fizickoLice']);
    let priloziUzPrijavu: PriloziUzPrijavuDTO = autorskaUtil.kreirajPrilogeUzPrijavu(this.autorskaForm.controls['priloziUzPrijavu']);
    let autorPodnosilac: boolean = this.autorskaForm.controls['podaciOAutorskomDelu'].value.autorPodnosilac === 'da' ? true : false;
    return this.kreirajObrazac(fizickoLice, pravnoLice, punomocnik, podaciOAutorskomDelu, priloziUzPrijavu, autorPodnosilac);
  }

  kreirajObrazac(fizickoLice: FizickoLiceDTO | undefined, pravnoLice: PravnoLiceDTO | undefined, punomocnik: PunomocnikDTO | undefined, podaciOAutorskomDelu: PodaciOAutorskomDeluDTO, priloziUzPrijavu: PriloziUzPrijavuDTO, podnosilacAutor: boolean): ObrazacAutorskoDeloCreationDTO {
    if (fizickoLice === undefined) {
      if (punomocnik === undefined) return {pravnoLiceDTO: pravnoLice, podaciOAutorskomDeluDTO: podaciOAutorskomDelu, priloziUzPrijavuDTO: priloziUzPrijavu, podnosilacAutor: podnosilacAutor};
      else return {pravnoLiceDTO: pravnoLice, podaciOAutorskomDeluDTO: podaciOAutorskomDelu, priloziUzPrijavuDTO: priloziUzPrijavu, podnosilacAutor: podnosilacAutor};
    } else {
      if (punomocnik === undefined) return {fizickoLiceDTO: fizickoLice, podaciOAutorskomDeluDTO: podaciOAutorskomDelu, priloziUzPrijavuDTO: priloziUzPrijavu, podnosilacAutor: podnosilacAutor};
      else return {fizickoLiceDTO: fizickoLice, punomocnikDTO: punomocnik, podaciOAutorskomDeluDTO: podaciOAutorskomDelu, priloziUzPrijavuDTO: priloziUzPrijavu, podnosilacAutor: podnosilacAutor};
    }
  }
}
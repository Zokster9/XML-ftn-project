import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup} from '@angular/forms';
import { AdresaDto } from 'src/app/models/AdresaDto';
import { DodatnaPrijavaDto } from 'src/app/models/DodatnaPrijavaDto';
import { KontaktPodaciDto } from 'src/app/models/KontaktPodaciDto';
import { NacinDostavljanjaDto } from 'src/app/models/NacinDostavljanjaDto';
import { NazivPronalaskaDto } from 'src/app/models/NazivPronalaskaDto';
import { PodaciOPrijavamaDto } from 'src/app/models/PodaciOPrijavamaDto';
import { PodnosilacDto } from 'src/app/models/PodnosilacDto';
import { PriznanjePravaPrvenstvaDto } from 'src/app/models/PriznanjePravaPrvenstvaDto';
import { PronalazacDto } from 'src/app/models/PronalazacDto';
import { PunomocnikDto } from 'src/app/models/PunomocnikDto';
import { ZahtevZaPriznanjePatentaDto } from 'src/app/models/ZahtevZaPriznanjePatentaDTO';
import { PatentService } from 'src/app/services/patent.service';
import { NovaPrijavaDto } from "./../../models/NovaPrijavaDto";
import * as xml2js from 'xml2js';
import { PriznanjaPravaPrvenstvaDto } from 'src/app/models/PriznanjaPravaPrvenstvaDto';

@Component({
  selector: 'app-patent-form',
  templateUrl: './patent-form.component.html',
  styleUrls: ['./patent-form.component.css']
})
export class PatentFormComponent implements OnInit{

  patentForm = this.formBuilder.group({
    podaciOPrijavama: this.formBuilder.group({
      novaPrijava: this.formBuilder.group({
        brojPrijave: [''],
        datumPrijave: [''],
        priznatiDatumPrijave: ['']
      }),
      dodatnaPrijava: this.formBuilder.group({
        tipPrijave: ['dodatna'],
        brojPrvobitnePrijave: [''],
        datumPodnosenjaPrijave: ['']
      }),
      priznanjaPravaPrvenstva: this.formBuilder.array([]),
    }),
    nazivPronalaska: this.formBuilder.group({
      srpskiNaziv: [''],
      engleskiNaziv: ['']
    }),
    podnosilac: this.formBuilder.group({
      naziv: [''],
      drzavljanstvo: [''],
      podnosilacJePronalazac: false,
      adresa: this.formBuilder.group({
        ulicaIBroj: [''],
        postanskiBroj: [null],
        mesto: [''],
        drzava: ['']
      }),
      kontaktPodaci: this.formBuilder.group({
        brojTelefona: [''],
        brojFaksa: [''],
        ePosta: ['']
      }),
      nacinDostavljanja: this.formBuilder.group({
        nacinDostavljanja: ['elektronski'],
        email: [''],
        adresa: this.formBuilder.group({
          ulicaIBroj: [''],
          postanskiBroj: [null],
          mesto: [''],
          drzava: ['']
        })
      })
    }),
    pronalazac: this.formBuilder.group({
      naziv: [''],
      zeliBitiUPrijavi: true,
      adresa: this.formBuilder.group({
        ulicaIBroj: [''],
        postanskiBroj: [null],
        mesto: [''],
        drzava: ['']
      }),
      kontaktPodaci: this.formBuilder.group({
        brojTelefona: [''],
        brojFaksa: [''],
        ePosta: ['']
      })
    }),
    punomocnik: this.formBuilder.group({
      tipPunomocnika: ['zastupanje'],
      zajednickiPredstavnik: false,
      naziv: [''],
      adresa: this.formBuilder.group({
        ulicaIBroj: [''],
        postanskiBroj: [null],
        mesto: [''],
        drzava: ['']
      }),
      kontaktPodaci: this.formBuilder.group({
        brojTelefona: [''],
        brojFaksa: [''],
        ePosta: ['']
      })
    })
  })

  constructor(
    private formBuilder: FormBuilder,
    private patentService: PatentService
  ) {}

  ngOnInit(): void {
    this.addPriznanjePravaPrvenstva();
  }

  get priznanjaPravaPrvenstva() {
    return (this.patentForm.controls['podaciOPrijavama'] as FormGroup).controls['priznanjaPravaPrvenstva'] as FormArray;
  }

  addPriznanjePravaPrvenstva() {
    const priznanjePravaPrvenstva = this.formBuilder.group({
      datumPrijave: [''],
      brojRanijePrijave: [''],
      dvoslovnaOznakaDrzaveOrganizacije: ['']
    });

    this.priznanjaPravaPrvenstva.push(priznanjePravaPrvenstva);
  }

  deletePriznanjePravaPrvenstva(index: number) {
    this.priznanjaPravaPrvenstva.removeAt(index);
  }

  get priznanjaPravaPrvenstvaForme(): FormControl[] {
    return (this.patentForm.get('podaciOPrijavama')?.get('priznanjaPravaPrvenstva') as FormArray).controls as FormControl[];
  }

  addPatent() {

    const novaPrijava: NovaPrijavaDto = {
      brojPrijave: this.patentForm.controls['podaciOPrijavama'].controls['novaPrijava'].value.brojPrijave as string,
      datumPrijave: this.patentForm.controls['podaciOPrijavama'].controls['novaPrijava'].value.datumPrijave as string,
      priznatiDatumPrijave: this.patentForm.controls['podaciOPrijavama'].controls['novaPrijava'].value.priznatiDatumPrijave as string
    }

    const dodatnaPrijava: DodatnaPrijavaDto = {
      tipPrijave: this.patentForm.controls['podaciOPrijavama'].controls['dodatnaPrijava'].value.tipPrijave as string,
      brojPrvobitnePrijave: this.patentForm.controls['podaciOPrijavama'].controls['dodatnaPrijava'].value.brojPrvobitnePrijave as string,
      datumPodnosenjaPrijave: this.patentForm.controls['podaciOPrijavama'].controls['dodatnaPrijava'].value.datumPodnosenjaPrijave as string
    }

    const priznanjePravaPrvenstva: PriznanjePravaPrvenstvaDto[] = [];

    for (let p of this.priznanjaPravaPrvenstvaForme) {
      const jednoPriznanjePravaPrvenstva: PriznanjePravaPrvenstvaDto = {
        datumPrijave: p.value.datumPrijave,
        brojRanijePrijave: p.value.brojRanijePrijave,
        dvoslovnaOznakaDrzaveOrganizacije: p.value.dvoslovnaOznakaDrzaveOrganizacije
      }
      priznanjePravaPrvenstva.push(jednoPriznanjePravaPrvenstva);
    }

    const priznanjaPravaPrvenstva: PriznanjaPravaPrvenstvaDto = {
      priznanjaPravaPrvenstva: priznanjePravaPrvenstva
    }

    const podaciOPrijavama: PodaciOPrijavamaDto = {
      novaPrijava: novaPrijava,
      dodatnaPrijava: dodatnaPrijava,
      priznanjaPravaPrvenstva: priznanjaPravaPrvenstva
    }

    const nazivPronalaska: NazivPronalaskaDto = {
      srpskiNaziv: this.patentForm.controls['nazivPronalaska'].value.srpskiNaziv as string,
      engleskiNaziv: this.patentForm.controls['nazivPronalaska'].value.engleskiNaziv as string
    }

    const adresaPodnosilac: AdresaDto = {
      ulicaIBroj: this.patentForm.controls['podnosilac'].controls['adresa'].value.ulicaIBroj as string,
      postanskiBroj: this.patentForm.controls['podnosilac'].controls['adresa'].value.postanskiBroj as unknown as number,
      mesto: this.patentForm.controls['podnosilac'].controls['adresa'].value.mesto as string,
      drzava: this.patentForm.controls['podnosilac'].controls['adresa'].value.drzava as string,
    }

    const kontaktPodaciPodnosilac: KontaktPodaciDto = {
      brojTelefona: this.patentForm.controls['podnosilac'].controls['kontaktPodaci'].value.brojTelefona as string,
      brojFaksa: this.patentForm.controls['podnosilac'].controls['kontaktPodaci'].value.brojFaksa as string,
      ePosta: this.patentForm.controls['podnosilac'].controls['kontaktPodaci'].value.ePosta as string,
    }

    const adresaNacinDostavljanja: AdresaDto = {
      ulicaIBroj: this.patentForm.controls['podnosilac'].controls['nacinDostavljanja'].controls['adresa'].value.ulicaIBroj as string,
      postanskiBroj: this.patentForm.controls['podnosilac'].controls['nacinDostavljanja'].controls['adresa'].value.postanskiBroj as unknown as number,
      mesto: this.patentForm.controls['podnosilac'].controls['nacinDostavljanja'].controls['adresa'].value.mesto as string,
      drzava: this.patentForm.controls['podnosilac'].controls['nacinDostavljanja'].controls['adresa'].value.drzava as string,
    }

    const nacinDostavljanja: NacinDostavljanjaDto = {
      nacinDostavljanja: this.patentForm.controls['podnosilac'].controls['nacinDostavljanja'].value.nacinDostavljanja as string,
      email: this.patentForm.controls['podnosilac'].controls['nacinDostavljanja'].value.email as string,
      adresa: adresaNacinDostavljanja
    }

    const podnosilac: PodnosilacDto = {
      naziv: this.patentForm.controls['podnosilac'].value.naziv as string,
      drzavljanstvo: this.patentForm.controls['podnosilac'].value.drzavljanstvo as string,
      podnosilacJePronalazac: this.patentForm.controls['podnosilac'].value.podnosilacJePronalazac as boolean,
      adresa: adresaPodnosilac,
      kontaktPodaci: kontaktPodaciPodnosilac,
      nacinDostavljanja: nacinDostavljanja
    }

    const adresaPronalazac: AdresaDto = {
      ulicaIBroj: this.patentForm.controls['pronalazac'].controls['adresa'].value.ulicaIBroj as string,
      postanskiBroj: this.patentForm.controls['pronalazac'].controls['adresa'].value.postanskiBroj as unknown as number,
      mesto: this.patentForm.controls['pronalazac'].controls['adresa'].value.mesto as string,
      drzava: this.patentForm.controls['pronalazac'].controls['adresa'].value.drzava as string,
    }

    const kontaktPodaciPronalazac: KontaktPodaciDto = {
      brojTelefona: this.patentForm.controls['pronalazac'].controls['kontaktPodaci'].value.brojTelefona as string,
      brojFaksa: this.patentForm.controls['pronalazac'].controls['kontaktPodaci'].value.brojFaksa as string,
      ePosta: this.patentForm.controls['pronalazac'].controls['kontaktPodaci'].value.ePosta as string,
    }

    const pronalazac: PronalazacDto = {
      naziv: this.patentForm.controls['pronalazac'].value.naziv as string,
      zeliBitiUPrijavi: this.patentForm.controls['pronalazac'].value.zeliBitiUPrijavi as boolean,
      adresa: adresaPronalazac,
      kontaktPodaci: kontaktPodaciPronalazac
    }

    const adresaPunomocnik: AdresaDto = {
      ulicaIBroj: this.patentForm.controls['punomocnik'].controls['adresa'].value.ulicaIBroj as string,
      postanskiBroj: this.patentForm.controls['punomocnik'].controls['adresa'].value.postanskiBroj as unknown as number,
      mesto: this.patentForm.controls['punomocnik'].controls['adresa'].value.mesto as string,
      drzava: this.patentForm.controls['punomocnik'].controls['adresa'].value.drzava as string,
    }

    const kontaktPodaciPunomocnik: KontaktPodaciDto = {
      brojTelefona: this.patentForm.controls['punomocnik'].controls['kontaktPodaci'].value.brojTelefona as string,
      brojFaksa: this.patentForm.controls['punomocnik'].controls['kontaktPodaci'].value.brojFaksa as string,
      ePosta: this.patentForm.controls['punomocnik'].controls['kontaktPodaci'].value.ePosta as string,
    }

    const punomocnik: PunomocnikDto = {
      tipPunomocnika: this.patentForm.controls['punomocnik'].value.tipPunomocnika as string,
      zajednickiPredstavnik: this.patentForm.controls['punomocnik'].value.zajednickiPredstavnik as boolean,
      naziv: this.patentForm.controls['punomocnik'].value.naziv as string,
      adresa: adresaPunomocnik,
      kontaktPodaci: kontaktPodaciPunomocnik
    }

    const zahtevZaPriznanjePatenta : ZahtevZaPriznanjePatentaDto = {
      podaciOPrijavama: podaciOPrijavama,
      nazivPronalaska : nazivPronalaska,
      podnosilac: podnosilac,
      pronalazac: pronalazac,
      punomocnik: punomocnik
    }

    let zahtevZaPriznanjePatentaPovratna : ZahtevZaPriznanjePatentaDto;
    this.patentService.addPatent(zahtevZaPriznanjePatenta).subscribe(
      zahtevZaPriznanjeXml => {
        const parser = new xml2js.Parser({strict: true, trim: true});
        parser.parseString(zahtevZaPriznanjeXml.toString(), (err, result) => {
          zahtevZaPriznanjePatentaPovratna = result.zahtevZaPriznanjePatentaCreationDto;
        })
      }
    );

  }

  getPatent() {
    this.patentService.getPatent().subscribe(
      zahtevZaPriznanjePatentaXml => {
        console.log(zahtevZaPriznanjePatentaXml);
        const parser = new xml2js.Parser({strict: true, trim: true});
        parser.parseString(zahtevZaPriznanjePatentaXml.toString(), (err, result) => {
          let zahtevZaPriznanjePatentaPovratna = result.ZahtevZaPriznanjePatentaCreationDto;
          console.log(zahtevZaPriznanjePatentaPovratna);
        })
      }
    )
  }
}

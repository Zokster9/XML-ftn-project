import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl } from '@angular/forms';
import { AdresaDTO } from 'src/app/models/zig/AdresaDTO';
import { FizickoLiceDTO } from 'src/app/models/zig/FizickoLiceDTO';
import { IzgledZnakaDTO } from 'src/app/models/zig/IzgledZnakaDTO';
import { KlaseRobeIUslugaDTO } from 'src/app/models/zig/KlaseRobeIUslugaDTO';
import { KontaktPodaciDTO } from 'src/app/models/zig/KontaktPodaciDTO';
import { NaznaceneBojeDTO } from 'src/app/models/zig/NaznaceneBojeDTO';
import { PlaceneTakseDTO } from 'src/app/models/zig/PlaceneTakseDTO';
import { PodaciOPrijaviDTO } from 'src/app/models/zig/PodaciOPrijaviDTO';
import { PodnosiociPrijaveDTO } from 'src/app/models/zig/PodnosiociPrijaveDTO';
import { PravnoLiceDTO } from 'src/app/models/zig/PravnoLiceDTO';
import { PrilogUzZahtevDTO } from 'src/app/models/zig/PrilogUzZahtevDTO';
import { PriloziUzZahtevDTO } from 'src/app/models/zig/PriloziUzZahtevDTO';
import { TaksaZaKlaseDTO } from 'src/app/models/zig/TaksaZaKlaseDTO';
import { TipZigaDTO } from 'src/app/models/zig/TipZigaDTO';
import { TipZnakaDTO } from 'src/app/models/zig/TipZnakaDTO';
import { ZahtevZaPriznanjeZigaDTO } from 'src/app/models/zig/ZahtevZaPriznanjeZigaDTO';
import { ZigDTO } from 'src/app/models/zig/ZigDTO';
import { LiceDTO } from 'src/app/models/zig/LiceDTO';
import { ZigService } from 'src/app/services/zig.service';
import * as xml2js from 'xml2js';

@Component({
  selector: 'app-zig-form',
  templateUrl: './zig-form.component.html',
  styleUrls: ['./zig-form.component.css']
})
export class ZigFormComponent implements OnInit {

  zigForma = this.formBuilder.group({
    podnosilac: this.formBuilder.group({
      ulica: '',
      broj: '',
      postanskiBroj: 0,
      mesto: '',
      drzava: '',
      brojTelefona: '',
      email: '',
      brojFaksa: '',
      vrstaPodnosioca: 'fizickoLice',
      fizickoLice: this.formBuilder.group({
        ime: '',
        prezime: '',
      }),
      pravnoLice: this.formBuilder.group({
        naziv: '',
      })
    }),
    punomocnik: this.formBuilder.group({
      ime: '',
      prezime: '',
      ulica: '',
      broj: '',
      postanskiBroj: 0,
      mesto: '',
      drzava: '',
      brojTelefona: '',
      email: '',
      brojFaksa: '',
      prekoPunomocnika: 'ne',
    }),
    zajednickiPredstavnik: this.formBuilder.group({
      prekoZajednickogPredstavnika: 'ne',
    }),
    zig: this.formBuilder.group({
      imageUrl: '',
      tipZiga: '',
      tipZnaka: '',
      naznaceneBoje: '',
      transliteracijaZnaka: '',
      prevodZnaka: '',
      opisZnaka: '',
    }),
    zatrazenoPravoPrvenstvaIOsnov: '',
    takse: this.formBuilder.group({
      osnovnaTaksa: 0,
      taksaZaKlase: 0,
      taksaZaGrafickoResenje: 0,
    }),
    priloziUzZahtev: this.formBuilder.group({
      primerakZnaka: '',
      spisakRobeIUsluga: '',
      punomocje: '',
      generalnoPunomocjeRanijePrilozeno: 'ne',
      punomocjeCeBitiNaknadnoDostavljeno: 'ne',
      opstiAktOZigu: '',
      dokazOPravuPrvenstva: '',
      dokazOUplatiTakse: '',
    })
  });

  zajednickiPredstavnik = new FormControl<LiceDTO | null>(null);
  ukupnaTaksa = new FormControl<number>(0);

  podnosiociPrijave: LiceDTO[] = [];
  fizickiPodnosiociPrijave: FizickoLiceDTO[] = [];
  pravniPodnosiociPrijave: PravnoLiceDTO[] = [];

  klaseRobe: number[] = Array.from({ length: 45 }, (_, i) => i + 1);
  
  tipoviZiga: string[] = ['individualni zig', 'kolektivni zig', 'zig garancije'];
  tipoviZnaka: string[] = ['verbalni znak', 'graficki znak', 'kombinovani znak', 'trodimenzionalni znak',
    'druga vrstu znaka'];
  
  izabraneKlase: number[] = Array.from({ length: 45 }, (_, i) => 0);

  brojIzabranihKlasa = 0;

  removePodnosilacPrijave(podnosilacPrijave: LiceDTO) {
    const idx = this.podnosiociPrijave.indexOf(podnosilacPrijave);
    this.podnosiociPrijave.splice(idx, 1);
  }

  addPodnosilacPrijave() {
    const podnosilac = this.zigForma.controls.podnosilac;
    const adresa: AdresaDTO = {
      broj: podnosilac.controls.broj.value!,
      drzava: podnosilac.controls.drzava.value!,
      mesto: podnosilac.controls.mesto.value!,
      postanskiBroj: podnosilac.controls.postanskiBroj.value!,
      ulica: podnosilac.controls.ulica.value!,
    }
    const kontaktPodaci: KontaktPodaciDTO = {
      email: podnosilac.controls.email.value!,
      brojTelefona: podnosilac.controls.brojTelefona.value!,
      brojFaksa: podnosilac.controls.brojFaksa.value!,
    }
    if (podnosilac.controls.vrstaPodnosioca.value === 'fizickoLice') {
      const fizickoLice: FizickoLiceDTO = {
        ime: podnosilac.controls.fizickoLice.controls.ime.value!,
        prezime: podnosilac.controls.fizickoLice.controls.prezime.value!,
        kontaktPodaci,
        adresa,
      }
      this.podnosiociPrijave.push(fizickoLice);
      this.fizickiPodnosiociPrijave.push(fizickoLice);
    } else {
      const pravnoLice: PravnoLiceDTO = {
        naziv: podnosilac.controls.pravnoLice.controls.naziv.value!,
        kontaktPodaci,
        adresa,
      }
      this.podnosiociPrijave.push(pravnoLice);
      this.pravniPodnosiociPrijave.push(pravnoLice);
    }
    podnosilac.reset();
    podnosilac.controls.vrstaPodnosioca.setValue('fizickoLice');
  }

  onCheckboxChange(event: any) {
    const option = Number.parseInt(event.target.value);
    if (event.target.checked) {
      this.izabraneKlase[option - 1] = option;
      this.brojIzabranihKlasa++;
    } else {
      this.izabraneKlase[option - 1] = 0;
      this.brojIzabranihKlasa--;
    }
  }

  taksaChange(event: any) {
    const currentValue: number = this.ukupnaTaksa.value!;
    const newValue: number = Number.parseFloat(event.target.value);
    console.log
    this.ukupnaTaksa.setValue(currentValue + newValue);
  }

  constructor(
    private formBuilder: FormBuilder,
    private zigService: ZigService,
  ) { }
  
  ngOnInit(): void {
    
  }

  instanceofFizickoLiceDTO(object: any): object is FizickoLiceDTO {
    if (object === null) return false;
    return 'ime' in object;
  }

  instanceofPravnoLiceDTO(object: any): object is PravnoLiceDTO {
    if (object === null) return false;
    return 'naziv' in object;
  }

  onSubmit() {
    const podnosiociPrijave: PodnosiociPrijaveDTO = {
      fizickiPodnosiociPrijave: {
        fizickiPodnosioci: this.fizickiPodnosiociPrijave
      },
      pravniPodnosiociPrijave: {
        pravniPodnosioci: this.pravniPodnosiociPrijave
      }
    }
    const punomocnik: FizickoLiceDTO | undefined = this.createPunomocnik();
    let fizickiZajednickiPredstavnikPodnosiocaPrijave: FizickoLiceDTO | undefined = undefined;
    let pravniZajednickiPredstavnikPodnosiocaPrijave: PravnoLiceDTO | undefined = undefined;
    if (this.instanceofFizickoLiceDTO(this.zajednickiPredstavnik.value)) {
      fizickiZajednickiPredstavnikPodnosiocaPrijave = this.zajednickiPredstavnik.value as FizickoLiceDTO;
    } else if (this.instanceofPravnoLiceDTO(this.zajednickiPredstavnik.value)) {
      pravniZajednickiPredstavnikPodnosiocaPrijave = this.zajednickiPredstavnik.value as PravnoLiceDTO;
    }
    const zigControl = this.zigForma.controls.zig;
    const izgledZnaka: IzgledZnakaDTO = {
      imageUrl: zigControl.controls.imageUrl.value!.split('\\')[zigControl.controls.imageUrl.value!.split('\\').length - 1],
    };
    const tipZiga: TipZigaDTO = this.createTipZiga(zigControl.controls.tipZiga.value!);
    const tipZnaka: TipZnakaDTO = this.createTipZnaka(zigControl.controls.tipZnaka.value!);
    const naznaceneBoje: NaznaceneBojeDTO | undefined = this.createNaznaceneBoje(zigControl.controls.naznaceneBoje.value);
    const zig: ZigDTO = {
      izgledZnaka,
      tipZiga,
      tipZnaka,
      naznaceneBoje,
      opisZnaka: zigControl.controls.opisZnaka.value ? zigControl.controls.opisZnaka.value : undefined,
      prevodZnaka: zigControl.controls.prevodZnaka.value ? zigControl.controls.prevodZnaka.value : undefined,
      transliteracijaZnaka: zigControl.controls.transliteracijaZnaka.value ? zigControl.controls.transliteracijaZnaka.value : undefined,
    };
    const klaseRobe: KlaseRobeIUslugaDTO = {
      klasa: {
        klasa: this.izabraneKlase,
      }
    };
    const taksaControl = this.zigForma.controls.takse;
    const taksaZaKlase: TaksaZaKlaseDTO = {
      brojKlasa: this.brojIzabranihKlasa,
      vrednost: taksaControl.controls.taksaZaKlase.value!,
    }
    const takse: PlaceneTakseDTO = {
      osnovnaTaksa: taksaControl.controls.osnovnaTaksa.value!,
      taksaZaKlase,
      taksaZaGrafickoResenje: taksaControl.controls.taksaZaGrafickoResenje.value!,
      ukupnaTaksa: this.ukupnaTaksa.value!,
    }
    const priloziUzZahtevControl = this.zigForma.controls.priloziUzZahtev;
    const primerakZnaka: PrilogUzZahtevDTO = this.createPrilogUzZahtev(priloziUzZahtevControl.controls.primerakZnaka.value!)!;
    const spisakRobeIUsluga: PrilogUzZahtevDTO = this.createPrilogUzZahtev(priloziUzZahtevControl.controls.spisakRobeIUsluga.value!)!;
    const punomocje: PrilogUzZahtevDTO | undefined = this.createPrilogUzZahtev(priloziUzZahtevControl.controls.punomocje.value!);
    const generalnoPunomocjeRanijePrilozeno: boolean = this.createBoolean(priloziUzZahtevControl.controls.generalnoPunomocjeRanijePrilozeno.value!);
    const punomocjeCeBitiNaknadnoDostavljeno: boolean = this.createBoolean(priloziUzZahtevControl.controls.punomocjeCeBitiNaknadnoDostavljeno.value!);
    const opstiAktOZigu: PrilogUzZahtevDTO | undefined = this.createPrilogUzZahtev(priloziUzZahtevControl.controls.opstiAktOZigu.value!);
    const dokazOPravuPrvenstva: PrilogUzZahtevDTO | undefined = this.createPrilogUzZahtev(priloziUzZahtevControl.controls.dokazOPravuPrvenstva.value!);
    const dokazOUplatiTakse: PrilogUzZahtevDTO = this.createPrilogUzZahtev(priloziUzZahtevControl.controls.dokazOUplatiTakse.value!)!;
    const priloziUzZahtev: PriloziUzZahtevDTO = {
      primerakZnaka,
      spisakRobeIUsluga,
      punomocje,
      generalnoPunomocjeRanijePrilozeno,
      punomocjeCeBitiNaknadnoDostavljeno,
      opstiAktOKolektivnomZigu: opstiAktOZigu,
      dokazOPravuPrvenstva,
      dokazOUplatiTakse,
    };
    const podaciOPrijavi: PodaciOPrijaviDTO = {
      priloziUzZahtev,
    }

    let zahtevZaPriznanjeZiga: ZahtevZaPriznanjeZigaDTO = {
      podnosiociPrijave,
      punomocnik,
      fizickiZajednickiPredstavnikPodnosiocaPrijave,
      pravniZajednickiPredstavnikPodnosiocaPrijave,
      zig,
      klaseRobeIUsluga: klaseRobe,
      pravoPrvenstvaIOsnov: this.zigForma.controls.zatrazenoPravoPrvenstvaIOsnov.value ?
        this.zigForma.controls.zatrazenoPravoPrvenstvaIOsnov.value : undefined,
      placeneTakse: takse,
      podaciOPrijavi,
    }
    this.zigService.addZig(zahtevZaPriznanjeZiga).subscribe({
      next: (xmlText) => {
        console.log(xmlText);
        const parser = new xml2js.Parser({ strict: true, trim: true });
        parser.parseString(xmlText.toString(), (err, result) => {
          zahtevZaPriznanjeZiga = result.ZahtevZaPriznanjeZigaDTO;
        })
      }
    })
  }
  createBoolean(uslov: string): boolean {
    return uslov === 'da';
  }

  createPrilogUzZahtev(prilog: string | null): PrilogUzZahtevDTO | undefined {
    if (prilog) {
      return {
        putanjaDokumenta: prilog,
        nazivDokumenta: prilog.split('\\')[prilog.split('\\').length - 1]
      }
    } else {
      return undefined;
    }
  }

  createNaznaceneBoje(naznaceneBoje: string | null): NaznaceneBojeDTO | undefined {
    if (naznaceneBoje) {
      return {
        boja: {
          boja: naznaceneBoje.split(' '),
        }
      };
    } else { 
      return undefined;
    }
  }

  createTipZnaka(tipZnaka: string): TipZnakaDTO {
    ['verbalni znak', 'graficki znak', 'kombinovani znak', 'trodimenzionalni znak',
    'druga vrstu znaka']
    if (tipZnaka === 'verbalni znak') {
      return {
        verbalniZnak: true,
        grafickiZnak: false,
        kombinovaniZnak: false,
        trodimenzionalniZnak: false,
        drugaVrstaZnaka: false,
      }
    } else if (tipZnaka === 'graficki znak') {
      return {
        verbalniZnak: false,
        grafickiZnak: true,
        kombinovaniZnak: false,
        trodimenzionalniZnak: false,
        drugaVrstaZnaka: false,
      }

    } else if (tipZnaka === 'kombinovani znak') {
      return {
        verbalniZnak: false,
        grafickiZnak: false,
        kombinovaniZnak: true,
        trodimenzionalniZnak: false,
        drugaVrstaZnaka: false,
      }

    } else if (tipZnaka === 'trodimenzionalni znak') {
      return {
        verbalniZnak: false,
        grafickiZnak: false,
        kombinovaniZnak: false,
        trodimenzionalniZnak: true,
        drugaVrstaZnaka: false,
      }

    } else {
      return {
        verbalniZnak: false,
        grafickiZnak: false,
        kombinovaniZnak: false,
        trodimenzionalniZnak: false,
        drugaVrstaZnaka: true,
      }

    }
  }

  createTipZiga(tipZiga: string): TipZigaDTO {
    if (tipZiga === 'individualni zig') {
      return {
        individualniZig: true,
        kolektivniZig: false,
        zigGarancije: false,
      };
    } else if (tipZiga === 'kolektivni zig') {
      return {
        individualniZig: false,
        kolektivniZig: true,
        zigGarancije: false,
      };
    } else {
      return {
        individualniZig: false,
        kolektivniZig: false,
        zigGarancije: true,
      };
    }
  }

  private createPunomocnik(): FizickoLiceDTO | undefined {
    const punomocnikControl = this.zigForma.controls.punomocnik;
    if (punomocnikControl.controls.prekoPunomocnika.value! === 'ne') {
      return undefined;
    } else {
      const adresa: AdresaDTO = {
        broj: punomocnikControl.controls.broj.value!,
        drzava: punomocnikControl.controls.drzava.value!,
        mesto: punomocnikControl.controls.mesto.value!,
        postanskiBroj: punomocnikControl.controls.postanskiBroj.value!,
        ulica: punomocnikControl.controls.ulica.value!,
      }
      const kontaktPodaci: KontaktPodaciDTO = {
        brojFaksa: punomocnikControl.controls.brojFaksa.value!,
        brojTelefona: punomocnikControl.controls.brojTelefona.value!,
        email: punomocnikControl.controls.email.value!,
      }
      const punomocnik: FizickoLiceDTO = {
        ime: punomocnikControl.controls.ime.value!,
        prezime: punomocnikControl.controls.prezime.value!,
        adresa,
        kontaktPodaci
      }
      return punomocnik;
    }
  }
}

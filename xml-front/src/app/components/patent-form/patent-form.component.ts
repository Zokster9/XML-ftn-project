import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup} from '@angular/forms';

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
        tipPrijave: [''],
        brojPrvobitnePrijave: [''],
        datumPodnosenjaPrijave: ['']
      }),
      priznanjaPravaPrvenstva: this.formBuilder.array([])
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
        postanskiBroj: [''],
        mesto: [''],
        drzava: ['']
      }),
      kontaktPodaci: this.formBuilder.group({
        brojTelefona: [''],
        brojFaksa: [''],
        ePosta: ['']
      }),
      nacinDostavljanja: this.formBuilder.group({
        nacinDostavljanja: [''],
        email: [''],
        adresa: this.formBuilder.group({
          ulicaIBroj: [''],
          postanskiBroj: [''],
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
        postanskiBroj: [''],
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
      tipPunomocnika: [''],
      zajednickiPredstavnik: false,
      naziv: [''],
      adresa: this.formBuilder.group({
        ulicaIBroj: [''],
        postanskiBroj: [''],
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
    private formBuilder: FormBuilder
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
}

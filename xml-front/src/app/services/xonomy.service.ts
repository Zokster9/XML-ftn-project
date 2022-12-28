import { Injectable } from '@angular/core';
declare const Xonomy: any
@Injectable({
  providedIn: 'root'
})
export class XonomyService {
    constructor() {

    }
    public zahtevSpecification = {
        elements: {
            zahtevZaPriznanjePatenta : {
                menu: [
                {
                    caption:'Dodaj <podaciOPrijavama>',
                    action: Xonomy.newElementChild,
                    actionParameter: '<podaciOPrijavama></podaciOPrijavama>',
                    hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                        return jsElement.hasChildElement("podaciOPrijavama")
                    },
                },
                {
                    caption:'Dodaj <nazivPronalaska>',
                    action: Xonomy.newElementChild,
                    actionParameter: '<nazivPronalaska></nazivPronalaska>',
                    hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                        return jsElement.hasChildElement("nazivPronalaska")
                    },
                },
                {
                    caption:'Dodaj <podnosilac>',
                    action: Xonomy.newElementChild,
                    actionParameter: '<podnosilac></podnosilac>',
                    hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                        return jsElement.hasChildElement("podnosilac")
                    },
                },
                {
                    caption:'Dodaj <pronalazac>',
                    action: Xonomy.newElementChild,
                    actionParameter: '<pronalazac></pronalazac>',
                    hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                        return jsElement.hasChildElement("pronalazac")
                    },
                },
                {
                    caption:'Dodaj <punomocnik>',
                    action: Xonomy.newElementChild,
                    actionParameter: '<punomocnik></punomocnik>',
                    hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                        return jsElement.hasChildElement("punomocnik")
                    },
                },
                ]
            },
            
            /* PODACI O PRIJAVAMA */
            podaciOPrijavama : {
                mustBeBefore: ['nazivPronalaska', 'podnosilac', 'pronalazac', 'punomocnik'],
                asker: Xonomy.askString,
                menu:[
                {
                    caption:'Dodaj <novaPrijava>',
                    action: Xonomy.newElementChild,
                    actionParameter: '<novaPrijava></novaPrijava>',
                    hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                        return jsElement.hasChildElement("novaPrijava")
                    },
                },
                {
                    caption:'Dodaj <dodatnaPrijava>',
                    action: Xonomy.newElementChild,
                    actionParameter: '<dodatnaPrijava></dodatnaPrijava>',
                    hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                        return jsElement.hasChildElement("dodatnaPrijava")
                    },
                },
                {
                    caption:'Dodaj <priznanjaPravaPrvenstva>',
                    action: Xonomy.newElementChild,
                    actionParameter: '<priznanjaPravaPrvenstva></priznanjaPravaPrvenstva>',
                    hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                        return jsElement.hasChildElement("priznanjaPravaPrvenstva")
                    },
                },
                {
                    caption: 'Obrisi podatke o prijavama',
                    action: Xonomy.deleteElement
                }
                ]
            },
            dodatnaPrijava : {
                mustBeBefore: ['priznanjaPravaPrvenstva'],
                asker: Xonomy.askString,
                menu: [
                    {
                        caption:'Dodaj <tipPrijave>',
                        action: Xonomy.newElementChild,
                        actionParameter: '<tipPrijave></tipPrijave>',
                        hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                            return jsElement.hasChildElement("tipPrijave")
                        },
                    },
                    {
                        caption:'Dodaj <brojPrvobitnePrijave>',
                        action: Xonomy.newElementChild,
                        actionParameter: '<brojPrvobitnePrijave></brojPrvobitnePrijave>',
                        hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                            return jsElement.hasChildElement("brojPrvobitnePrijave")
                        },
                    },
                    {
                        caption:'Dodaj <datumPodnosenjaPrijave>',
                        action: Xonomy.newElementChild,
                        actionParameter: '<datumPodnosenjaPrijave></datumPodnosenjaPrijave>',
                        hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                            return jsElement.hasChildElement("datumPodnosenjaPrijave")
                        },
                    },
                ]
            },
            tipPrijave: {
                mustBeBefore: ['brojPrvobitnePrijave', 'datumPodnosenjaPrijave'],
                hasText: true,
                oneliner: true,
                asker: Xonomy.askPicklist,
                askerParameter: ["izdvojena" , "dodatna"],
                menu:[{
                  caption:'Obrisi tip prijave',
                  action:Xonomy.deleteElement
                }
                ]
            },
            brojPrvobitnePrijave: {
                mustBeBefore: ['datumPodnosenjaPrijave'],
                hasText: true,
                oneliner: true,
                asker: Xonomy.askString,
                menu:[{
                  caption:'Obrisi broj prvobitne prijave',
                  action:Xonomy.deleteElement
                }
                ]
            },
            datumPodnosenjaPrijave: {
                hasText: true,
                oneliner: true,
                asker: Xonomy.askString,
                menu:[{
                  caption:'Obrisi datum podnosenja prijave',
                  action:Xonomy.deleteElement
                }
                ]
            },
            priznanjaPravaPrvenstva: {
                menu: [
                    {
                        caption:'Dodaj <priznanjePravaPrvenstva>',
                        action: Xonomy.newElementChild,
                        actionParameter: '<priznanjePravaPrvenstva></priznanjePravaPrvenstva>'
                    },
                    {
                        caption: 'Obrisi priznanja prava prvenstva',
                        action: Xonomy.deleteElement
                    }
                ]
            },
            priznanjePravaPrvenstva : {
                menu:[
                    {
                        caption:'Dodaj <datumPrijave>',
                        action: Xonomy.newElementChild,
                        actionParameter: '<datumPrijave></datumPrijave>',
                        hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                            return jsElement.hasChildElement("datumPrijave")
                        },
                    },
                    {
                        caption:'Dodaj <brojRanijePrijave>',
                        action: Xonomy.newElementChild,
                        actionParameter: '<brojRanijePrijave></brojRanijePrijave>',
                        hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                            return jsElement.hasChildElement("brojRanijePrijave")
                        },
                    },
                    {
                        caption:'Dodaj <dvoslovnaOznakaDrzaveOrganizacije>',
                        action: Xonomy.newElementChild,
                        actionParameter: '<dvoslovnaOznakaDrzaveOrganizacije></dvoslovnaOznakaDrzaveOrganizacije>',
                        hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                            return jsElement.hasChildElement("dvoslovnaOznakaDrzaveOrganizacije")
                        },
                    },
                    {
                        caption: 'Obrisi priznanje prava prvenstva',
                        action: Xonomy.deleteElement
                    }
                    ]
            },
            datumPrijave: {
                mustBeBefore: ['brojRanijePrijave', 'dvoslovnaOznakaDrzaveOrganizacije'],
                hasText: true,
                oneliner: true,
                asker: Xonomy.askString,
                menu:[{
                  caption:'Obrisi broj datuma prijave',
                  action:Xonomy.deleteElement
                }
                ]
            },
            brojRanijePrijave: {
                mustBeBefore: ['dvoslovnaOznakaDrzaveOrganizacije'],
                hasText: true,
                oneliner: true,
                asker: Xonomy.askString,
                menu:[{
                  caption:'Obrisi broj ranije prijave',
                  action:Xonomy.deleteElement
                }
                ]
            },
            dvoslovnaOznakaDrzaveOrganizacije: {
                hasText: true,
                oneliner: true,
                asker: Xonomy.askString,
                menu:[{
                  caption:'Obrisi dvoslovnu oznaku drzave ili organizacije',
                  action:Xonomy.deleteElement
                }
                ]
            },

            /* NAZIV PRONALASKA */
            nazivPronalaska : {
                mustBeBefore: ['podnosilac', 'pronalazac', 'punomocnik'],
                asker: Xonomy.askString,
                menu:[
                {
                    caption:'Dodaj <srpskiNaziv>',
                    action: Xonomy.newElementChild,
                    actionParameter: '<srpskiNaziv></srpskiNaziv>',
                    hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                        return jsElement.hasChildElement("srpskiNaziv")
                    },
                },
                {
                    caption:'Dodaj <engleskiNaziv>',
                    action: Xonomy.newElementChild,
                    actionParameter: '<engleskiNaziv></engleskiNaziv>',
                    hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                        return jsElement.hasChildElement("engleskiNaziv")
                    },
                },
                {
                    caption: 'Obrisi naziv pronalaska',
                    action: Xonomy.deleteElement
                }]
            },
            srpskiNaziv : {
                mustBeBefore: ['engleskiNaziv'],
                hasText: true,
                oneliner: true,
                asker: Xonomy.askString,
                menu:[{
                  caption:'Obrisi srpski naziv',
                  action:Xonomy.deleteElement
                }
                ]
            },
            engleskiNaziv : {
                hasText: true,
                oneliner: true,
                asker: Xonomy.askString,
                menu:[{
                  caption:'Obrisi engleski naziv',
                  action:Xonomy.deleteElement
                }
                ]
            },

            /* PODNOSILAC */
            podnosilac : {
                mustBeBefore: ['pronalazac', 'punomocnik'],
                asker: Xonomy.askString,
                menu:[
                {
                    caption:'Dodaj <naziv>',
                    action: Xonomy.newElementChild,
                    actionParameter: '<naziv></naziv>',
                    hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                        return jsElement.hasChildElement("naziv")
                    },
                },
                {
                    caption:'Dodaj <drzavljanstvo>',
                    action: Xonomy.newElementChild,
                    actionParameter: '<drzavljanstvo></drzavljanstvo>',
                    hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                        return jsElement.hasChildElement("drzavljanstvo")
                    },
                },
                {
                    caption:'Dodaj <adresa>',
                    action: Xonomy.newElementChild,
                    actionParameter: '<adresa></adresa>',
                    hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                        return jsElement.hasChildElement("adresa")
                    },
                },
                {
                    caption:'Dodaj <kontaktPodaci>',
                    action: Xonomy.newElementChild,
                    actionParameter: '<kontaktPodaci></kontaktPodaci>',
                    hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                        return jsElement.hasChildElement("kontaktPodaci")
                    },
                },
                {
                    caption:'Dodaj <podnosilacJePronalazac>',
                    action: Xonomy.newElementChild,
                    actionParameter: '<podnosilacJePronalazac></podnosilacJePronalazac>',
                    hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                        return jsElement.hasChildElement("podnosilacJePronalazac")
                    },
                },
                {
                    caption:'Dodaj <nacinDostavljanja>',
                    action: Xonomy.newElementChild,
                    actionParameter: '<nacinDostavljanja></nacinDostavljanja>',
                    hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                        return jsElement.hasChildElement("nacinDostavljanja")
                    },
                },
                {
                    caption: 'Obrisi podnosioca',
                    action: Xonomy.deleteElement
                }]
            },
            naziv : {
                mustBeBefore: ['drzavljanstvo', 'adresa', 'kontaktPodaci', 'podnosilacJePronalazac', 'nacinDostavljanja'],
                hasText: true,
                oneliner: true,
                asker: Xonomy.askString,
                menu:[{
                  caption:'Obrisi naziv',
                  action:Xonomy.deleteElement
                }
                ]
            },
            drzavljanstvo : {
                mustBeBefore: ['adresa', 'kontaktPodaci', 'podnosilacJePronalazac', 'nacinDostavljanja'],
                hasText: true,
                oneliner: true,
                asker: Xonomy.askString,
                menu:[{
                  caption:'Obrisi drzavljanstvo',
                  action:Xonomy.deleteElement
                }
                ]
            },
            adresa : {
                mustBeBefore: ['kontaktPodaci', 'podnosilacJePronalazac', 'nacinDostavljanja'],
                asker: Xonomy.askString,
                menu:[
                {
                    caption:'Dodaj <ulicaIBroj>',
                    action: Xonomy.newElementChild,
                    actionParameter: '<ulicaIBroj></ulicaIBroj>',
                    hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                        return jsElement.hasChildElement("ulicaIBroj")
                    },
                },
                {
                    caption:'Dodaj <postanskiBroj>',
                    action: Xonomy.newElementChild,
                    actionParameter: '<postanskiBroj></postanskiBroj>',
                    hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                        return jsElement.hasChildElement("postanskiBroj")
                    },
                },
                {
                    caption:'Dodaj <mesto>',
                    action: Xonomy.newElementChild,
                    actionParameter: '<mesto></mesto>',
                    hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                        return jsElement.hasChildElement("mesto")
                    },
                },
                {
                    caption:'Dodaj <drzava>',
                    action: Xonomy.newElementChild,
                    actionParameter: '<drzava></drzava>',
                    hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                        return jsElement.hasChildElement("drzava")
                    },
                },
                {
                  caption:'Obrisi adresu',
                  action:Xonomy.deleteElement
                }
                ]
            },
            ulicaIBroj : {
                mustBeBefore: ['postanskiBroj', 'mesto', 'drzava'],
                hasText: true,
                oneliner: true,
                asker: Xonomy.askString,
                menu:[{
                  caption:'Obrisi ulicu i broj',
                  action:Xonomy.deleteElement
                }
                ]
            },
            postanskiBroj : {
                mustBeBefore: ['mesto', 'drzava'],
                hasText: true,
                oneliner: true,
                asker: Xonomy.askString,
                menu:[{
                  caption:'Obrisi postanski broj',
                  action:Xonomy.deleteElement
                }
                ]
            },
            mesto : {
                mustBeBefore: ['drzava'],
                hasText: true,
                oneliner: true,
                asker: Xonomy.askString,
                menu:[{
                  caption:'Obrisi mesto',
                  action:Xonomy.deleteElement
                }
                ]
            },
            drzava : {
                hasText: true,
                oneliner: true,
                asker: Xonomy.askString,
                menu:[{
                  caption:'Obrisi drzavu',
                  action:Xonomy.deleteElement
                }
                ]
            },
            kontaktPodaci : {
                mustBeBefore: ['podnosilacJePronalazac', 'nacinDostavljanja'],
                asker: Xonomy.askString,
                menu:[
                {
                    caption:'Dodaj <brojTelefona>',
                    action: Xonomy.newElementChild,
                    actionParameter: '<brojTelefona></brojTelefona>',
                    hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                        return jsElement.hasChildElement("brojTelefona")
                    },
                },
                {
                    caption:'Dodaj <brojFaksa>',
                    action: Xonomy.newElementChild,
                    actionParameter: '<brojFaksa></brojFaksa>',
                    hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                        return jsElement.hasChildElement("brojFaksa")
                    },
                },
                {
                    caption:'Dodaj <ePosta>',
                    action: Xonomy.newElementChild,
                    actionParameter: '<ePosta></ePosta>',
                    hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                        return jsElement.hasChildElement("ePosta")
                    },
                },
                {
                  caption:'Obrisi kontakt podatke',
                  action:Xonomy.deleteElement
                }
                ]
            },
            brojTelefona : {
                mustBeBefore: ['brojFaksa', 'ePosta'],
                hasText: true,
                oneliner: true,
                asker: Xonomy.askString,
                menu:[{
                  caption:'Obrisi broj telefona',
                  action:Xonomy.deleteElement
                }
                ]
            },
            brojFaksa : {
                mustBeBefore: ['ePosta'],
                hasText: true,
                oneliner: true,
                asker: Xonomy.askString,
                menu:[{
                  caption:'Obrisi broj faksa',
                  action:Xonomy.deleteElement
                }
                ]
            },
            ePosta : {
                hasText: true,
                oneliner: true,
                asker: Xonomy.askString,
                menu:[{
                  caption:'Obrisi ePostu',
                  action:Xonomy.deleteElement
                }
                ]
            },
            podnosilacJePronalazac : {
                mustBeBefore: ['nacinDostavljanja'],
                hasText: true,
                oneliner: true,
                asker: Xonomy.askPicklist,
                askerParameter: ["true" , "false"],
                menu:[{
                  caption:'Obrisi podnosilac je pronalazac',
                  action:Xonomy.deleteElement
                }
                ]
            },
            nacinDostavljanja : {
                asker: Xonomy.askString,
                menu:[
                {
                    caption:'Dodaj <nacinDostavljanjaStr>',
                    action: Xonomy.newElementChild,
                    actionParameter: '<nacinDostavljanjaStr></nacinDostavljanjaStr>',
                    hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                        return jsElement.hasChildElement("nacinDostavljanjaStr")
                    },
                },
                {
                    caption:'Dodaj <email>',
                    action: Xonomy.newElementChild,
                    actionParameter: '<email></email>',
                    hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                        return jsElement.hasChildElement("email")
                    },
                },
                {
                    caption:'Dodaj <adresa>',
                    action: Xonomy.newElementChild,
                    actionParameter: '<adresa></adresa>',
                    hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                        return jsElement.hasChildElement("adresa")
                    },
                },
                {
                  caption:'Obrisi nacin dostavljanja',
                  action:Xonomy.deleteElement
                }
                ]
            },
            nacinDostavljanjaStr : {
                mustBeBefore: ['email', 'adresa'],
                hasText: true,
                oneliner: true,
                asker: Xonomy.askPicklist,
                askerParameter: ["elektronski" , "papirni"],
                menu:[{
                  caption:'Obrisi nacin dostavljanja',
                  action:Xonomy.deleteElement
                }
                ]
            },
            email : {
                mustBeBefore: ['adresa'],
                hasText: true,
                oneliner: true,
                asker: Xonomy.askString,
                menu:[{
                  caption:'Obrisi email',
                  action:Xonomy.deleteElement
                }
                ]
            },

            /* PRONALAZAC */
            pronalazac : {
                mustBeBefore: ['punomocnik'],
                asker: Xonomy.askString,
                menu:[
                {
                    caption:'Dodaj <naziv>',
                    action: Xonomy.newElementChild,
                    actionParameter: '<naziv></naziv>',
                    hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                        return jsElement.hasChildElement("naziv")
                    },
                },
                {
                    caption:'Dodaj <adresa>',
                    action: Xonomy.newElementChild,
                    actionParameter: '<adresa></adresa>',
                    hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                        return jsElement.hasChildElement("adresa")
                    },
                },
                {
                    caption:'Dodaj <kontaktPodaci>',
                    action: Xonomy.newElementChild,
                    actionParameter: '<kontaktPodaci></kontaktPodaci>',
                    hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                        return jsElement.hasChildElement("kontaktPodaci")
                    },
                },
                {
                    caption:'Dodaj <zeliBitiUPrijavi>',
                    action: Xonomy.newElementChild,
                    actionParameter: '<zeliBitiUPrijavi></zeliBitiUPrijavi>',
                    hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                        return jsElement.hasChildElement("zeliBitiUPrijavi")
                    },
                },
                {
                    caption: 'Obrisi pronalazaca',
                    action: Xonomy.deleteElement
                }]
            },
            zeliBitiUPrijavi : {
                hasText: true,
                oneliner: true,
                asker: Xonomy.askPicklist,
                askerParameter: ["true" , "false"],
                menu:[{
                  caption:'Obrisi zeli biti u prijavi',
                  action:Xonomy.deleteElement
                }
                ]
            },

            /* PUNOMOCNIK */
            punomocnik : {
                asker: Xonomy.askString,
                menu:[
                {
                    caption:'Dodaj <tipPunomocnika>',
                    action: Xonomy.newElementChild,
                    actionParameter: '<tipPunomocnika></tipPunomocnika>',
                    hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                        return jsElement.hasChildElement("tipPunomocnika")
                    },
                },
                {
                    caption:'Dodaj <zajednickiPredstavnik>',
                    action: Xonomy.newElementChild,
                    actionParameter: '<zajednickiPredstavnik></zajednickiPredstavnik>',
                    hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                        return jsElement.hasChildElement("zajednickiPredstavnik")
                    },
                },
                {
                    caption:'Dodaj <naziv>',
                    action: Xonomy.newElementChild,
                    actionParameter: '<naziv></naziv>',
                    hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                        return jsElement.hasChildElement("naziv")
                    },
                },
                {
                    caption:'Dodaj <adresa>',
                    action: Xonomy.newElementChild,
                    actionParameter: '<adresa></adresa>',
                    hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                        return jsElement.hasChildElement("adresa")
                    },
                },
                {
                    caption:'Dodaj <kontaktPodaci>',
                    action: Xonomy.newElementChild,
                    actionParameter: '<kontaktPodaci></kontaktPodaci>',
                    hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                        return jsElement.hasChildElement("kontaktPodaci")
                    },
                },                
                {
                    caption: 'Obrisi punomocnika',
                    action: Xonomy.deleteElement
                }]
            },
            tipPunomocnika : {
                hasText: true,
                oneliner: true,
                asker: Xonomy.askPicklist,
                askerParameter: ["zastupanje" , "prijem"],
                menu:[{
                  caption:'Obrisi tip punomocnika',
                  action:Xonomy.deleteElement
                }
                ]
            },
            zajednickiPredstavnik : {
                hasText: true,
                oneliner: true,
                asker: Xonomy.askPicklist,
                askerParameter: ["true" , "false"],
                menu:[{
                  caption:'Obrisi zajednicki predstavnik',
                  action:Xonomy.deleteElement
                }
                ]
            },
        },
    }
}
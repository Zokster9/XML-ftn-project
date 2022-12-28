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
            nazivPronalaska : {
                mustBeBefore: ['podnosilac', 'pronalazac', 'punomocnik'],
                asker: Xonomy.askString,
                menu:[{
                    caption: 'Obrisi naziv pronalaska',
                    action: Xonomy.deleteElement
                }]
            },
            podnosilac : {
                mustBeBefore: ['pronalazac', 'punomocnik'],
                asker: Xonomy.askString,
                menu:[{
                    caption: 'Obrisi podnosioca',
                    action: Xonomy.deleteElement
                }]
            },
            pronalazac : {
                mustBeBefore: ['punomocnik'],
                asker: Xonomy.askString,
                menu:[{
                    caption: 'Obrisi pronalazaca',
                    action: Xonomy.deleteElement
                }]
            },
            punomocnik : {
                asker: Xonomy.askString,
                menu:[{
                    caption: 'Obrisi punomocnika',
                    action: Xonomy.deleteElement
                }]
            }
        },
    }
}
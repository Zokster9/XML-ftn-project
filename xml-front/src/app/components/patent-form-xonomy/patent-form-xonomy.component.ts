import { AfterViewInit, Component, OnInit } from '@angular/core';
import { Entity } from 'src/app/models/Entity';
import { PatentService } from 'src/app/services/patent.service';
import { XonomyService } from 'src/app/services/xonomy.service';

declare const Xonomy: any
@Component({
  selector: 'app-patent-form-xonomy',
  templateUrl: './patent-form-xonomy.component.html',
  styleUrls: ['./patent-form-xonomy.component.css']
})
export class PatentFormXonomyComponent implements OnInit, AfterViewInit{
  constructor(private xonomyService: XonomyService, private patentService: PatentService){

  }
  ngOnInit(): void {
  }

  ngAfterViewInit(): void {
    let element = document.getElementById("editor");
    let specification = this.xonomyService.zahtevSpecification;
    let xmlString = '<zahtevZaPriznanjePatenta></zahtevZaPriznanjePatenta>';
    Xonomy.render(xmlString, element, specification);
  }
  
  send() {
    let text = Xonomy.harvest();
    const entity = new Entity();
    entity.text = text;
    entity.text = entity.text?.replaceAll("nacinDostavljanjaStr", "nacinDostavljanja");
    entity.text = entity.text?.replaceAll("priznanjePravaPrvenstva", "priznanjaPravaPrvenstva");
    console.log(entity.text);
    this.patentService.addPatentXonomy(entity).subscribe(data => {
      console.log(data);
    })
  }
}

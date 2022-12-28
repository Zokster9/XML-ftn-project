import { AfterViewInit, Component, OnInit } from '@angular/core';
import { XonomyService } from 'src/app/services/xonomy.service';

declare const Xonomy: any
@Component({
  selector: 'app-patent-form-xonomy',
  templateUrl: './patent-form-xonomy.component.html',
  styleUrls: ['./patent-form-xonomy.component.css']
})
export class PatentFormXonomyComponent implements OnInit, AfterViewInit{
  constructor(private xonomyService: XonomyService){

  }
  ngOnInit(): void {
  }

  ngAfterViewInit(): void {
    let element = document.getElementById("editor");
    let specification = this.xonomyService.zahtevSpecification;
    let xmlString = '<zahtevZaPriznanjePatenta></zahtevZaPriznanjePatenta>';
    Xonomy.render(xmlString, element, specification);
  }
  
}

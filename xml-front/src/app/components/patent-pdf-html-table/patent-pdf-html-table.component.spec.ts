import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatentPdfHtmlTableComponent } from './patent-pdf-html-table.component';

describe('PatentPdfHtmlTableComponent', () => {
  let component: PatentPdfHtmlTableComponent;
  let fixture: ComponentFixture<PatentPdfHtmlTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PatentPdfHtmlTableComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PatentPdfHtmlTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

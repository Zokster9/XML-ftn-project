import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ZigPdfHtmlTableComponent } from './zig-pdf-html-table.component';

describe('ZigPdfHtmlTableComponent', () => {
  let component: ZigPdfHtmlTableComponent;
  let fixture: ComponentFixture<ZigPdfHtmlTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ZigPdfHtmlTableComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ZigPdfHtmlTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

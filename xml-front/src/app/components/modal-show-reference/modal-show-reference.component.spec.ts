import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalShowReferenceComponent } from './modal-show-reference.component';

describe('ModalShowReferenceComponent', () => {
  let component: ModalShowReferenceComponent;
  let fixture: ComponentFixture<ModalShowReferenceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModalShowReferenceComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModalShowReferenceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

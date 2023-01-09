import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalAcceptDeclineRequestComponent } from './modal-accept-decline-request.component';

describe('ModalAcceptDeclineRequestComponent', () => {
  let component: ModalAcceptDeclineRequestComponent;
  let fixture: ComponentFixture<ModalAcceptDeclineRequestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModalAcceptDeclineRequestComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModalAcceptDeclineRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

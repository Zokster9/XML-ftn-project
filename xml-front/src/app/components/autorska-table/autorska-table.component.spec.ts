import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AutorskaTableComponent } from './autorska-table.component';

describe('AutorskaTableComponent', () => {
  let component: AutorskaTableComponent;
  let fixture: ComponentFixture<AutorskaTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AutorskaTableComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AutorskaTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

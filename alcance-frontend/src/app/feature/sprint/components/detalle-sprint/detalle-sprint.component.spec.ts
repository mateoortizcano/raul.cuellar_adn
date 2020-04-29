import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetalleSprintComponent } from './detalle-sprint.component';

describe('DetalleSprintComponent', () => {
  let component: DetalleSprintComponent;
  let fixture: ComponentFixture<DetalleSprintComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetalleSprintComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetalleSprintComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

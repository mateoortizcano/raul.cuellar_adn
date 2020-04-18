import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ActualizarSprintComponent } from './actualizar-sprint.component';

describe('ActualizarSprintComponent', () => {
  let component: ActualizarSprintComponent;
  let fixture: ComponentFixture<ActualizarSprintComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ActualizarSprintComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ActualizarSprintComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

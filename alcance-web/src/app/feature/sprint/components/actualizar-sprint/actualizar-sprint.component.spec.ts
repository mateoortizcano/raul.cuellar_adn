import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ActualizarSprintComponent } from './actualizar-sprint.component';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing';
import { HttpService } from '@core/services/http.service';

describe('ActualizarSprintComponent', () => {
  let component: ActualizarSprintComponent;
  let fixture: ComponentFixture<ActualizarSprintComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ActualizarSprintComponent ],
      imports: [
        CommonModule,
        HttpClientModule,
        RouterTestingModule
      ],
      providers: [HttpService]
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

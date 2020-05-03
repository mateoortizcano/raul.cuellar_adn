import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetalleSprintComponent } from './detalle-sprint.component';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing';
import { HttpService } from '@core/services/http.service';
import { SprintService } from '@sprint/shared/service/sprint.service';
import { SprintDetalles } from '@sprint/shared/model/sprint-detalles';
import { PresupuestoSprint } from '@sprint/shared/model/presupuesto-sprint';
import { of } from 'rxjs';

describe('DetalleSprintComponent', () => {
  let component: DetalleSprintComponent;
  let fixture: ComponentFixture<DetalleSprintComponent>;
  let sprintService: SprintService;

  const presupuestoSprint: PresupuestoSprint[] = [];
  const sprintDetalle: SprintDetalles =
    new SprintDetalles(1, 'Sprint 1', '2020-01-02 05:00:00', '2020-01-21 04:59:59', 12, 3, 1, presupuestoSprint);

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetalleSprintComponent ],
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
    fixture = TestBed.createComponent(DetalleSprintComponent);
    component = fixture.componentInstance;
    sprintService = TestBed.inject(SprintService);
    spyOn(sprintService, 'listarDetalles').and.returnValue(
      of(sprintDetalle)
    );
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ActualizarSprintComponent } from './actualizar-sprint.component';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing';
import { HttpService } from '@core/services/http.service';
import { SprintService } from '@sprint/shared/service/sprint.service';
import { of } from 'rxjs';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { AlertaService } from '@core/services/alerta.service';
import { ActivatedRoute, convertToParamMap } from '@angular/router';
import { SprintDetalles } from '@sprint/shared/model/sprint-detalles';
import { PresupuestoSprint } from '@sprint/shared/model/presupuesto-sprint';

describe('ActualizarSprintComponent', () => {
  let component: ActualizarSprintComponent;
  let fixture: ComponentFixture<ActualizarSprintComponent>;
  let sprintSpyService = null;
  let sprintService: SprintService;
  let route: ActivatedRoute;
  const sprint: SprintDetalles = new SprintDetalles(1, 'Sprint 0', '2020-01-02 05:00:00', '2020-01-21 04:59:59', 12, 3, 1, [
    new PresupuestoSprint(1, 1, 1, 'Desarrollo', 93412, true, 1, 93412, 1, 93412)
  ]);

  beforeEach(async(() => {
    sprintSpyService = jasmine.createSpyObj('SprintService', ['actualizar', 'listarDetalles']);
    TestBed.configureTestingModule({
      declarations: [ ActualizarSprintComponent ],
      imports: [
        CommonModule,
        HttpClientModule,
        RouterTestingModule,
        ReactiveFormsModule,
        FormsModule
      ],
      providers: [
        HttpService,
        { provide: ActivatedRoute, useValue: { snapshot: { paramMap: { get: (id: string) => { '1'; }}}}},
        { provide: SprintService, useValue: sprintSpyService },
        AlertaService],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ActualizarSprintComponent);
    component = fixture.componentInstance;
    sprintService = TestBed.inject(SprintService);
    route = TestBed.inject(ActivatedRoute);
    const idSprint = +route.snapshot.paramMap.get('id');
    sprintSpyService.listarDetalles.and.returnValue(
      of(sprint)
    );
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('Actualizando sprint', () => {
    sprintSpyService.actualizar.and.returnValue(
      of(null)
    );
    expect(component.sprintForm.valid).toBeTruthy();
    component.actualizar();
    expect(sprintSpyService.actualizar).toHaveBeenCalled();
  });

  it('formulario es invalido cuando esta vacio', () => {
    component.sprintForm.controls.nombre.setValue('');
    component.sprintForm.controls.fechaInicial.setValue('');
    component.sprintForm.controls.fechaFinal.setValue('');
    component.sprintForm.controls.numeroPersonas.setValue('');
    expect(component.sprintForm.valid).toBeFalsy();
  });
});

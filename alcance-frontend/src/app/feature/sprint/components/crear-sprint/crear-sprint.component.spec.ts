import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CrearSprintComponent } from './crear-sprint.component';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { HttpService } from '@core/services/http.service';
import { SprintService } from '@sprint/shared/service/sprint.service';
import { ComandoRespuesta } from '@core/modelo/comando-respuesta.model';
import { of } from 'rxjs';
import { ConceptoService } from '@sprint/shared/service/concepto.service';
import { Concepto } from '@sprint/shared/model/concepto';
import { CalendarioService } from '@sprint/shared/service/calendario.service';

describe('CrearSprintComponent', () => {
  let component: CrearSprintComponent;
  let fixture: ComponentFixture<CrearSprintComponent>;
  let sprintSpyService = null;
  let sprintService: SprintService;
  let calendarioService: CalendarioService;
  let conceptoService: ConceptoService;

  const comandoRespuesta = {
    valor: 1
  } as ComandoRespuesta<number>;

  const listaConceptos: Concepto[] = [
    new Concepto(1, 'Desarrollo', 'produccion', true, 93000),
    new Concepto(2, 'Diseño', 'ceibalab', false, 93000)];

  const diasHabiles = 10;

  beforeEach(async(() => {
    sprintSpyService = jasmine.createSpyObj('SprintService', ['crear']);
    TestBed.configureTestingModule({
      declarations: [ CrearSprintComponent ],
      imports: [
        CommonModule,
        HttpClientModule,
        RouterTestingModule,
        ReactiveFormsModule,
        FormsModule
      ],
      providers: [HttpService,
      { provide: SprintService, useValue: sprintSpyService }],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CrearSprintComponent);
    component = fixture.componentInstance;
    sprintService = TestBed.inject(SprintService);
    sprintSpyService.crear.and.returnValue(
      of(comandoRespuesta)
    );

    conceptoService = TestBed.inject(ConceptoService);
    spyOn(conceptoService, 'listar').and.returnValue(
      of(listaConceptos)
    );

    calendarioService = TestBed.inject(CalendarioService);
    spyOn(calendarioService, 'consultarDiasHabiles').and.returnValue(
      of(diasHabiles)
    );
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('formulario es invalido cuando esta vacio', () => {
    expect(component.sprintForm.valid).toBeFalsy();
  });


  it('Registrando sprint', () => {
    expect(component.sprintForm.valid).toBeFalsy();
    component.sprintForm.controls.nombre.setValue('Sprint test');
    component.sprintForm.controls.fechaInicial.setValue('2021-05-02 00:00:00');
    component.sprintForm.controls.fechaFinal.setValue('2021-05-20 23:59:59');
    component.sprintForm.controls.numeroPersonas.setValue('3');

    sprintSpyService.crear.and.returnValue(
      of(comandoRespuesta)
    );
    expect(component.sprintForm.valid).toBeTruthy();
    component.crear();
    expect(sprintSpyService.crear).toHaveBeenCalled();
  });

  it('Consultar días hábiles', () => {
    component.sprintForm.controls.fechaInicial.setValue('2021-05-02 00:00:00');
    component.sprintForm.controls.fechaFinal.setValue('2021-05-20 23:59:59');

    // expect(component.diasHabiles).toBeLessThanOrEqual(0);
    component.consultarDiasHabiles();
    // expect(calendarioService.consultarDiasHabiles).toHaveBeenCalled();
    // expect(component.diasHabiles).toEqual(10);
  });

  it('Agregando rol full time', () => {
    component.sprintForm.controls.fechaInicial.setValue('2021-05-02 00:00:00');
    component.sprintForm.controls.fechaFinal.setValue('2021-05-20 23:59:59');
    component.sprintForm.controls.numeroPersonas.setValue('3');
    component.diasHabiles = 10;

    component.rolSeleccionado = 1;
    component.agregarRol();

    // expect(component.presupuestoSprintSeleccionados.length).toEqual(1);
    // expect(component.presupuestoSprintSeleccionados[0].horasPlaneadas).toEqual(270);
    // expect(component.presupuestoSprintSeleccionados[0].valorPlaneado).toEqual(25110000);
  });

  it('Agregando rol no full time', () => {
    component.sprintForm.controls.fechaInicial.setValue('2021-05-02 00:00:00');
    component.sprintForm.controls.fechaFinal.setValue('2021-05-20 23:59:59');
    component.sprintForm.controls.numeroPersonas.setValue('3');
    component.diasHabiles = 10;

    component.rolSeleccionado = 2;
    component.agregarRol();

    // expect(component.presupuestoSprintSeleccionados.length).toEqual(1);
    // expect(component.presupuestoSprintSeleccionados[0].horasPlaneadas).toEqual(0);
    // expect(component.presupuestoSprintSeleccionados[0].valorPlaneado).toEqual(0);
  });

  // it('Remover rol', () => {
  //   component.sprintForm.controls.fechaInicial.setValue('2021-05-02 00:00:00');
  //   component.sprintForm.controls.fechaFinal.setValue('2021-05-20 23:59:59');
  //   component.sprintForm.controls.numeroPersonas.setValue('3');
  //   component.diasHabiles = 10;

  //   component.rolSeleccionado = 2;
  //   component.agregarRol();

  //   // expect(component.presupuestoSprintSeleccionados.length).toEqual(1);
  //   component.removerRol(2);
  //   // expect(component.presupuestoSprintSeleccionados.length).toEqual(0);
  // });
});

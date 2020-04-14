import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';

import { CrearSprintComponent } from './crear-sprint.component';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing';
import { SprintService } from '../../shared/service/sprint.service';
import { HttpService } from 'src/app/core/services/http.service';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { ComandoRespuesta } from '@core/modelo/comando-respuesta.model';

describe('CrearSprintComponent', () => {
  let component: CrearSprintComponent;
  let fixture: ComponentFixture<CrearSprintComponent>;
  let sprintService: SprintService;

  let sprintSpyService = null;

  const comandoRespuesta = {
    valor: 0
  } as ComandoRespuesta<number>;

  beforeEach(async(() => {
    sprintSpyService = jasmine.createSpyObj('SprintService', ['guardar']);
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
    sprintSpyService.guardar.and.returnValue(
      of(comandoRespuesta)
    );

    fixture = TestBed.createComponent(CrearSprintComponent);
    component = fixture.componentInstance;
    // sprintService = TestBed.inject(SprintService);

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
    component.sprintForm.controls.diasHabiles.setValue('3');
    component.sprintForm.controls.idProyecto.setValue('1');

    sprintSpyService.guardar.and.returnValue(
      of(comandoRespuesta)
    );

    expect(component.sprintForm.valid).toBeTruthy();
    component.crear();
    expect(sprintSpyService.guardar).toHaveBeenCalled()
  });
});

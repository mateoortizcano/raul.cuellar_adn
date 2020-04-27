import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarProyectosComponent } from './listar-proyectos.component';
import { ProyectoResumen } from '@proyecto/shared/model/proyecto-resumen';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing';
import { HttpService } from '@core/services/http.service';
import { ProyectoService } from '@proyecto/shared/service/proyecto.service';
import { of } from 'rxjs';

describe('ListarProyectosComponent', () => {
  let component: ListarProyectosComponent;
  let fixture: ComponentFixture<ListarProyectosComponent>;
  let proyectoService: ProyectoService;
  const listaProyectos: ProyectoResumen[] = [
    new ProyectoResumen(1, 'Proyecto', 'Cliente', 20, 20)
  ];

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListarProyectosComponent ],
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
    fixture = TestBed.createComponent(ListarProyectosComponent);
    component = fixture.componentInstance;
    proyectoService = TestBed.inject(ProyectoService);
    spyOn(proyectoService, 'listarResumen').and.returnValue(
      of(listaProyectos)
    );
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

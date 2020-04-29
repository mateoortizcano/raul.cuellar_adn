import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarSprintsComponent } from './listar-sprints.component';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing';
import { HttpService } from '@core/services/http.service';
import { SprintService } from '@sprint/shared/service/sprint.service';
import { Sprint } from '@sprint/shared/model/sprint';
import { of } from 'rxjs';
import { SprintResumen } from '@sprint/shared/model/sprint-resumen';
import { PresupuestoSprint } from '@sprint/shared/model/presupuesto-sprint';

describe('ListarSprintsComponent', () => {
  let component: ListarSprintsComponent;
  let fixture: ComponentFixture<ListarSprintsComponent>;
  let sprintService: SprintService;
  const presupuestoSprint: PresupuestoSprint[] = [];
  const listaSprints: SprintResumen[] = [
    new SprintResumen(1, 'Sprint 0', '2020-01-02 05:00:00', '2020-01-21 04:59:59', 12, 3, 1,presupuestoSprint),
    new SprintResumen(2, 'Sprint 2', '2020-01-02 05:00:00', '2020-01-21 04:59:59', 12, 3, 1, presupuestoSprint)];

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListarSprintsComponent ],
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
    fixture = TestBed.createComponent(ListarSprintsComponent);
    component = fixture.componentInstance;
    sprintService = TestBed.inject(SprintService);
    spyOn(sprintService, 'listarResumen').and.returnValue(
      of(listaSprints)
    );
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
    sprintService.listarResumen(1).subscribe(resultado =>{
      expect(2).toBe(resultado.length);
    });
  });
});

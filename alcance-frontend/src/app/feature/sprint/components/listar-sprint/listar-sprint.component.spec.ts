import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';

import { ListarSprintComponent } from './listar-sprint.component';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing';
import { SprintService } from '../../shared/service/sprint.service';
import { Sprint } from '../../shared/model/sprint';
import { HttpService } from 'src/app/core/services/http.service';

describe('ListarSprintComponent', () => {
  let component: ListarSprintComponent;
  let fixture: ComponentFixture<ListarSprintComponent>;
  let sprintService: SprintService;
  const listaSprints: Sprint[] = [
    new Sprint('Sprint 0', '2020-01-02 05:00:00', '2020-01-21 04:59:59', 12, 3, 1),
    new Sprint('Sprint 2', '2020-01-02 05:00:00', '2020-01-21 04:59:59', 12, 3, 1)];

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ListarSprintComponent],
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
    fixture = TestBed.createComponent(ListarSprintComponent);
    component = fixture.componentInstance;
    sprintService = TestBed.inject(SprintService);
    spyOn(sprintService, 'consultar').and.returnValue(
      of(listaSprints)
    );
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
    component.listaSprints.subscribe(resultado => {
      expect(2).toBe(resultado.length);
  });
});

});

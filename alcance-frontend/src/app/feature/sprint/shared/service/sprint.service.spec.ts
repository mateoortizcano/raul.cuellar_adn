import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

import { SprintService } from './sprint.service';
import { environment } from 'src/environments/environment';
import { HttpService } from 'src/app/core/services/http.service';
import { Sprint } from '../model/sprint';
import { HttpRequest, HttpResponse } from '@angular/common/http';
import { ComandoRespuesta } from '@core/modelo/comando-respuesta.model';

describe('SprintService', () => {
  let httpMock: HttpTestingController;
  let service: SprintService;
  const apiEPListarSprints = `${environment.endpoint}/proyectos/1/sprints`;
  const apiEPCrearSprints = `${environment.endpoint}/sprints`;

  beforeEach(() => {
    const injector = TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [SprintService, HttpService]
    });
    httpMock = injector.inject(HttpTestingController);
    service = TestBed.inject(SprintService);
  });

  it('should be created', () => {
    const sprintService: SprintService = TestBed.inject(SprintService);
    expect(sprintService).toBeTruthy();
  });

  it('deberia listar sprints', () => {
    const dummySprints = [
      new Sprint(1, 'Sprint 0', '2020-01-02 05:00:00', '2020-01-21 04:59:59', 12, 3, 1),
      new Sprint(2, 'Sprint 2', '2020-01-02 05:00:00', '2020-01-21 04:59:59', 12, 3, 1)
    ];
    service.listar().subscribe(sprints => {
      expect(sprints.length).toBe(2);
      expect(sprints).toEqual(dummySprints);
    });
    const req = httpMock.expectOne(apiEPListarSprints);
    expect(req.request.method).toBe('GET');
    req.flush(dummySprints);
  });

  it('deberia crear un sprint', () => {
    const dummySprint = new Sprint(3, 'Sprint 0', '2020-01-02 05:00:00', '2020-01-21 04:59:59', 12, 3, 1);
    service.guardar(dummySprint).subscribe((respuesta) => {
      expect(respuesta.valor).toBeTruthy();
    });
    const req = httpMock.expectOne(apiEPCrearSprints);
    expect(req.request.method).toBe('POST');
  });
});

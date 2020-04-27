import { TestBed } from '@angular/core/testing';

import { ProyectoService } from './proyecto.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { HttpService } from '@core/services/http.service';

describe('ProyectoService', () => {
  let service: ProyectoService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [ProyectoService, HttpService]
    });
    service = TestBed.inject(ProyectoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

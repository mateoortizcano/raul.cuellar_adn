import { TestBed } from '@angular/core/testing';

import { CargadorService } from './cargador.service';

describe('CargadorService', () => {
  let service: CargadorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CargadorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

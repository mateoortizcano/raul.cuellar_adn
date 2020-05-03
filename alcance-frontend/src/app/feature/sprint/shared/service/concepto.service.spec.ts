import { TestBed } from '@angular/core/testing';

import { ConceptoService } from './concepto.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { HttpService } from '@core/services/http.service';

describe('ConceptoService', () => {
  let service: ConceptoService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [ConceptoService, HttpService]
    });
    service = TestBed.inject(ConceptoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

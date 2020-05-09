import { TestBed } from '@angular/core/testing';

import { CalendarioService } from './calendario.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { HttpService } from '@core/services/http.service';

describe('CalendarioService', () => {
  let service: CalendarioService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [CalendarioService, HttpService]
    });
    service = TestBed.inject(CalendarioService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

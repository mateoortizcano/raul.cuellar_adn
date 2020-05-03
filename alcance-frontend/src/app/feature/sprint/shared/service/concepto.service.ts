import { Injectable } from '@angular/core';
import { HttpService } from '@core/services/http.service';
import { Concepto } from '../model/concepto';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ConceptoService {

  constructor(protected http: HttpService) { }

  public listar() {
    return this.http.doGet<Concepto[]>(`${environment.endpoint}/conceptos`);
  }
}

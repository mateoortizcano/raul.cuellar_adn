import { Injectable } from '@angular/core';
import { HttpService } from '@core/services/http.service';
import { Concepto } from '../model/concepto';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ConceptoService {

  constructor(protected http: HttpService) { }

  public listar(idProyecto: number) {
    return this.http.doGet<Concepto[]>(`${environment.endpoint}/proyectos/${idProyecto}/conceptos`);
  }
}

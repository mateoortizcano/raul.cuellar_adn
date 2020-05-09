import { Injectable } from '@angular/core';
import { HttpService } from '@core/services/http.service';
import { environment } from 'src/environments/environment';
import { ConsultaCalendario } from '../model/consulta-calendario';

@Injectable({
  providedIn: 'root'
})
export class CalendarioService {

  constructor(protected http: HttpService) { }

  public consultarDiasHabiles(consultaCalendario: ConsultaCalendario) {
    return this.http.doPost<ConsultaCalendario, number>(`${environment.endpoint}/calendario`, consultaCalendario);
  }
}

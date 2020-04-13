import { Injectable } from '@angular/core';
import { HttpService } from '@core-service/http.service';
import { environment } from 'src/environments/environment';
import { Sprint } from '../model/sprint';
import { ComandoRespuesta } from '../../../../core/modelo/comando-respuesta.model';

@Injectable({
  providedIn: 'root'
})
export class SprintService {

  constructor(protected http: HttpService) {}

  public consultar() {
    return this.http.doGet<Sprint[]>(`${environment.endpoint}/proyectos/1/sprints`);
  }

  public guardar(sprint: Sprint) {
    return this.http.doPost<Sprint, ComandoRespuesta<number>>(`${environment.endpoint}/sprints`, sprint);
  }
}

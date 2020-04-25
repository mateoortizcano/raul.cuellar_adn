import { Injectable } from '@angular/core';
import { HttpService } from '@core/services/http.service';
import { Sprint } from '../model/sprint';
import { environment } from 'src/environments/environment';
import { ComandoRespuesta } from '@core/modelo/comando-respuesta.model';

@Injectable({
  providedIn: 'root'
})
export class SprintService {

  constructor(protected http: HttpService) {}

  public consultar(id: number) {
    return this.http.doGet<Sprint>(`${environment.endpoint}/proyectos/1/sprints/${id}`);
  }

  public listar() {
    return this.http.doGet<Sprint[]>(`${environment.endpoint}/proyectos/1/sprints`);
  }

  public crear(sprint: Sprint) {
    return this.http.doPost<Sprint, ComandoRespuesta<number>>(`${environment.endpoint}/sprints`, sprint);
  }

  public actualizar(sprint: Sprint) {
    return this.http.doPut<Sprint>(`${environment.endpoint}/sprints/${sprint.id}`, sprint);
  }

  public eliminar(id: number) {
    return this.http.doDelete<string>(`${environment.endpoint}/sprints/${id}`);
  }
}

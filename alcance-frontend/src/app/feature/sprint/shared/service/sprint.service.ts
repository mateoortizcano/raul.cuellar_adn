import { Injectable } from '@angular/core';
import { HttpService } from '@core/services/http.service';
import { Sprint } from '../model/sprint';
import { environment } from 'src/environments/environment';
import { ComandoRespuesta } from '@core/modelo/comando-respuesta.model';
import { SprintResumen } from '../model/sprint-resumen';
import { SprintDetalles } from '../model/sprint-detalles';
import { ComandoSprint } from '../model/comando-sprint';

@Injectable({
  providedIn: 'root'
})
export class SprintService {

  constructor(protected http: HttpService) {}

  public consultar(id: number) {
    return this.http.doGet<Sprint>(`${environment.endpoint}/proyectos/1/sprints/${id}`);
  }

  public listar(idProyecto: number) {
    return this.http.doGet<Sprint[]>(`${environment.endpoint}/proyectos/${idProyecto}/sprints`);
  }

  public listarResumen(idProyecto: number) {
    return this.http.doGet<SprintResumen[]>(`${environment.endpoint}/proyectos/${idProyecto}/sprints/resumen`);
  }

  public listarDetalles(idProyecto: number, idSprint: number) {
    return this.http.doGet<SprintDetalles>(`${environment.endpoint}/proyectos/${idProyecto}/sprints/${idSprint}/detalles`);
  }

  public crear(sprint: ComandoSprint) {
    return this.http.doPost<ComandoSprint, ComandoRespuesta<number>>(`${environment.endpoint}/sprints`, sprint);
  }

  public actualizar(sprint: ComandoSprint) {
    return this.http.doPut<ComandoSprint>(`${environment.endpoint}/sprints/${sprint.id}`, sprint);
  }

  public eliminar(id: number) {
    return this.http.doDelete<string>(`${environment.endpoint}/sprints/${id}`);
  }
}

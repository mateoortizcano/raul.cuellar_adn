import { Injectable } from '@angular/core';
import { Proyecto } from '../model/proyecto';
import { environment } from 'src/environments/environment';
import { HttpService } from '@core/services/http.service';
import { ProyectoResumen } from '../model/proyecto-resumen';

@Injectable({
  providedIn: 'root'
})
export class ProyectoService {

  constructor(protected http: HttpService) { }

  public listar() {
    return this.http.doGet<Proyecto[]>(`${environment.endpoint}/proyectos`);
  }

  public listarResumen() {
    return this.http.doGet<ProyectoResumen[]>(`${environment.endpoint}/proyectos/resumen`);
  }
}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment.prod';
import { Proyecto } from '../modelo/proyectos';

const ApiUrl = environment.apiUrl;
@Injectable({
  providedIn: 'root'
})
export class ProyectosService {

  constructor(private http: HttpClient) { }

  consultarProyectos() {
    return this.http.get<Proyecto[]>(ApiUrl);
  }
}

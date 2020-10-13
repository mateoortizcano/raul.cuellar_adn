import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { ProyectosService } from '../../servicios/proyectos.service';
import { Proyecto } from '../../modelo/proyectos';

@Component({
  selector: 'app-listado-proyectos',
  templateUrl: './listado-proyectos.page.html',
  styleUrls: ['./listado-proyectos.page.scss'],
})
export class ListadoProyectosPage implements OnInit {

  proyectos: Observable<Proyecto[]>;

  constructor(private proyectosService: ProyectosService) { }

  ngOnInit() {
    this.proyectos = this.proyectosService.consultarProyectos();
  }

}

import { Component, OnInit } from '@angular/core';
import { ProyectoService } from '../../shared/service/proyecto.service';
import { CargadorService } from '@core/services/cargador.service';
import { ProyectoResumen } from '@proyecto/shared/model/proyecto-resumen';

@Component({
  selector: 'app-listar-proyectos',
  templateUrl: './listar-proyectos.component.html',
  styleUrls: ['./listar-proyectos.component.sass']
})
export class ListarProyectosComponent implements OnInit {

  listaProyectos: ProyectoResumen[];

  constructor(protected proyectoService: ProyectoService,
              protected cargadorService: CargadorService) { }

  ngOnInit(): void {
    sessionStorage.removeItem('idProyecto');
    sessionStorage.removeItem('nombreProyecto');
    sessionStorage.removeItem('clienteProyecto');
    this.cargarListarProyectos();
  }

  cargarListarProyectos() {
    this.cargadorService.mostrar();
    this.proyectoService.listarResumen().subscribe(resp => {
      this.listaProyectos = resp;
      this.cargadorService.ocultar();
    });
  }

  irAProyecto(proyecto: ProyectoResumen) {
    if (typeof(Storage) !== 'undefined') {
      sessionStorage.setItem('idProyecto', proyecto.id.toString());
      sessionStorage.setItem('nombreProyecto', proyecto.nombre.toString());
      sessionStorage.setItem('clienteProyecto', proyecto.cliente.toString());
    }
  }
}

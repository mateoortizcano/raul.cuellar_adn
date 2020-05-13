import { Component, OnInit } from '@angular/core';
import { SprintService } from '../../shared/service/sprint.service';
import { Sprint } from '@sprint/shared/model/sprint';
import { SprintResumen } from '@sprint/shared/model/sprint-resumen';
import { AlertaService } from '@core/services/alerta.service';
import { CargadorService } from '@core/services/cargador.service';

@Component({
  selector: 'app-listar-sprints',
  templateUrl: './listar-sprints.component.html',
  styleUrls: ['./listar-sprints.component.sass']
})
export class ListarSprintsComponent implements OnInit {
  listaSprints: SprintResumen[];
  idProyecto: number;
  nombreProyecto: string;
  clienteProyecto: string;

  constructor(
    protected alertaService: AlertaService,
    protected sprintService: SprintService,
    protected cargadorService: CargadorService) { }

  ngOnInit(): void {
    this.idProyecto = +sessionStorage.getItem('idProyecto');
    this.nombreProyecto = sessionStorage.getItem('nombreProyecto');
    this.clienteProyecto = sessionStorage.getItem('clienteProyecto');
    this.cargarListaSprints(this.idProyecto);
  }

  eliminar(sprint: Sprint) {
    this.sprintService.eliminar(sprint.id).subscribe(resp => {
      this.alertaService.success('Ya lo borramos');
      this.cargarListaSprints(this.idProyecto);
    });
    return false;
  }

  cargarListaSprints(idProyecto: number) {
    this.cargadorService.mostrar();
    this.sprintService.listarResumen(idProyecto).subscribe(resp => {
      this.listaSprints = resp;
      this.cargadorService.ocultar();
    });
  }
}

import { Component, OnInit } from '@angular/core';
import { SprintService } from '../../shared/service/sprint.service';
import { Observable } from 'rxjs';
import { Sprint } from '@sprint/shared/model/sprint';
import { AlertaService } from '@core/services/alerta.service';
import { CargadorService } from '@core/services/cargador.service';

@Component({
  selector: 'app-listar-sprints',
  templateUrl: './listar-sprints.component.html',
  styleUrls: ['./listar-sprints.component.sass']
})
export class ListarSprintsComponent implements OnInit {
  listaSprints: Observable<Sprint[]>;

  constructor(
    protected alertaService: AlertaService,
    protected sprintService: SprintService,
    protected cargadorService: CargadorService) { }

  ngOnInit(): void {
    this.cargarListaSprints();
  }

  eliminar(sprint: Sprint) {
    this.sprintService.eliminar(sprint.id).subscribe(resp => {
      this.alertaService.success('Ya lo borramos');
      this.cargarListaSprints();
    });
    return false;
  }

  cargarListaSprints() {
    this.cargadorService.mostrar();
    this.listaSprints = this.sprintService.listar();
    this.cargadorService.ocultar();
  }
}

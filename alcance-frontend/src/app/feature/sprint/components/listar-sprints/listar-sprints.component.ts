import { Component, OnInit } from '@angular/core';
import { SprintService } from '../../shared/service/sprint.service';
import { Observable } from 'rxjs';
import { Sprint } from '@sprint/shared/model/sprint';
import { AlertaService } from '@core/services/alerta.service';
import { CargadorService } from '@core/services/cargador.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-listar-sprints',
  templateUrl: './listar-sprints.component.html',
  styleUrls: ['./listar-sprints.component.sass']
})
export class ListarSprintsComponent implements OnInit {
  listaSprints: Observable<Sprint[]>;

  constructor(
    protected route: ActivatedRoute,
    protected alertaService: AlertaService,
    protected sprintService: SprintService,
    protected cargadorService: CargadorService) { }

  ngOnInit(): void {
    const idProyecto = +this.route.snapshot.paramMap.get('idProyecto');
    this.cargarListaSprints(idProyecto);
  }

  eliminar(sprint: Sprint) {
    this.sprintService.eliminar(sprint.id).subscribe(resp => {
      this.alertaService.success('Ya lo borramos');
      this.cargarListaSprints(sprint.idProyecto);
    });
    return false;
  }

  cargarListaSprints(idProyecto: number) {
    this.cargadorService.mostrar();
    this.listaSprints = this.sprintService.listar(idProyecto);
    this.cargadorService.ocultar();
  }
}

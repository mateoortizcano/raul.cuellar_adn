import { Component, OnInit } from '@angular/core';
import { SprintDetalles } from '@sprint/shared/model/sprint-detalles';
import { AlertaService } from '@core/services/alerta.service';
import { SprintService } from '@sprint/shared/service/sprint.service';
import { CargadorService } from '@core/services/cargador.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-detalle-sprint',
  templateUrl: './detalle-sprint.component.html',
  styleUrls: ['./detalle-sprint.component.sass']
})
export class DetalleSprintComponent implements OnInit {
  sprintDetalle: SprintDetalles;

  constructor(
    private route: ActivatedRoute,
    protected alertaService: AlertaService,
    protected sprintService: SprintService,
    protected cargadorService: CargadorService) { }

  ngOnInit(): void {
    this.cargarDetalles();
  }

  cargarDetalles(){
    const idSprint = +this.route.snapshot.paramMap.get('id');
    const idProyecto = +sessionStorage.getItem('idProyecto');
    this.sprintService.listarDetalles(idProyecto, idSprint).subscribe(resp => {
      this.sprintDetalle = resp;
      this.cargadorService.ocultar();
    });
  }
}

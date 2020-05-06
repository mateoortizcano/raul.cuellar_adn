import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { SprintService } from '@sprint/shared/service/sprint.service';
import { AlertaService } from '@core/services/alerta.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Concepto } from '@sprint/shared/model/concepto';
import { ConceptoService } from '@sprint/shared/service/concepto.service';
import { ComandoSprint } from '@sprint/shared/model/comando-sprint';

@Component({
  selector: 'app-crear-sprint',
  templateUrl: './crear-sprint.component.html',
  styleUrls: ['./crear-sprint.component.sass']
})
export class CrearSprintComponent implements OnInit {
  sprintForm: FormGroup;
  listaConceptos: Concepto[];
  conceptosSeleccionados: Concepto[] = [];
  rolSeleccionado: number;
  idProyecto: number;

  constructor(
    private router: Router,
    protected route: ActivatedRoute,
    protected sprintService: SprintService,
    protected conceptoService: ConceptoService,
    protected alertaService: AlertaService) { }

  ngOnInit(): void {
    this.idProyecto = +sessionStorage.getItem('idProyecto');
    this.conceptoService.listar(this.idProyecto).subscribe(resp => {
      this.listaConceptos = resp;
    });
    this.construirFormularioSprint();
  }

  construirFormularioSprint() {
    this.sprintForm = new FormGroup({
      nombre: new FormControl('', [Validators.required, Validators.minLength(3), Validators.maxLength(20)]),
      fechaInicial: new FormControl('', [Validators.required]),
      fechaFinal: new FormControl('', [Validators.required]),
      numeroPersonas: new FormControl('', [Validators.required]),
    });
  }
  agregarRol() {
    this.rolSeleccionado = +this.rolSeleccionado;
    const filtradas = this.listaConceptos.filter(c => c.id === this.rolSeleccionado);
    if (filtradas.length) {
      const concepto = filtradas.pop();
      if (concepto.tiempoCompleto) {
        concepto.horasSugeridas = this.sprintForm.value.numeroPersonas * 9 * 10;
        concepto.valorSugerido = concepto.horasSugeridas * concepto.tarifa;
      } else {
        concepto.horasSugeridas = 0;
        concepto.valorSugerido = 0;
      }
      this.conceptosSeleccionados.push(concepto);
    }
  }
  removerRol(idConcepto: number) {
    this.conceptosSeleccionados = this.conceptosSeleccionados.filter(c => c.id !== idConcepto);
  }

  crear() {
    if (this.sprintForm.valid) {
      const conceptos = this.conceptosSeleccionados.map(c => c.id);
      const sprint = new ComandoSprint(
        0,
        this.sprintForm.value.nombre,
        this.sprintForm.value.fechaInicial + ' 00:00:00',
        this.sprintForm.value.fechaFinal + ' 23:59:59',
        this.sprintForm.value.numeroPersonas,
        this.idProyecto,
        conceptos
      );
      this.sprintService.crear(sprint).subscribe(resp => {
        if (resp.valor > 0) {
          this.alertaService.success('El sprint se ha creado');
          this.router.navigate(['/sprints']);
        }
      });
    }
  }

}

import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { SprintService } from '@sprint/shared/service/sprint.service';
import { AlertaService } from '@core/services/alerta.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Concepto } from '@sprint/shared/model/concepto';
import { ConceptoService } from '@sprint/shared/service/concepto.service';
import { ComandoSprint } from '@sprint/shared/model/comando-sprint';
import { CalendarioService } from '@sprint/shared/service/calendario.service';
import { ConsultaCalendario } from '@sprint/shared/model/consulta-calendario';
import { CargadorService } from '@core/services/cargador.service';

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
    protected calendarioService: CalendarioService,
    protected cargadorService: CargadorService,
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
      diasHabiles: new FormControl('', [Validators.required]),
      numeroPersonas: new FormControl('', [Validators.required]),
    });
  }
  consultarDiasHabiles() {
    const fechaInicial = this.sprintForm.value.fechaInicial;
    const fechaFinal = this.sprintForm.value.fechaFinal;
    if (fechaInicial.length > 0 && fechaFinal.length > 0) {
      this.cargadorService.mostrar();
      this.calendarioService.consultarDiasHabiles(new ConsultaCalendario(
        fechaInicial + ' 00:00:00',
        fechaFinal + ' 23:59:59'
      )).subscribe(resp => {
        this.sprintForm.controls.diasHabiles.setValue(resp);
        this.cargadorService.ocultar();
      });
    }
  }
  agregarRol() {
    const diasHabiles = this.sprintForm.value.diasHabiles;
    if (diasHabiles > 0 && this.sprintForm.value.numeroPersonas > 0) {
      this.rolSeleccionado = +this.rolSeleccionado;
      const filtradas = this.listaConceptos.filter(c => c.id === this.rolSeleccionado);
      if (filtradas.length) {
        const concepto = filtradas.pop();
        this.listaConceptos = this.listaConceptos.filter(c => c.id !== concepto.id);
        this.calcularValoresPlaneados(concepto);
        this.conceptosSeleccionados.push(concepto);
      }
    }
  }

  calcularValoresPlaneados(concepto: Concepto) {
    const diasHabiles = this.sprintForm.value.diasHabiles;
    if (concepto.tiempoCompleto) {
      concepto.horasSugeridas = this.sprintForm.value.numeroPersonas * 9 * diasHabiles;
      concepto.valorSugerido = concepto.horasSugeridas * concepto.tarifa;
    } else {
      concepto.horasSugeridas = 0;
      concepto.valorSugerido = 0;
    }
  }

  removerRol(idConcepto: number) {
    const filtradas = this.conceptosSeleccionados.filter(c => c.id === idConcepto);
    const concepto = filtradas.pop();
    this.listaConceptos.push(concepto);
    this.conceptosSeleccionados = this.conceptosSeleccionados.filter(c => c.id !== concepto.id);
  }

  actualizarConcepto(event: any, concepto: Concepto) {
    concepto.horasSugeridas = event.target.value;
    concepto.valorSugerido = concepto.horasSugeridas * concepto.tarifa;
  }

  actualizarValoresRoles() {
    this.conceptosSeleccionados.filter(c => c.tiempoCompleto).forEach(c =>
      this.calcularValoresPlaneados(c)
    );
  }
  crear() {
    if (this.sprintForm.valid) {
      const sprint = new ComandoSprint(
        0,
        this.sprintForm.value.nombre,
        this.sprintForm.value.fechaInicial + ' 00:00:00',
        this.sprintForm.value.fechaFinal + ' 23:59:59',
        this.sprintForm.value.numeroPersonas,
        this.idProyecto,
        this.conceptosSeleccionados
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

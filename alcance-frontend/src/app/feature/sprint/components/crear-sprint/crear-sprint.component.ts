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
import { PresupuestoSprint } from '@sprint/shared/model/presupuesto-sprint';

@Component({
  selector: 'app-crear-sprint',
  templateUrl: './crear-sprint.component.html',
  styleUrls: ['./crear-sprint.component.sass']
})
export class CrearSprintComponent implements OnInit {
  sprintForm: FormGroup;
  listaConceptos: Concepto[] = [];
  presupuestoSprintSeleccionados: PresupuestoSprint[] = [];
  rolSeleccionado = -1;
  idProyecto: number;
  diasHabiles: number;

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
    this.construirFormularioSprint();
  }

  construirFormularioSprint() {
    this.sprintForm = new FormGroup({
      nombre: new FormControl('Sprint ', [Validators.required, Validators.minLength(8), Validators.maxLength(20)]),
      fechaInicial: new FormControl('', [Validators.required]),
      fechaFinal: new FormControl('', [Validators.required]),
      numeroPersonas: new FormControl('', [Validators.required]),
    });
  }
  cambioEnCalendario() {
    this.consultarConceptos();
    this.consultarDiasHabiles();
  }
  consultarConceptos() {
    const fechaInicial = new Date(this.sprintForm.value.fechaInicial).getTime() / 1000;
    this.conceptoService.listar(this.idProyecto, fechaInicial).subscribe(resp => {
      this.listaConceptos = resp;
      this.limpiarConceptosSeleccionados();
    });
  }
  limpiarConceptosSeleccionados() {
    this.presupuestoSprintSeleccionados = [];
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
        this.diasHabiles = resp;
        this.cargadorService.ocultar();
      });
    }
  }
  agregarRol() {
    const numeroPersonas = this.sprintForm.value.numeroPersonas;
    if (this.diasHabiles > 0 && numeroPersonas > 0) {
      this.rolSeleccionado = +this.rolSeleccionado;
      const filtradas = this.listaConceptos.filter(c => c.id === this.rolSeleccionado);
      if (filtradas.length) {
        const concepto = filtradas.pop();
        this.listaConceptos = this.listaConceptos.filter(c => c.id !== concepto.id);
        this.presupuestoSprintSeleccionados.push(this.convertirEnPresupuestoSprint(concepto));
      }
    }
    this.rolSeleccionado = -1;
  }
  convertirEnPresupuestoSprint(concepto: Concepto): PresupuestoSprint {
    const presupuestoSprint = new PresupuestoSprint(
      0,
      0,
      concepto.id,
      concepto.nombre,
      concepto.tarifa,
      concepto.tiempoCompleto,
      0,
      0,
      0,
      0,
    );
    const numeroPersonas = this.sprintForm.value.numeroPersonas;
    if (concepto.tiempoCompleto) {
      presupuestoSprint.horasPlaneadas = numeroPersonas * 9 * this.diasHabiles;
      presupuestoSprint.valorPlaneado = presupuestoSprint.horasPlaneadas * concepto.tarifa;
    } else {
      presupuestoSprint.horasPlaneadas = 0;
      presupuestoSprint.valorPlaneado = 0;
    }
    presupuestoSprint.horasEjecutadas = 0;
    presupuestoSprint.valorEjecutado = 0;
    return presupuestoSprint;
  }

  removerRol(idConcepto: number) {
    const filtradas = this.presupuestoSprintSeleccionados.filter(c => c.id === idConcepto);
    const presupuestoSprint = filtradas.pop();
    this.listaConceptos.push(this.convertirEnConcepto(presupuestoSprint));
    this.presupuestoSprintSeleccionados = this.presupuestoSprintSeleccionados.filter(ps => ps.idConcepto !== presupuestoSprint.idConcepto);
    this.rolSeleccionado = -1;
  }

  convertirEnConcepto(presupuestoSprint: PresupuestoSprint): Concepto {
    return new Concepto(
      presupuestoSprint.idConcepto,
      presupuestoSprint.nombreConcepto,
      '',
      presupuestoSprint.tiempoCompletoConcepto,
      presupuestoSprint.tarifaConcepto);
  }

  actualizarConcepto(event: any, presupuestoSprint: PresupuestoSprint) {
    presupuestoSprint.horasPlaneadas = event.target.value;
    presupuestoSprint.valorPlaneado = presupuestoSprint.horasPlaneadas * presupuestoSprint.tarifaConcepto;
  }

  calcularValoresPlaneados(presupuestoSprint: PresupuestoSprint) {
    const numeroPersonas = this.sprintForm.value.numeroPersonas;
    if (presupuestoSprint.tiempoCompletoConcepto) {
      presupuestoSprint.horasPlaneadas = numeroPersonas * 9 * this.diasHabiles;
      presupuestoSprint.valorPlaneado = presupuestoSprint.horasPlaneadas * presupuestoSprint.tarifaConcepto;
    } else {
      presupuestoSprint.horasPlaneadas = 0;
      presupuestoSprint.valorPlaneado = 0;
    }
  }
  actualizarValoresRoles() {
    this.presupuestoSprintSeleccionados.filter(ps => ps.tiempoCompletoConcepto).forEach(ps =>
      this.calcularValoresPlaneados(ps)
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
        this.presupuestoSprintSeleccionados
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

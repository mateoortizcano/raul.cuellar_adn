import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { SprintService } from '@sprint/shared/service/sprint.service';
import { AlertaService } from '@core/services/alerta.service';
import { ActivatedRoute, Router } from '@angular/router';
import { CargadorService } from '@core/services/cargador.service';
import { CalendarioService } from '@sprint/shared/service/calendario.service';
import { ConsultaCalendario } from '@sprint/shared/model/consulta-calendario';
import { ConceptoService } from '@sprint/shared/service/concepto.service';
import { SprintDetalles } from '@sprint/shared/model/sprint-detalles';
import { ComandoSprint } from '@sprint/shared/model/comando-sprint';
import { PresupuestoSprint } from '@sprint/shared/model/presupuesto-sprint';
import { Concepto } from '@sprint/shared/model/concepto';

@Component({
  selector: 'app-actualizar-sprint',
  templateUrl: './actualizar-sprint.component.html',
  styleUrls: ['./actualizar-sprint.component.sass']
})
export class ActualizarSprintComponent implements OnInit {
  sprintForm: FormGroup;
  sprint: SprintDetalles;
  listaConceptos: Concepto[] = [];
  presupuestoSprintSeleccionados: PresupuestoSprint[] = [];
  rolSeleccionado = -1;
  idProyecto: number;
  diasHabiles: number;
  idSprint: number;

  constructor(private route: ActivatedRoute,
              private router: Router,
              protected calendarioService: CalendarioService,
              protected sprintService: SprintService,
              protected conceptoService: ConceptoService,
              protected cargadorService: CargadorService,
              protected alertaService: AlertaService) { }

  ngOnInit(): void {
    this.cargadorService.mostrar();
    this.idProyecto = +sessionStorage.getItem('idProyecto');
    this.idSprint = +this.route.snapshot.paramMap.get('id');

    this.construirFormularioSprint();
    this.sprintService.listarDetalles(this.idProyecto, this.idSprint).subscribe(resp => {
      this.sprint = resp;
      this.diasHabiles = this.sprint.diasHabiles;
      this.presupuestoSprintSeleccionados = this.sprint.presupuestosSprint;
      this.iniciarFormulario();
      this.consultarConceptos();
      this.cargadorService.ocultar();
    });
  }

  private construirFormularioSprint() {
    this.sprintForm = new FormGroup({
      nombre: new FormControl('', [Validators.required, Validators.minLength(3), Validators.maxLength(20)]),
      fechaInicial: new FormControl('', [Validators.required]),
      fechaFinal: new FormControl('', [Validators.required]),
      numeroPersonas: new FormControl('', [Validators.required]),
    });
  }

  private iniciarFormulario() {
    this.sprintForm.get('nombre').setValue(this.sprint.nombre);
    this.sprintForm.get('fechaInicial').setValue(
      new Date(this.sprint.fechaInicial).toISOString().substring(0, 10));
    this.sprintForm.get('fechaFinal').setValue(
      new Date(this.sprint.fechaFinal).toISOString().substring(0, 10));
    this.sprintForm.get('numeroPersonas').setValue(this.sprint.numeroPersonas);
  }

  consultarConceptos() {
    const fechaInicial = new Date(this.sprintForm.value.fechaInicial).getTime() / 1000;
    this.conceptoService.listar(this.idProyecto, fechaInicial).subscribe(resp => {
      this.listaConceptos = resp;
      const idSeleccionado = this.presupuestoSprintSeleccionados.map(c => c.idConcepto);
      this.listaConceptos = this.listaConceptos.filter(c => !idSeleccionado.includes(c.id));
    });
  }

  cambioEnCalendario() {
    this.consultarConceptos();
    this.limpiarConceptosSeleccionados();
    this.consultarDiasHabiles();
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
      this.idSprint,
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
    return presupuestoSprint;
  }

  removerRol(idConcepto: number) {
    const filtradas = this.presupuestoSprintSeleccionados.filter(c => c.idConcepto === idConcepto);
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

  actualizarConceptoPlaneado(event: any, presupuestoSprint: PresupuestoSprint) {
    presupuestoSprint.horasPlaneadas = event.target.value;
    presupuestoSprint.valorPlaneado = presupuestoSprint.horasPlaneadas * presupuestoSprint.tarifaConcepto;
  }

  actualizarConceptoEjecutado(event: any, presupuestoSprint: PresupuestoSprint) {
    presupuestoSprint.horasEjecutadas = event.target.value;
    presupuestoSprint.valorEjecutado = presupuestoSprint.horasEjecutadas * presupuestoSprint.tarifaConcepto;
  }

  actualizarValoresRoles() {
    this.presupuestoSprintSeleccionados.filter(ps => ps.tiempoCompletoConcepto).forEach(ps =>
      this.calcularValoresPlaneados(ps)
    );
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
  public actualizar() {
    if (this.sprintForm.valid) {
      const sprint = new ComandoSprint(
        this.sprint.id,
        this.sprintForm.value.nombre,
        this.sprintForm.value.fechaInicial + ' 00:00:00',
        this.sprintForm.value.fechaFinal + ' 23:59:59',
        this.sprintForm.value.numeroPersonas,
        this.idProyecto,
        this.presupuestoSprintSeleccionados
      );
      this.sprintService.actualizar(sprint).subscribe(resp => {
        this.alertaService.success('Se ha actualizado el sprint correctamente');
        this.router.navigate(['/sprints']);
      });
    }
  }
}

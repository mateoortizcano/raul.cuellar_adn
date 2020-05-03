import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, FormArray } from '@angular/forms';
import { SprintService } from '@sprint/shared/service/sprint.service';
import { Sprint } from '@sprint/shared/model/sprint';
import { AlertaService } from '@core/services/alerta.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Concepto } from '@sprint/shared/model/concepto';
import { ConceptoService } from '@sprint/shared/service/concepto.service';

@Component({
  selector: 'app-crear-sprint',
  templateUrl: './crear-sprint.component.html',
  styleUrls: ['./crear-sprint.component.sass']
})
export class CrearSprintComponent implements OnInit {
  sprintForm: FormGroup;
  listaConceptos: Concepto[];
  conceptosSeleccionados: number[];

  constructor(
    private router: Router,
    protected route: ActivatedRoute,
    protected sprintService: SprintService,
    protected conceptoService: ConceptoService,
    protected alertaService: AlertaService) { }

  ngOnInit(): void {
    this.conceptoService.listar().subscribe(resp => {
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
      conceptos: new FormControl('', [Validators.required])
    });
  }
  updConceptoSeleccionado(id: number) {
    this.conceptosSeleccionados.push(id);
    this.conceptosSeleccionados.filter(idConcepto => {
      return idConcepto !== id;
    });
  }

  crear() {
    const idProyecto = +sessionStorage.getItem('idProyecto');
    if (this.sprintForm.valid) {
      const sprint = new Sprint(
        0,
        this.sprintForm.value.nombre,
        this.sprintForm.value.fechaInicial + ' 00:00:00',
        this.sprintForm.value.fechaFinal + ' 23:59:59',
        0,
        this.sprintForm.value.numeroPersonas,
        idProyecto
      );
      // const selectedConceptos = this.sprintForm.value.conceptos
      // .map((checked, index) => checked ? this.listaConceptos[index].id : null)
      // .filter(value => value !== null);
      // this.sprintService.crear(sprint).subscribe(resp => {
      //   if (resp.valor > 0) {
      //     this.alertaService.success('El sprint se ha creado');
      //     this.router.navigate(['/sprints']);
      //   }
      // });
    }
  }

}

import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { SprintService } from '@sprint/shared/service/sprint.service';
import { Sprint } from '@sprint/shared/model/sprint';
import { AlertaService } from '@core/services/alerta.service';

@Component({
  selector: 'app-actualizar-sprint',
  templateUrl: './actualizar-sprint.component.html',
  styleUrls: ['./actualizar-sprint.component.sass']
})
export class ActualizarSprintComponent implements OnInit {
  sprintForm: FormGroup;
  sprint: Sprint;
  mostrarExito: boolean;

  constructor(protected sprintServices: SprintService) { }

  ngOnInit(): void {
    this.construirFormularioSprint();
    this.sprintServices.consultar(1).subscribe(resp => {
      this.sprint = resp;
      this.iniciarFormulario();
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
  private iniciarFormulario(){
    this.sprintForm.get('nombre').setValue(this.sprint.nombre);
    this.sprintForm.get('fechaInicial').setValue(
      new Date(this.sprint.fechaInicial).toISOString().substring(0,10));
    this.sprintForm.get('fechaFinal').setValue(
      new Date(this.sprint.fechaFinal).toISOString().substring(0,10));
    this.sprintForm.get('numeroPersonas').setValue(this.sprint.numeroPersonas);
  }

  public actualizar(){
    if(this.sprintForm.valid){
      this.sprint.nombre = this.sprintForm.value.nombre;
      this.sprint.fechaInicial = this.sprintForm.value.fechaInicial + ' 00:00:00';
      this.sprint.fechaFinal = this.sprintForm.value.fechaFinal + ' 23:59:59';
      this.sprint.numeroPersonas = this.sprintForm.value.numeroPersonas;
      this.sprintServices.actualizar(this.sprint);
    }
  }
}

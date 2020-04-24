import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Sprint } from '@sprint/shared/model/sprint';
import { SprintService } from '@sprint/shared/service/sprint.service';

@Component({
  selector: 'app-actualizar-sprint',
  templateUrl: './actualizar-sprint.component.html',
  styleUrls: ['./actualizar-sprint.component.sass']
})
export class ActualizarSprintComponent implements OnInit {
  sprintForm: FormGroup;
  sprint: Sprint;

  constructor(protected sprintService: SprintService) { }

  ngOnInit(): void {
    this.construirFormularioSprint();
    this.sprintService.consultar(1).subscribe(resp => {
      this.sprint = resp;
      this.iniciarFormulario();
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

  private construirFormularioSprint() {
    this.sprintForm = new FormGroup({
      nombre: new FormControl('', [Validators.required, Validators.minLength(3), Validators.maxLength(20)]),
      fechaInicial: new FormControl('', [Validators.required]),
      fechaFinal: new FormControl('', [Validators.required]),
      numeroPersonas: new FormControl('', [Validators.required]),
    });
  }
  public actualizar(){
    if(this.sprintForm.valid){
      this.sprint.nombre = this.sprintForm.value.nombre;
      this.sprint.fechaInicial = this.sprintForm.value.fechaInicial + ' 00:00:00';
      this.sprint.fechaFinal = this.sprintForm.value.fechaFinal + ' 23:59:59';
      this.sprint.numeroPersonas = this.sprintForm.value.numeroPersonas;
      this.sprintService.actualizar(this.sprint);
    }
  }
}

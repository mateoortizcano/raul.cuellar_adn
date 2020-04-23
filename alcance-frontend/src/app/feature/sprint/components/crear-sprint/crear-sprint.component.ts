import { Component, OnInit } from '@angular/core';
import { SprintService } from '../../shared/service/sprint.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Sprint } from '@sprint/shared/model/sprint';

@Component({
  selector: 'app-crear-sprint',
  templateUrl: './crear-sprint.component.html',
  styleUrls: ['./crear-sprint.component.sass']
})
export class CrearSprintComponent implements OnInit {
  sprintForm: FormGroup;
  mostrarExito: boolean;

  constructor(protected sprintServices: SprintService) {
  }

  ngOnInit() {
    this.construirFormularioSprint();
  }

  crear() {
    if(this.sprintForm.valid){
      let sprint = new Sprint(
        0,
        this.sprintForm.value.nombre,
        this.sprintForm.value.fechaInicial + ' 00:00:00',
        this.sprintForm.value.fechaFinal + ' 23:59:59',
        0,
        this.sprintForm.value.numeroPersonas,
        1
      );
      this.sprintServices.guardar(sprint).subscribe(resp => {
        if(resp.valor > 0){
          this.mostrarExito = true;
        }
      });
    }
  }

  private construirFormularioSprint() {
    this.sprintForm = new FormGroup({
      nombre: new FormControl('', [Validators.required, Validators.minLength(3), Validators.maxLength(20)]),
      fechaInicial: new FormControl('', [Validators.required]),
      fechaFinal: new FormControl('', [Validators.required]),
      numeroPersonas: new FormControl('', [Validators.required]),
    });
  }
}

import { Component, OnInit } from '@angular/core';
import { SprintService } from '../../shared/service/sprint.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-crear-sprint',
  templateUrl: './crear-sprint.component.html',
  styleUrls: ['./crear-sprint.component.sass']
})
export class CrearSprintComponent implements OnInit {
  sprintForm: FormGroup;
  mostrarExito: boolean;
  constructor(protected sprintServices: SprintService) { }

  ngOnInit() {
    this.construirFormularioSprint();
  }

  crear() {
    this.sprintServices.guardar(this.sprintForm.value).subscribe(resp => {
      if(resp.valor > 0){
        this.mostrarExito = true;
      }
    });
  }

  private construirFormularioSprint() {
    this.sprintForm = new FormGroup({
      nombre: new FormControl('', [Validators.required, Validators.minLength(3), Validators.maxLength(20)]),
      fechaInicial: new FormControl('', [Validators.required, Validators.minLength(3), Validators.maxLength(20)]),
      fechaFinal: new FormControl('', [Validators.required, Validators.minLength(3), Validators.maxLength(20)]),
      numeroPersonas: new FormControl('', [Validators.required]),
      idProyecto: new FormControl('', [Validators.required]),
      diasHabiles: new FormControl('', [Validators.required])
    });
  }

}

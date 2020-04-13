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
      nombre: new FormControl('Sprint 90', [Validators.required, Validators.minLength(3), Validators.maxLength(20)]),
      fechaInicial: new FormControl('2021-05-02 00:00:00', [Validators.required, Validators.minLength(3), Validators.maxLength(20)]),
      fechaFinal: new FormControl('2021-05-20 23:59:59', [Validators.required, Validators.minLength(3), Validators.maxLength(20)]),
      numeroPersonas: new FormControl('3', [Validators.required]),
      idProyecto: new FormControl('1', [Validators.required]),
      diasHabiles: new FormControl('99', [Validators.required])
    });
  }

}

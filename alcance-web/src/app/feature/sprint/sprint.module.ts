import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SprintRoutingModule } from './sprint-routing.module';
import { SprintComponent } from './components/sprint/sprint.component';
import { ListarSprintsComponent } from './components/listar-sprints/listar-sprints.component';
import { CrearSprintComponent } from './components/crear-sprint/crear-sprint.component';
import { ActualizarSprintComponent } from './components/actualizar-sprint/actualizar-sprint.component';
import { SharedModule } from '@shared/shared.module';


@NgModule({
  declarations: [SprintComponent, ListarSprintsComponent, CrearSprintComponent, ActualizarSprintComponent],
  imports: [
    SharedModule,
    SprintRoutingModule
  ]
})
export class SprintModule { }

import { NgModule } from '@angular/core';

import { SprintRoutingModule } from './sprint-routing.module';
import { SharedModule } from '@shared/shared.module';
import { SprintComponent } from './components/sprint/sprint.component';
import { ListarSprintComponent } from './components/listar-sprint/listar-sprint.component';
import { CrearSprintComponent } from './components/crear-sprint/crear-sprint.component';
import { ActualizarSprintComponent } from './components/actualizar-sprint/actualizar-sprint.component';


@NgModule({
  declarations: [
    SprintComponent,
    ListarSprintComponent,
    CrearSprintComponent,
    ActualizarSprintComponent
  ],
  imports: [
    SprintRoutingModule,
    SharedModule
  ]
})
export class SprintModule { }

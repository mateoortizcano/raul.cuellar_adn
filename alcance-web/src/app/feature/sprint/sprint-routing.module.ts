import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SprintComponent } from './components/sprint/sprint.component';
import { ListarSprintsComponent } from './components/listar-sprints/listar-sprints.component';
import { CrearSprintComponent } from './components/crear-sprint/crear-sprint.component';
import { ActualizarSprintComponent } from './components/actualizar-sprint/actualizar-sprint.component';


const routes: Routes = [
  {
    path: '',
    component: SprintComponent,
    children: [
      {
        path: '',
        component: ListarSprintsComponent
      },
      {
        path: 'crear',
        component: CrearSprintComponent
      },
      {
        path: 'actualizar',
        component: ActualizarSprintComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SprintRoutingModule { }

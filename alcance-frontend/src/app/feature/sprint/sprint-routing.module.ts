import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SprintComponent } from './components/sprint/sprint.component';
import { ListarSprintsComponent } from './components/listar-sprints/listar-sprints.component';
import { CrearSprintComponent } from './components/crear-sprint/crear-sprint.component';
import { ActualizarSprintComponent } from './components/actualizar-sprint/actualizar-sprint.component';
import { DetalleSprintComponent } from './components/detalle-sprint/detalle-sprint.component';


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
        path: 'actualizar/:id',
        component: ActualizarSprintComponent
      },
      {
        path: 'detalles/:id',
        component: DetalleSprintComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SprintRoutingModule { }

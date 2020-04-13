import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListarSprintComponent } from './components/listar-sprint/listar-sprint.component';
import { SprintComponent } from './components/sprint/sprint.component';
import { CrearSprintComponent } from './components/crear-sprint/crear-sprint.component';


const routes: Routes = [
  {
    path: '',
    component: SprintComponent,
    children: [
      {
        path: '',
        component: ListarSprintComponent
      },
      {
        path: 'crear',
        component: CrearSprintComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SprintRoutingModule { }

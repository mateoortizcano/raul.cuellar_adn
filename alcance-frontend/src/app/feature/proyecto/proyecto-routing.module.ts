import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListarProyectosComponent } from './components/listar-proyectos/listar-proyectos.component';


const routes: Routes = [
  {
    path: '',
    component: ListarProyectosComponent
  },
  {
    path: ':idProyecto', loadChildren: () => import('@sprint/sprint.module').then(mod => mod.SprintModule) }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProyectoRoutingModule { }

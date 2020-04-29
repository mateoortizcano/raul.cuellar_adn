import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListarProyectosComponent } from './components/listar-proyectos/listar-proyectos.component';


const routes: Routes = [
  {
    path: '',
    component: ListarProyectosComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProyectoRoutingModule { }

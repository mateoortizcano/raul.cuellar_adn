import { NgModule } from '@angular/core';

import { ProyectoRoutingModule } from './proyecto-routing.module';
import { SharedModule } from '@shared/shared.module';
import { ListarProyectosComponent } from './components/listar-proyectos/listar-proyectos.component';


@NgModule({
  declarations: [ListarProyectosComponent],
  imports: [
    SharedModule,
    ProyectoRoutingModule
  ]
})
export class ProyectoModule { }

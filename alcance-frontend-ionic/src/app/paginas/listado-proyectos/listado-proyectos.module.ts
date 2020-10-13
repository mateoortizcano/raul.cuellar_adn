import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { ListadoProyectosPageRoutingModule } from './listado-proyectos-routing.module';

import { ListadoProyectosPage } from './listado-proyectos.page';
import { InicialesPalabrasPipe } from '../../pipes/iniciales-palabras.pipe';
import { PipesModule } from '../../pipes/pipes.module';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ListadoProyectosPageRoutingModule,
    PipesModule
  ],
  declarations: [ListadoProyectosPage]
})
export class ListadoProyectosPageModule { }

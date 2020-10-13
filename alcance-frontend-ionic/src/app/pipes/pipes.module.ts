import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { InicialesPalabrasPipe } from './iniciales-palabras.pipe';



@NgModule({
  declarations: [InicialesPalabrasPipe],
  imports: [
    CommonModule
  ],
  exports: [InicialesPalabrasPipe]
})
export class PipesModule { }

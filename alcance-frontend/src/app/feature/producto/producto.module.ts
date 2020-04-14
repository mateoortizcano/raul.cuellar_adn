import { NgModule } from '@angular/core';

import { BorrarProductoComponent } from './components/borrar-producto/borrar-producto.component';
import { ProductoComponent } from './components/producto/producto.component';
import { SharedModule } from '@shared/shared.module';


@NgModule({
  declarations: [
    BorrarProductoComponent,
    ProductoComponent
  ],
  imports: [
    SharedModule
  ]
})
export class ProductoModule { }

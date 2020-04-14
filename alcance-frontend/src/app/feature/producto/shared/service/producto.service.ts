import { Injectable } from '@angular/core';
import { HttpService } from '@core-service/http.service';
import { environment } from 'src/environments/environment';
import { Producto } from '../model/producto';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  constructor(protected http: HttpService) {}

  public eliminar(producto: Producto) {
    return this.http.doDelte<Producto, boolean>(`${environment.endpoint}/productos/${producto.id}`,
                                                 this.http.optsName('eliminar productos'));
  }
}

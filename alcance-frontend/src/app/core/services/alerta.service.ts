import { Injectable } from '@angular/core';
import { Alerta } from '@core/modelo/alerta';

@Injectable({
  providedIn: 'root'
})
export class AlertaService {

  private alerta: Alerta;

  constructor() { }

  success(mensaje: string){
    this.alert(mensaje);
  }

  private alert(mensaje: string){
    this.alerta = new Alerta();
    this.alerta.mensaje = mensaje;
    this.dispararAlerta();
  }

  private dispararAlerta() {
    const e = new CustomEvent('ALERTA', {
      detail: this.alerta,
      cancelable: true,
      bubbles: true
      });
    window.dispatchEvent(e);
  }
}

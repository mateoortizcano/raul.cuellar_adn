import { Injectable } from '@angular/core';
import { Alerta, AlertaTipo } from '@core/modelo/alerta';

@Injectable({
  providedIn: 'root'
})
export class AlertaService {

  private alerta: Alerta;

  constructor() { }

  success(mensaje: string) {
    this.alert(mensaje, AlertaTipo.Success);
  }

  error(mensaje: string) {
    this.alert(mensaje, AlertaTipo.Danger);
  }

  private alert(mensaje: string, tipo: string) {
    this.alerta = new Alerta();
    this.alerta.mensaje = mensaje;
    this.alerta.tipo = tipo;
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

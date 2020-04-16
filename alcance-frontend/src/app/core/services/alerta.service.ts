import { Injectable } from '@angular/core';
import { Alerta, AlertaTipo } from '@core/modelo/alerta.model';

@Injectable()
export class AlertaService {

  private TIMEOUT = 10;
  alerta: Alerta;

  constructor() {
  }

  alert(type: string, texto: string) {
    this.alerta = new Alerta();
    this.alerta.texto = texto;
    this.alerta.type = type;
    this.alerta.timeout = this.TIMEOUT;
    this.alerta.fixed = false;
    this.dispararAlerta();
  }

  actualizar(alerta: Alerta[]) {
    if (!alerta || alerta.length === 0) {
      this.clear();
      return;
    }
  }

  clear() {
    this.alerta = null;
    this.dispararAlerta();
  }

  success(texto: string) {
    this.alert(AlertaTipo.Success, texto);
  }

  error(texto: string) {
    this.alert(AlertaTipo.Danger, texto);
  }

  info(texto: string) {
    this.alert(AlertaTipo.Info, texto);
  }

  warn(texto: string) {
    this.alert(AlertaTipo.Warning, texto);
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

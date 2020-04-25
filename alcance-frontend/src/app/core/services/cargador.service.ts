import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CargadorService {

  private mostrando: boolean;

  constructor() { }

  mostrar() {
    this.mostrando = true;
    this.disparar();
  }

  ocultar() {
    this.mostrando = false;
    this.disparar();
  }

  private disparar() {
    const e = new CustomEvent('CARGADOR', {
      detail: this.mostrando,
      cancelable: true,
      bubbles: true
      });
    window.dispatchEvent(e);
  }
}

export class Concepto {
  id: number;
  nombre: string;
  gerencia: string;
  tiempoCompleto: boolean;
  tarifa: number;

  constructor(id: number, nombre: string, gerencia: string, tiempoCompleto: boolean, tarifa: number) {
    this.id = id;
    this.nombre = nombre;
    this.gerencia = gerencia;
    this.tiempoCompleto = tiempoCompleto;
    this.tarifa = tarifa;
  }
}

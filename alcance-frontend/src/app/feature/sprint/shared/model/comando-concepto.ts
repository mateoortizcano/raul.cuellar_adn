export class ComandoConcepto {
  idConcepto: number;
  idPresupuestoSprint: number;
  nombre: string;
  gerencia: string;
  tiempoCompleto: boolean;
  tarifa: number;
  horasPlaneadas: number;
  valorPlaneado: number;
  horasEjecutadas: number;
  valorEjecutado: number;

  constructor(idConcepto: number, idPresupuestoSprint: number, nombre: string, gerencia: string, tiempoCompleto: boolean, tarifa: number,
              horasPlaneadas: number, valorPlaneado: number, horasEjecutadas: number, valorEjecutado: number) {
    this.idConcepto = idConcepto;
    this.idPresupuestoSprint = idPresupuestoSprint;
    this.nombre = nombre;
    this.gerencia = gerencia;
    this.tiempoCompleto = tiempoCompleto;
    this.tarifa = tarifa;
    this.horasPlaneadas = horasPlaneadas;
    this.valorPlaneado = valorPlaneado;
    this.horasEjecutadas = horasEjecutadas;
    this.valorEjecutado = valorEjecutado;
  }
}

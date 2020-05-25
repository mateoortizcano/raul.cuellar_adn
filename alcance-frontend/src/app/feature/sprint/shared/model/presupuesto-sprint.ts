export class PresupuestoSprint {
  id: number;
  idSprint: number;
  idConcepto: number;
  nombreConcepto: string;
  tarifaConcepto: number;
  tiempoCompletoConcepto: boolean;
  horasPlaneadas: number;
  horasEjecutadas: number;
  valorPlaneado: number;
  valorEjecutado: number;

  constructor(
    id: number,
    idSprint: number,
    idConcepto: number,
    nombreConcepto: string,
    tarifaConcepto: number,
    tiempoCompletoConcepto: boolean,
    horasPlaneadas: number,
    horasEjecutadas: number,
    valorPlaneado: number,
    valorEjecutado: number
  ) {
    this.id = id;
    this.idSprint = idSprint;
    this.idConcepto = idConcepto;
    this.nombreConcepto = nombreConcepto;
    this.horasPlaneadas = horasPlaneadas;
    this.horasEjecutadas = horasEjecutadas;
    this.valorPlaneado = valorPlaneado;
    this.valorEjecutado = valorEjecutado;
    this.tarifaConcepto = tarifaConcepto;
    this.tiempoCompletoConcepto = tiempoCompletoConcepto;
  }
}

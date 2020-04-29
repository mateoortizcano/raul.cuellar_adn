export class PresupuestoSprint {
  id: number;
  idSprint: number;
  idConcepto: number;
  horasPlaneadas: number;
  horasEjecutadas: number;
  valorPlaneado: number;
  valorEjecutado: number;

  constructor(id: number, idSprint: number, idConcepto: number,
              horasPlaneadas: number, horasEjecutadas: number,
              valorPlaneado: number, valorEjecutado: number ) {
      this.id = id;
      this.idSprint = idSprint;
      this.idConcepto = idConcepto;
      this.horasPlaneadas = horasPlaneadas;
      this.horasEjecutadas = horasEjecutadas;
      this.valorPlaneado = valorPlaneado;
      this.valorEjecutado = valorEjecutado;
    }
}

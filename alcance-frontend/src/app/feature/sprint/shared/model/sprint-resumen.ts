export class SprintResumen {
  id: number;
  nombre: string;
  fechaInicial: string;
  fechaFinal: string;
  diasHabiles: number;
  numeroPersonas: number;
  idProyecto: number;
  valorPlaneado: number;
  valorEjecutado: number;
  desviacion: number;

  constructor(id: number, nombre: string, fechaInicial: string, fechaFinal: string,
              diasHabiles: number, numeroPersonas: number, idProyecto: number,
              valorPlaneado: number, valorEjecutado: number, desviacion: number) {
      this.id = id;
      this.nombre = nombre;
      this.fechaInicial = fechaInicial;
      this.fechaFinal = fechaFinal;
      this.diasHabiles = diasHabiles;
      this.numeroPersonas = numeroPersonas;
      this.idProyecto = idProyecto;
      this.valorPlaneado = valorPlaneado;
      this.valorEjecutado = valorEjecutado;
      this.desviacion = this.desviacion;
  }
}

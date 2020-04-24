export class Sprint {
  id: number;
  nombre: string;
  fechaInicial: string;
  fechaFinal: string;
  diasHabiles: number;
  numeroPersonas: number;
  idProyecto: number;


  constructor(id: number, nombre: string, fechaInicial: string, fechaFinal: string,
    diasHabiles: number, numeroPersonas: number, idProyecto: number) {
      this.id = id;
      this.nombre = nombre;
      this.fechaInicial = fechaInicial;
      this.fechaFinal = fechaFinal;
      this.diasHabiles = diasHabiles;
      this.numeroPersonas = numeroPersonas;
      this.idProyecto = idProyecto;
  }
}

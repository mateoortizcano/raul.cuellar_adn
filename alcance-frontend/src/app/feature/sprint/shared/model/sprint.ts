export class Sprint {
  nombre: string;
  fechaInicial: string;
  fechaFinal: string;
  diasHabiles: number;
  numeroPersonas: number;
  idProyecto: number;


  constructor(nombre: string, fechaInicial: string, fechaFinal: string,
    diasHabiles: number, numeroPersonas: number, idProyecto: number) {
    this.nombre = nombre;
    this.fechaInicial = fechaInicial;
    this.fechaFinal = fechaFinal;
    this.diasHabiles = diasHabiles;
    this.numeroPersonas = numeroPersonas;
    this.idProyecto = idProyecto;
  }
}

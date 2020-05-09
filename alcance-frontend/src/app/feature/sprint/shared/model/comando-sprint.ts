import { Concepto } from './concepto';

export class ComandoSprint {
  id: number;
  nombre: string;
  fechaInicial: string;
  fechaFinal: string;
  numeroPersonas: number;
  idProyecto: number;
  conceptos: any[];

  constructor(id: number, nombre: string, fechaInicial: string, fechaFinal: string, numeroPersonas: number,
              idProyecto: number, conceptos: any[]) {
      this.id = id;
      this.nombre = nombre;
      this.fechaInicial = fechaInicial;
      this.fechaFinal = fechaFinal;
      this.numeroPersonas = numeroPersonas;
      this.idProyecto = idProyecto;
      this.conceptos = conceptos;
  }
}

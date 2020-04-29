import { PresupuestoSprint } from './presupuesto-sprint';

export class SprintResumen {
  id: number;
  nombre: string;
  fechaInicial: string;
  fechaFinal: string;
  diasHabiles: number;
  numeroPersonas: number;
  idProyecto: number;
  presupuestosSprint: PresupuestoSprint[];

  constructor(id: number, nombre: string, fechaInicial: string, fechaFinal: string,
              diasHabiles: number, numeroPersonas: number, idProyecto: number,
              presupuestosSprint: PresupuestoSprint[]) {
      this.id = id;
      this.nombre = nombre;
      this.fechaInicial = fechaInicial;
      this.fechaFinal = fechaFinal;
      this.diasHabiles = diasHabiles;
      this.numeroPersonas = numeroPersonas;
      this.idProyecto = idProyecto;
      this.presupuestosSprint = presupuestosSprint;
  }
}

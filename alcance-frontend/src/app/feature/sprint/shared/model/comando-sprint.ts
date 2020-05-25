import { PresupuestoSprint } from './presupuesto-sprint';

export class ComandoSprint {
  id: number;
  nombre: string;
  fechaInicial: string;
  fechaFinal: string;
  numeroPersonas: number;
  idProyecto: number;
  presupuestoSprint: PresupuestoSprint[];

  constructor(id: number, nombre: string, fechaInicial: string, fechaFinal: string, numeroPersonas: number,
              idProyecto: number, presupuestoSprint: PresupuestoSprint[]) {
      this.id = id;
      this.nombre = nombre;
      this.fechaInicial = fechaInicial;
      this.fechaFinal = fechaFinal;
      this.numeroPersonas = numeroPersonas;
      this.idProyecto = idProyecto;
      this.presupuestoSprint = presupuestoSprint;
  }
}

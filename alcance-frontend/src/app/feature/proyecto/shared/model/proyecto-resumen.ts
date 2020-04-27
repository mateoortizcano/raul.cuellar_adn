export class ProyectoResumen {
  id: number;
  nombre: string;
  cliente: string;
  presupuestoGlobal: number;
  presupuestoConsumido: number;

  constructor(id: number, nombre: string, cliente: string, presupuestoGlobal: number, presupuestoConsumido: number) {
    this.id = id;
    this.nombre = nombre;
    this.cliente = cliente;
    this.presupuestoGlobal = presupuestoGlobal;
    this.presupuestoConsumido = presupuestoConsumido;
  }
}

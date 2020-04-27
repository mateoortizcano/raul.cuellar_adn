export class Proyecto {
  private id: number;
  private nombre: string;
  private cliente: string;

  constructor(id: number, nombre: string, cliente: string) {
    this.id = id;
    this.nombre = nombre;
    this.cliente = cliente;
  }
}

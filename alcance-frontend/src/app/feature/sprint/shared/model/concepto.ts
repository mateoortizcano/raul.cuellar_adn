export class Concepto{
  id: number;
  nombre: string;
  gerencia: string;

  constructor(id: number, nombre: string, gerencia: string){
    this.id = id;
    this.nombre = nombre;
    this.gerencia = gerencia;
  }
}

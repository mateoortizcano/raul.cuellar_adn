export class Alerta {
  mensaje: string;
  tipo: string;
}

export enum AlertaTipo {
  Success = 'success',
  Info = 'info',
  Warning = 'warning',
  Danger = 'danger'
}

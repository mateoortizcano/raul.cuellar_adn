export class Alerta {
    type: string;
    texto: string;
    timeout: number;
    fixed: boolean;
}

export enum AlertaTipo {
    Success = 'success',
    Info = 'info',
    Warning = 'warning',
    Danger = 'danger'
}

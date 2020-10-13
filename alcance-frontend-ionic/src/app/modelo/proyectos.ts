export interface Proyecto {
    id: number;
    nombre: string;
    cliente: string;
    presupuestoGlobal: number;
    presupuestoConsumido: number;
    releases: Release[];
}

export interface Release {
    id: number;
    nombre: string;
}
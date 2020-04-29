create table concepto (
    id int(11) not null auto_increment,
    nombre varchar(100) not null,
    gerencia varchar(20) not null,
    primary key(id)
);

create table tarifa (
    id int(11) not null auto_increment,
    vigencia_inicial datetime not null,
    vigencia_final datetime not null,
    valor double not null,
    moneda varchar(3) not null,
    id_concepto int(11) not null,
    id_proyecto int(11) not null,
    primary key(id)
);

create table presupuesto_sprint(
    id int(11) not null auto_increment,
    id_sprint int(11) not null,
    id_concepto int(11) not null,
    horas_planeadas double not null,
    horas_ejecutadas double not null,
    valor_planeado double not null,
    valor_ejecutado double not null,
    primary key(id)
);
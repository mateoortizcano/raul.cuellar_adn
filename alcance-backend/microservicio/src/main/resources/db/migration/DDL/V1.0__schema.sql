create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table epica (
    id int(11) not null auto_increment,
    titulo varchar(100) not null,
    estimacion_comercial int(11) not null,
    primary key(id)
);

create table presupuesto (
    id int(11) not null auto_increment,
    valor Double not null,
    reserva_estabilizacion Double,
    observaciones varchar(255),
    id_proyecto int(11) not null,
    primary key(id)
);

create table proyecto (
    id int(11) not null auto_increment,
    nombre varchar(100) not null,
    primary key(id)
);

create table sprint (
    id int(11) not null auto_increment,
    nombre varchar(50) not null,
    fecha_inicial datetime not null,
    fecha_final datetime not null,
    dias_habiles int(11) not null,
    numero_personas int(11) null default 0,
    id_proyecto int(11) not null,
    primary key(id)
)
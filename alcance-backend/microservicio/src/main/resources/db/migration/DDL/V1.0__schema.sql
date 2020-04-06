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
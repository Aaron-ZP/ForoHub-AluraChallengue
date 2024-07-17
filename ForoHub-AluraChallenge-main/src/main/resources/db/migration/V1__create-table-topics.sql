create table topicos(

    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensaje varchar(300) not null,
    fechaCreacion varchar(50) not null,
    usuario varchar(100) not null,
    curso varchar(100) not null,
    activo bigint not null

    primary key(id)
);
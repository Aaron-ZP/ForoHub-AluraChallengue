create table usuarios(
    id bigint not null auto_increment,
    nombre varchar(200) not null,
    correo varchar(100) not null,
    contrasena varchar(300) not null,
    id_perfil bigint not null,
    primary key(id)
);
package com.alurachallenge.forohub.domain.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private String fechaCreacion;
    private Boolean activo;
    private String usuario;
    private String curso;

    public Topico(DatosRegistroTopico datosRegistroTopico){
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.fechaCreacion = datosRegistroTopico.fechaCreacion();
        this.activo = true;
        this.usuario = datosRegistroTopico.usuario();
        this.curso = datosRegistroTopico.curso();
    }

    public void actualizarTopicos(DatosActualizarTopico datosActualizarTopico){
        if (datosActualizarTopico.titulo() != null ){
            this.titulo = datosActualizarTopico.titulo();
        }
        if (datosActualizarTopico.mensaje() != null ){
            this.mensaje = datosActualizarTopico.mensaje();
        }
        if (datosActualizarTopico.curso() != null ){
            this.curso = datosActualizarTopico.curso();
        }
        if (datosActualizarTopico.usuario() != null ){
            this.usuario = datosActualizarTopico.usuario();
        }

    }
    public void desactivarTopico() {
        this.activo = false;
    }

}

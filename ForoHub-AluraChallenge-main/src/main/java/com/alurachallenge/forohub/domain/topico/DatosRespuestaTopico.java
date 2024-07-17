package com.alurachallenge.forohub.domain.topico;

public record DatosRespuestaTopico(

        Long id,

        String titulo,

        String mensaje,

        String fechaCreacion,

        Boolean activo,

        String usuario,

        String curso

) {
}

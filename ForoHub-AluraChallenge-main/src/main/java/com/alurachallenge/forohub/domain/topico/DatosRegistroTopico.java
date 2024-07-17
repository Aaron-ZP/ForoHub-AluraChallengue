package com.alurachallenge.forohub.domain.topico;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroTopico(

        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotBlank
        String fechaCreacion,

        Boolean activo,
        @NotBlank
        String usuario,
        @NotBlank
        String curso
) {


}

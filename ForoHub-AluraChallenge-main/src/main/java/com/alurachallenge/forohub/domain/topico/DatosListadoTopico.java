package com.alurachallenge.forohub.domain.topico;

public record DatosListadoTopico(
        Long id,
        String titulo,
        String mensaje,
        String fechaCreacion,
        Boolean activo,

        String usuario,
        String curso
) {
    public DatosListadoTopico(Topico topico){
        this(topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getActivo(),
                topico.getUsuario(),
                topico.getCurso());
    }


}

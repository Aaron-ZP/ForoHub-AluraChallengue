package com.alurachallenge.forohub.security;

public record DatosJWTToken(
        org.springframework.security.core.token.Token jwTtoken
) {
}

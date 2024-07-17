package com.alurachallenge.forohub.controller;

import com.alurachallenge.forohub.domain.usuario.DatosAutenticacionUsuario;
import com.alurachallenge.forohub.domain.usuario.Usuario;
import com.alurachallenge.forohub.security.DatosJWTToken;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.token.TokenService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosAutenticacionUsuario datosAutenticacionUsuario){
        Authentication authToken = new UsernamePasswordAuthenticationToken(
                datosAutenticacionUsuario.correo(),
                datosAutenticacionUsuario.contrasena());
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.verifyToken(String.valueOf((Usuario) usuarioAutenticado.getPrincipal()));
        return ResponseEntity.ok(new DatosJWTToken(JWTtoken));
    }
}

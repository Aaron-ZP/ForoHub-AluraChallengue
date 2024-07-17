package com.alurachallenge.forohub.security;

import com.alurachallenge.forohub.domain.usuario.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component //al no ser esta clase un servicio, ponemos esto.
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepositorio;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //Obtener el autHeader del header
        System.out.println("Inicio del filter");
        var autHeader = request.getHeader("Authorization");//.replace("Bearer", "");
        if (autHeader != null){
            System.out.println("Validando autHeader no null");
            var token = autHeader.replace("Bearer ", "");
            var nombreUsuario = tokenService.getSubject(token); //Extraccion de UserName
            if (nombreUsuario != null){
                // Token valido
                var usuario = usuarioRepositorio.findByCorreo(nombreUsuario);
                var authenticaton = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities()); // Inicio de sesion forzado
                SecurityContextHolder.getContext().setAuthentication(authenticaton);
            }
        }
        filterChain.doFilter(request, response);
    }
}


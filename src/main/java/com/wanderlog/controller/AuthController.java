package com.wanderlog.controller;

import com.wanderlog.model.Usuario;
import com.wanderlog.model.enums.Rol;
import com.wanderlog.repository.UsuarioRepository;
import com.wanderlog.security.JwtUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@Tag(name = "Autenticación", description = "Registro y login de usuarios")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/registro")
    @Operation(summary = "Registrar un nuevo usuario")
    public Map<String, String> registro(@RequestBody Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuario.setRol(Rol.VIAJERO);
        usuarioRepository.save(usuario);
        return Map.of("mensaje", "Usuario registrado correctamente");
    }

    @PostMapping("/login")
    @Operation(summary = "Login — devuelve el token JWT")
    public Map<String, String> login(@RequestBody Usuario usuario) {
        Usuario existente = usuarioRepository.findByEmail(usuario.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!passwordEncoder.matches(usuario.getPassword(), existente.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        String token = jwtUtil.generarToken(existente.getEmail());
        return Map.of("token", token);
    }
}

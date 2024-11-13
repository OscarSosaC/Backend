package com.auradecristal.aura_de_cristal.auth;

import com.auradecristal.aura_de_cristal.config.JwtService;
import com.auradecristal.aura_de_cristal.entity.Role;
import com.auradecristal.aura_de_cristal.entity.Usuario;
import com.auradecristal.aura_de_cristal.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final PasswordEncoder passwordEncoder;
    private final UsuarioRepository usuarioRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    public AuthenticationResponse register (RegisterRequest request){
        Usuario usuario = Usuario.builder()
                .nombre(request.getNombre())
                .apellido(request.getApellido())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .rol(Role.USER)
                .build();
        Optional<Usuario> usuarioBD = usuarioRepository.findByEmail(usuario.getEmail());
        if(usuarioBD.isPresent()){
            throw  new IllegalArgumentException("El usuario ya existe.");
        }
        usuarioRepository.save(usuario);
        String token = jwtService.generateToken(usuario);
        return AuthenticationResponse.builder()
                .token(token)
                .build();

    }

    public AuthenticationResponse login(AuthenticationRequest request){

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        Usuario usuario = usuarioRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("No existe el usuario"));

        String token = jwtService.generateToken(usuario);
        return AuthenticationResponse.builder()
                .token(token)
                .build();
    }
}
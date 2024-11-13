package com.auradecristal.aura_de_cristal.auth;

import com.auradecristal.aura_de_cristal.config.JwtService;
import com.auradecristal.aura_de_cristal.entity.Rol;
import com.auradecristal.aura_de_cristal.entity.Usuario;
import com.auradecristal.aura_de_cristal.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
                .rol(Rol.USER)
                .build();
        usuarioRepository.save(usuario);
        String token = jwtService.generateToken(usuario);
        return AuthenticationResponse.builder()
                .token(token)
                .build();

    }

    public AuthenticationResponse login(AuthenticationRequest request){
        System.out.println("40 find by email" + request);
        System.out.println("40 find by email" + request.getEmail()+ "---" + request.getPassword());

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        System.out.println("45 find by email");

        Usuario usuario = usuarioRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> {
                    System.out.println("exception in find by email");
                    return new RuntimeException("No existe el usuario");
                });
        System.out.println("call login  with: " + usuario);

        String token = jwtService.generateToken(usuario);
        return AuthenticationResponse.builder()
                .token(token)
                .build();
    }
}
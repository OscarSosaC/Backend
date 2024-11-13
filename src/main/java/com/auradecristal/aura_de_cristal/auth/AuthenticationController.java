package com.auradecristal.aura_de_cristal.auth;

import com.auradecristal.aura_de_cristal.controller.CategoriaController;
import com.auradecristal.aura_de_cristal.util.JsonPrinter;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);


    @PostMapping("/register")
    ResponseEntity<?> register(@RequestBody RegisterRequest request){
        LOGGER.info("Peticion POST register: {}", JsonPrinter.toString(request));
        try {
            AuthenticationResponse response = authenticationService.register(request);
            LOGGER.info("Peticion POST register response: {}", JsonPrinter.toString(response));
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            LOGGER.error("Peticion POST register error: {}", JsonPrinter.toString(e.getMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    ResponseEntity<?> login(@RequestBody AuthenticationRequest request){
        LOGGER.info("Peticion POST login: {}", JsonPrinter.toString(request));
        try{
            AuthenticationResponse response = authenticationService.login(request);
            LOGGER.info("Peticion POST login response: {}", JsonPrinter.toString(response));
            return ResponseEntity.ok(response);
        } catch (RuntimeException e){
            LOGGER.error("Peticion POST login error: {}", JsonPrinter.toString(e.getMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
package com.auradecristal.aura_de_cristal.controller;

import com.auradecristal.aura_de_cristal.dto.salida.UsuarioSalidaDTO;
import com.auradecristal.aura_de_cristal.service.impl.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/usuario")
@CrossOrigin
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    private final Logger LOGGER = LoggerFactory.getLogger(UsuarioController.class);

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/buscar/{email}")
    public ResponseEntity<UsuarioSalidaDTO> buscarUsuarioXEmail(@PathVariable String email) {
        System.out.println("call buscar with email: " + email);
        return new ResponseEntity<>(usuarioService.buscarUsuarioXEmail(email), HttpStatus.OK);
    }
}

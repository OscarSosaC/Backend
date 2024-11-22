package com.auradecristal.aura_de_cristal.controller;

import com.auradecristal.aura_de_cristal.dto.entrada.UsuarioEntradaDTO;
import com.auradecristal.aura_de_cristal.dto.salida.ProductoSalidaDTO;
import com.auradecristal.aura_de_cristal.dto.salida.UsuarioSalidaDTO;
import com.auradecristal.aura_de_cristal.entity.Rol;
import com.auradecristal.aura_de_cristal.service.impl.UsuarioService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("usuarios")
@CrossOrigin
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    private final Logger LOGGER = LoggerFactory.getLogger(UsuarioController.class);

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioSalidaDTO>> listarUsuarios () {
        return new ResponseEntity<>(usuarioService.listarUsuarios(), HttpStatus.OK);
    }

    @GetMapping("/buscar/{email}")
    public ResponseEntity<?> buscarUsuarioXEmail(@PathVariable String email) {
        try{
            return new ResponseEntity<>(usuarioService.buscarUsuarioXEmail(email), HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioSalidaDTO> actualizarUsuario(@PathVariable Integer id, @RequestBody @Valid UsuarioEntradaDTO usuarioEntradaDTO) {
        try {
            UsuarioSalidaDTO usuarioActualizado = usuarioService.actualizarUsuario(id, usuarioEntradaDTO);
            return ResponseEntity.ok(usuarioActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/roles")
    public ResponseEntity<List<String>> obtenerRoles() {
        List<String> roles = Arrays.stream(Rol.values())
                .map(Enum::name)
                .toList();
        return ResponseEntity.ok(roles);
    }

}

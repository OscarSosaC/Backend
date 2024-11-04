package com.auradecristal.aura_de_cristal.controller;

import com.auradecristal.aura_de_cristal.dto.entrada.ImagenEntradaDTO;
import com.auradecristal.aura_de_cristal.dto.salida.ImagenSalidaDTO;
import com.auradecristal.aura_de_cristal.service.impl.ImagenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("imagenes")
public class ImagenController {

    @Autowired
    private ImagenService imagenService;

    public ImagenController(ImagenService imagenService) {
        this.imagenService = imagenService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ImagenSalidaDTO>> listarImagenes () {
        return new ResponseEntity<>(imagenService.listarImagenes(), HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<ImagenSalidaDTO> registrarImagenes (@Valid @RequestBody ImagenEntradaDTO imagenEntradaDTO) {
        return new ResponseEntity<>(imagenService.registrarImagen(imagenEntradaDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImagenSalidaDTO> buscarImagenXId (@PathVariable Long id) {
        return new ResponseEntity<>(imagenService.buscarImagenXId(id), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<?> eliminarImagen (@RequestParam Long id) {
        imagenService.eliminarImagen(id);
        return new ResponseEntity<>("Imagen eliminada correctamente", HttpStatus.NO_CONTENT);
    }

}

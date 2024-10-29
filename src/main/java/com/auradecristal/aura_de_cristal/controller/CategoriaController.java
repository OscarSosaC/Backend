package com.auradecristal.aura_de_cristal.controller;

import com.auradecristal.aura_de_cristal.dto.entrada.CategoriaEntradaDTO;
import com.auradecristal.aura_de_cristal.dto.salida.CategoriaSalidaDTO;
import com.auradecristal.aura_de_cristal.service.impl.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<CategoriaSalidaDTO>> listarCategorias () {
        return new ResponseEntity<>(categoriaService.listarCategorias(), HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<CategoriaSalidaDTO> registrarCategoria (@Valid @RequestBody CategoriaEntradaDTO categoriaEntradaDTO) {
        return new ResponseEntity<>(categoriaService.registrarCategoria(categoriaEntradaDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaSalidaDTO> buscarCategoriaXId (@PathVariable Long id) {
        return new ResponseEntity<>(categoriaService.buscarCategoriaXId(id), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<?> eliminarCategoria (@RequestParam Long id) {
        categoriaService.eliminarCategoria(id);
        return new ResponseEntity<>("Categoria eliminada correctamente", HttpStatus.NO_CONTENT);
    }
}

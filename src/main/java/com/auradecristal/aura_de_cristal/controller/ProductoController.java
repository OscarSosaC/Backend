package com.auradecristal.aura_de_cristal.controller;

import com.auradecristal.aura_de_cristal.dto.entrada.ProductoEntradaDTO;
import com.auradecristal.aura_de_cristal.dto.salida.ProductoSalidaDTO;
import com.auradecristal.aura_de_cristal.service.impl.ProductoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ProductoSalidaDTO>> listarProductos () {
        return new ResponseEntity<>(productoService.listarProductos(), HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<ProductoSalidaDTO> registrarProductos (@Valid @RequestBody ProductoEntradaDTO productoEntradaDTO) {
        return new ResponseEntity<>(productoService.registrarProducto(productoEntradaDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoSalidaDTO> buscarProductoXId (@PathVariable Long id) {
        return new ResponseEntity<>(productoService.buscarProductoXId(id), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<?> eliminarProducto (@RequestParam Long id) {
        productoService.eliminarProducto(id);
        return new ResponseEntity<>("Producto eliminado correctamente", HttpStatus.NO_CONTENT);
    }

}

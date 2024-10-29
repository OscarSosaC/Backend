package com.auradecristal.aura_de_cristal.service;

import com.auradecristal.aura_de_cristal.dto.entrada.ProductoEntradaDTO;
import com.auradecristal.aura_de_cristal.dto.salida.ProductoSalidaDTO;

import java.util.List;

public interface IProdutoService {

    List<ProductoSalidaDTO> listarProductos();
    ProductoSalidaDTO registrarProducto(ProductoEntradaDTO productoEntradaDTO);
    ProductoSalidaDTO buscarProductoXId(Long id);
    void eliminarProducto(Long id);
}

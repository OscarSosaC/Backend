package com.auradecristal.aura_de_cristal.service;

import com.auradecristal.aura_de_cristal.dto.entrada.ProductoEntradaDTO;
import com.auradecristal.aura_de_cristal.dto.salida.ProductoSalidaDTO;

public interface IProdutoService {

    ProductoSalidaDTO registrarProducto(ProductoEntradaDTO productoEntradaDTO);
    ProductoSalidaDTO buscarProductoXId(int id);
    void eliminarProducto(int id);
}

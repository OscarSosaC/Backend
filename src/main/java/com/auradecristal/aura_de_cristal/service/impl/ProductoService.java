package com.auradecristal.aura_de_cristal.service.impl;

import com.auradecristal.aura_de_cristal.dto.entrada.ProductoEntradaDTO;
import com.auradecristal.aura_de_cristal.dto.salida.ProductoSalidaDTO;
import com.auradecristal.aura_de_cristal.entity.Producto;
import com.auradecristal.aura_de_cristal.repository.ProductoRepository;
import com.auradecristal.aura_de_cristal.service.IProdutoService;
import com.auradecristal.aura_de_cristal.util.JsonPrinter;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProdutoService {

    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private ModelMapper modelMapper;
    private final Logger LOGGER = LoggerFactory.getLogger(ProductoService.class);

    public ProductoService(ProductoRepository productoRepository, ModelMapper modelMapper) {
        this.productoRepository = productoRepository;
        this.modelMapper = modelMapper;
        configureMapping();
    }

    @Override
    public ProductoSalidaDTO registrarProducto(ProductoEntradaDTO productoEntradaDTO) {
        LOGGER.info("ProductoEntradaDTO: " + JsonPrinter.toString(productoEntradaDTO));
        Producto producto = modelMapper.map(productoEntradaDTO, Producto.class);
        LOGGER.info("ProductoEntity: " + JsonPrinter.toString(producto));

        ProductoSalidaDTO productoSalidaDTO = modelMapper.map(productoRepository.save(producto), ProductoSalidaDTO.class);
        LOGGER.info("ProductoSalidaDto: " + JsonPrinter.toString(productoSalidaDTO));
        return productoSalidaDTO;
    }

    @Override
    public ProductoSalidaDTO buscarProductoXId(int id) {
        Producto productoBuscado = productoRepository.findById(id).orElse(null);
        ProductoSalidaDTO productoEncontrado = null;

        if (productoBuscado != null){
            productoEncontrado = modelMapper.map(productoBuscado, ProductoSalidaDTO.class);
            LOGGER.info("Producto encontrado: {}", JsonPrinter.toString(productoEncontrado));
        } else {
            LOGGER.info("Producto no encontrado: {}");
        }

        return productoEncontrado;
    }

    @Override
    public void eliminarProducto(int id) {
        if (buscarProductoXId(id) != null) {
            productoRepository.deleteById(id);
            LOGGER.info("Producto eliminado el producto con id: {}", id);
        } else {
            LOGGER.info("Producto no encontrado para eliminar: {}", id);
        }
    }

    /**
     * Configuracion del mapper para asignar el valor del atributo Domicilio para personalizar
     * cómo los objetos se convierten entre sí, específicamente entre ProductoEntradaDto y
     * Producto, y entre Producto y ProductoSalidaDto.
     */
    private void configureMapping(){
        modelMapper.typeMap(ProductoEntradaDTO.class, Producto.class)
                .addMappings(mapper -> mapper.map(ProductoEntradaDTO::getCategoria, Producto::setCategoria));
        modelMapper.typeMap(Producto.class, ProductoSalidaDTO.class)
                .addMappings(mapper -> mapper.map(Producto::getCategoria, ProductoSalidaDTO::setCategoria));
    }
}

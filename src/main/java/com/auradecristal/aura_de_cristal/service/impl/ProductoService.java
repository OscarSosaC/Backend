package com.auradecristal.aura_de_cristal.service.impl;

import com.auradecristal.aura_de_cristal.dto.entrada.CategoriaEntradaDTO;
import com.auradecristal.aura_de_cristal.dto.entrada.ImagenEntradaDTO;
import com.auradecristal.aura_de_cristal.dto.entrada.ProductoEntradaDTO;
import com.auradecristal.aura_de_cristal.dto.salida.ProductoSalidaDTO;
import com.auradecristal.aura_de_cristal.entity.Categoria;
import com.auradecristal.aura_de_cristal.entity.Producto;
import com.auradecristal.aura_de_cristal.entity.Tematica;
import com.auradecristal.aura_de_cristal.repository.CategoriaRepository;
import com.auradecristal.aura_de_cristal.repository.ImagenRepository;
import com.auradecristal.aura_de_cristal.repository.ProductoRepository;
import com.auradecristal.aura_de_cristal.repository.TematicaRepository;
import com.auradecristal.aura_de_cristal.service.IProdutoService;
import com.auradecristal.aura_de_cristal.util.JsonPrinter;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProdutoService {

    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private TematicaRepository tematicaRepository;
    @Autowired
    private ImagenService imagenService;
    @Autowired
    private ModelMapper modelMapper;
    private final Logger LOGGER = LoggerFactory.getLogger(ProductoService.class);

    public ProductoService(ProductoRepository productoRepository, CategoriaRepository categoriaRepository, TematicaRepository tematicaRepository, ModelMapper modelMapper) {
        this.tematicaRepository = tematicaRepository;
        this.categoriaRepository = categoriaRepository;
        this.productoRepository = productoRepository;
        this.modelMapper = modelMapper;
        configureMapping();
    }

    @Override
    public List<ProductoSalidaDTO> listarProductos() {
        List<ProductoSalidaDTO> productos = productoRepository.findAll()
                .stream()
                .map(producto -> modelMapper.map(producto, ProductoSalidaDTO.class))
                .toList();
        LOGGER.info("Listado de todos los productos: {}", JsonPrinter.toString(productos));
        return productos;
    }

    @Override
    public ProductoSalidaDTO registrarProducto(ProductoEntradaDTO productoEntradaDTO) {
        LOGGER.info("ProductoEntradaDTO: " + JsonPrinter.toString(productoEntradaDTO));
        Producto producto = modelMapper.map(productoEntradaDTO, Producto.class);
        LOGGER.info("ProductoEntity: " + JsonPrinter.toString(producto));

        Categoria categoria = categoriaRepository.findById(productoEntradaDTO.getCategoria_id())
                .orElseThrow(() -> new EntityNotFoundException("Categoría no encontrada"));

        Tematica tematica = tematicaRepository.findById(productoEntradaDTO.getTematica_id())
                .orElseThrow(() -> new EntityNotFoundException("Temática no encontrada"));

        producto.setCategoria(categoria);
        producto.setTematica(tematica);

        ProductoSalidaDTO productoSalidaDTO = modelMapper.map(productoRepository.save(producto), ProductoSalidaDTO.class);

        for (String url : productoEntradaDTO.getImagenes()) {
            LOGGER.info("Url imagen: {}", url);
            ImagenEntradaDTO imagenEntradaDTO = new ImagenEntradaDTO(url, productoSalidaDTO.getId());
            imagenService.registrarImagen(imagenEntradaDTO);
        }

        LOGGER.info("ProductoSalidaDto: " + JsonPrinter.toString(productoSalidaDTO));
        return productoSalidaDTO;
    }

    @Override
    public ProductoSalidaDTO buscarProductoXId(Long id) {
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
    public void eliminarProducto(Long id) {
        if (buscarProductoXId(id) != null) {
            productoRepository.deleteById(id);
            LOGGER.info("Producto eliminado el producto con id: {}", id);
        } else {
            LOGGER.info("Producto no encontrado para eliminar: {}", id);
        }
    }

    /**
     * Configuracion del mapper para asignar el valor del atributo Categoria y Tematica para personalizar
     * cómo los objetos se convierten entre sí, específicamente entre ProductoEntradaDto y
     * Producto, y entre Producto y ProductoSalidaDto.
     */
    private void configureMapping() {
        modelMapper.typeMap(ProductoEntradaDTO.class, Producto.class)
                .addMappings(mapper -> {
                    mapper.map(ProductoEntradaDTO::getNombre, Producto::setNombre);
                    mapper.map(ProductoEntradaDTO::getDescripcion, Producto::setDescripcion);
                    mapper.map(ProductoEntradaDTO::getPrecio_alquiler, Producto::setPrecio_alquiler);
                    mapper.map(ProductoEntradaDTO::getDisponibilidad, Producto::setDisponibilidad);
                    mapper.map(ProductoEntradaDTO::getInventario, Producto::setInventario);
                });

        modelMapper.typeMap(Producto.class, ProductoSalidaDTO.class)
                .addMappings(mapper -> mapper.map(Producto::getCategoria, ProductoSalidaDTO::setCategoria))
                .addMappings(mapper -> mapper.map(Producto::getTematica, ProductoSalidaDTO::setTematica));
    }

}

package com.auradecristal.aura_de_cristal.service.impl;

import com.auradecristal.aura_de_cristal.dto.entrada.CategoriaEntradaDTO;
import com.auradecristal.aura_de_cristal.dto.salida.CategoriaSalidaDTO;
import com.auradecristal.aura_de_cristal.entity.Categoria;
import com.auradecristal.aura_de_cristal.repository.CategoriaRepository;
import com.auradecristal.aura_de_cristal.service.ICategoriaService;
import com.auradecristal.aura_de_cristal.util.JsonPrinter;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService implements ICategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ModelMapper modelMapper;
    private final Logger LOGGER = LoggerFactory.getLogger(CategoriaService.class);

    public CategoriaService(CategoriaRepository categoriaRepository, ModelMapper modelMapper) {
        this.categoriaRepository = categoriaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CategoriaSalidaDTO> listarCategorias() {
        List<CategoriaSalidaDTO> categorias = categoriaRepository.findAll()
                .stream()
                .map(categoria -> modelMapper.map(categoria, CategoriaSalidaDTO.class))
                .toList();
        LOGGER.info("Listado de todas las categorias: {}", categorias);
        return categorias;
    }

    @Override
    public CategoriaSalidaDTO registrarCategoria(CategoriaEntradaDTO categoriaEntradaDTO) {
        LOGGER.info("CategoriaEntradaDTO: " + JsonPrinter.toString(categoriaEntradaDTO));
        Categoria categoria = modelMapper.map(categoriaEntradaDTO, Categoria.class);
        LOGGER.info("CategoriaEntity: " + JsonPrinter.toString(categoria));

        CategoriaSalidaDTO categoriaSalidaDTO = modelMapper.map(categoriaRepository.save(categoria), CategoriaSalidaDTO.class);
        LOGGER.info("CategoriaSalidaDto: " + JsonPrinter.toString(categoriaSalidaDTO));
        return categoriaSalidaDTO;
    }

    @Override
    public CategoriaSalidaDTO buscarCategoriaXId(Long id) {
        Categoria categoriaBuscada = categoriaRepository.findById(id).orElse(null);
        CategoriaSalidaDTO categoriaEncontrada = null;

        if (categoriaBuscada != null){
            categoriaEncontrada = modelMapper.map(categoriaBuscada, CategoriaSalidaDTO.class);
            LOGGER.info("Categoria encontrada: {}", JsonPrinter.toString(categoriaEncontrada));
        } else {
            LOGGER.info("Categoria no encontrado: {}");
        }

        return categoriaEncontrada;
    }

    @Override
    public void eliminarCategoria(Long id) {
        if (buscarCategoriaXId(id) != null) {
            categoriaRepository.deleteById(id);
            LOGGER.info("Categoria eliminado con id: {}", id);
        } else {
            LOGGER.info("Categoria no encontrado para eliminar: {}", id);
        }
    }
}

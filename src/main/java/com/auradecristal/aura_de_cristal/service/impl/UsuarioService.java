package com.auradecristal.aura_de_cristal.service.impl;

import com.auradecristal.aura_de_cristal.dto.salida.UsuarioSalidaDTO;
import com.auradecristal.aura_de_cristal.entity.Usuario;
import com.auradecristal.aura_de_cristal.repository.IUsuarioRepository;
import com.auradecristal.aura_de_cristal.service.IUsuarioService;
import com.auradecristal.aura_de_cristal.util.JsonPrinter;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;
    @Autowired
    private ModelMapper modelMapper;
    private final Logger LOGGER = LoggerFactory.getLogger(UsuarioService.class);

    public UsuarioService(IUsuarioRepository usuarioRepository, ModelMapper modelMapper) {
        this.usuarioRepository = usuarioRepository;
        this.modelMapper = modelMapper;
        configureMapping();
    }

    @Override
    public UsuarioSalidaDTO buscarUsuarioXEmail(String email) {
        Usuario usuarioBuscada = usuarioRepository.findByEmail(email).orElse(null);
        UsuarioSalidaDTO usuarioEncontrada = null;

        if (usuarioBuscada != null){
            usuarioEncontrada = modelMapper.map(usuarioBuscada, UsuarioSalidaDTO.class);
            LOGGER.info("Usuario encontrada: {}", JsonPrinter.toString(usuarioEncontrada));
        } else {
            LOGGER.info("Usuario no encontrado: {}");
            throw new RuntimeException("Usuario no encontrado");
        }

        return usuarioEncontrada;
    }
    private void configureMapping() {
        modelMapper.typeMap(Usuario.class, UsuarioSalidaDTO.class)
                .addMappings(mapper -> mapper.map(Usuario::getApellido, UsuarioSalidaDTO::setApellido))
                .addMappings(mapper -> mapper.map(Usuario::getNombre, UsuarioSalidaDTO::setNombre))
                .addMappings(mapper -> mapper.map(Usuario::getEmail, UsuarioSalidaDTO::setEmail));
    }
}

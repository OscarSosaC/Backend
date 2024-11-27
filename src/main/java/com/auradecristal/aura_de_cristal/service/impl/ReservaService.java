package com.auradecristal.aura_de_cristal.service.impl;

import com.auradecristal.aura_de_cristal.dto.entrada.ReservaEntradaDTO;
import com.auradecristal.aura_de_cristal.dto.salida.ProductoSalidaDTO;
import com.auradecristal.aura_de_cristal.dto.salida.ReservaSalidaDTO;
import com.auradecristal.aura_de_cristal.dto.salida.UsuarioSalidaDTO;
import com.auradecristal.aura_de_cristal.entity.Producto;
import com.auradecristal.aura_de_cristal.entity.Reserva;
import com.auradecristal.aura_de_cristal.entity.Usuario;
import com.auradecristal.aura_de_cristal.repository.IProductoRepository;
import com.auradecristal.aura_de_cristal.repository.IReservaRepository;
import com.auradecristal.aura_de_cristal.repository.IUsuarioRepository;
import com.auradecristal.aura_de_cristal.service.IReservaService;
import com.auradecristal.aura_de_cristal.util.JsonPrinter;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService implements IReservaService {

    @Autowired
    private IReservaRepository reservaRepository;
    @Autowired
    private IProductoRepository productoRepository;
    @Autowired
    private IUsuarioRepository usuarioRepository;
    @Autowired
    private ModelMapper modelMapper;
    private final Logger LOGGER = LoggerFactory.getLogger(ReservaService.class);

    public ReservaService(IReservaRepository reservaRepository, IProductoRepository productoRepository, IUsuarioRepository usuarioRepository, ModelMapper modelMapper) {
        this.reservaRepository = reservaRepository;
        this.productoRepository = productoRepository;
        this.usuarioRepository = usuarioRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ReservaSalidaDTO registrarReserva(ReservaEntradaDTO reservaEntradaDTO) {
        Reserva reserva = modelMapper.map(reservaEntradaDTO, Reserva.class);
        Producto producto = productoRepository.findById(reserva.getProducto().getIdProducto())
                .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado"));
        Usuario usuario = usuarioRepository.findById(reserva.getUsuario().getId())
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado"));
        reserva.setProducto(producto);
        reserva.setUsuario(usuario);

        Reserva reservaGuardada = reservaRepository.save(reserva);
        ReservaSalidaDTO reservaSalidaDTO = modelMapper.map(reservaGuardada, ReservaSalidaDTO.class);
        LOGGER.info("ReservaSalidaDTO: " + JsonPrinter.toString(reservaSalidaDTO));
        return reservaSalidaDTO;
    }

    @Override
    public List<ReservaSalidaDTO> buscarReservasXUsarioId(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado"));

        List<Reserva> reservas = reservaRepository.findByUsuario_Id(usuario.getId());

        if (reservas.isEmpty()) {
            throw new EntityNotFoundException("No se encontraron reservas para el usuario con ID: " + usuarioId);
        }

        List<ReservaSalidaDTO> reservasSalidaDTO = reservas.stream()
                .map(reserva -> modelMapper.map(reserva, ReservaSalidaDTO.class))
                .toList();

        LOGGER.info("Reservas encontradas para el usuario {}: {}", usuarioId, JsonPrinter.toString(reservasSalidaDTO));
        return reservasSalidaDTO;
    }

    @Override
    public void eliminarReserva(Long idReserva) {
        Reserva reserva = reservaRepository.findById(idReserva)
                .orElseThrow(() -> new EntityNotFoundException("Reserva no encontrada con ID: " + idReserva));
        reservaRepository.delete(reserva);
        LOGGER.info("Reserva con ID {} eliminada correctamente", idReserva);
    }

    @Override
    public ReservaSalidaDTO actualizarReserva(ReservaEntradaDTO reservaEntradaDTO, Long idReserva) {
        Reserva reservaExistente = reservaRepository.findById(idReserva)
                .orElseThrow(() -> new EntityNotFoundException("Reserva no encontrada con ID: " + idReserva));

        Producto producto = productoRepository.findById(reservaEntradaDTO.getProductoId())
                .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado con ID: " + reservaEntradaDTO.getProductoId()));

        Usuario usuario = usuarioRepository.findById(reservaEntradaDTO.getUsuarioId())
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con ID: " + reservaEntradaDTO.getUsuarioId()));

        reservaExistente.setFechaInicio(reservaEntradaDTO.getFechaInicio());
        reservaExistente.setFechaFin(reservaEntradaDTO.getFechaFin());
        reservaExistente.setCantidad(reservaEntradaDTO.getCantidad());
        reservaExistente.setProducto(producto);
        reservaExistente.setUsuario(usuario);

        Reserva reservaActualizada = reservaRepository.save(reservaExistente);
        ReservaSalidaDTO reservaSalidaDTO = modelMapper.map(reservaActualizada, ReservaSalidaDTO.class);

        LOGGER.info("Reserva actualizada: {}", JsonPrinter.toString(reservaSalidaDTO));
        return reservaSalidaDTO;
    }

}

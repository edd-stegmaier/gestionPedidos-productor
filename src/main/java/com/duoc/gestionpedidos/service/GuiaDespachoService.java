package com.duoc.gestionpedidos.service;

import org.springframework.stereotype.Service;
import com.duoc.gestionpedidos.dto.*;
import com.duoc.gestionpedidos.repository.GuiaDespachoRepository;
import com.duoc.gestionpedidos.model.GuiaDespachoEntity;
import java.util.List;

import com.duoc.gestionpedidos.dto.GuiaDespachoRequestDTO;

@Service
public class GuiaDespachoService {

    private final GuiaDespachoRepository guiaDespachoRepository;

    private final MensajeService mensajeService;

    public GuiaDespachoService(MensajeService mensajeService, GuiaDespachoRepository guiaDespachoRepository) {
        this.mensajeService = mensajeService;
        this.guiaDespachoRepository = guiaDespachoRepository;
    }

    public void enviarGuiaDeDespacho(GuiaDespachoRequestDTO guiaDespachoRequestDTO) {
        mensajeService.enviarObjeto(guiaDespachoRequestDTO);
    }

    //listar guias de despacho
    public List<GuiaDespachoResponseDTO> listarGuiasDeDespacho(){
        return guiaDespachoRepository.findAll().stream().map(this::toDTO).toList();
    }

    //obtener guia de despacho por id
    public GuiaDespachoResponseDTO obtenerGuiaDeDespachoId(Long id){
        return guiaDespachoRepository.findById(id).map(this::toDTO).orElse(null);
    }
        
    private GuiaDespachoResponseDTO toDTO(GuiaDespachoEntity guiaDespacho){
        ProductoResponseDTO productoDTO = new ProductoResponseDTO(
            guiaDespacho.getProducto().getId(),
            guiaDespacho.getProducto().getNombre(),
            guiaDespacho.getProducto().getValor(),
            guiaDespacho.getProducto().getUnidades()
        );

        ClienteResponseDTO clienteDTO = new ClienteResponseDTO(
            guiaDespacho.getCliente().getId(),
            guiaDespacho.getCliente().getNombre()
        );

        EmpleadoResponseDTO empleadoDTO = new EmpleadoResponseDTO(
            guiaDespacho.getEmpleado().getId(),
            guiaDespacho.getEmpleado().getNombre(),
            guiaDespacho.getEmpleado().getCargo()
        );

        return new GuiaDespachoResponseDTO(
            guiaDespacho.getId(),
            productoDTO,
            clienteDTO,
            empleadoDTO,
            guiaDespacho.getFecha(),
            null
        );
    }
}

package com.duoc.gestionpedidos.service;

import org.springframework.stereotype.Service;

import com.duoc.gestionpedidos.dto.GuiaDespachoRequestDTO;

@Service
public class GuiaDespachoService {

    private final MensajeService mensajeService;

    public GuiaDespachoService(MensajeService mensajeService) {
        this.mensajeService = mensajeService;
    }

    public void enviarGuiaDeDespacho(GuiaDespachoRequestDTO guiaDespachoRequestDTO) {
        mensajeService.enviarObjeto(guiaDespachoRequestDTO);
    }
}

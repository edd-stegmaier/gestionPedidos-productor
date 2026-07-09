package com.duoc.gestionpedidos.controller;

import com.duoc.gestionpedidos.dto.GuiaDespachoRequestDTO;
import com.duoc.gestionpedidos.service.GuiaDespachoService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/guias-despacho")
public class GuiaDespachoController {

    private final GuiaDespachoService guiaDespachoService;

    public GuiaDespachoController(GuiaDespachoService guiaDespachoService) {
        this.guiaDespachoService = guiaDespachoService;
    }

    @GetMapping("/test")
    public ResponseEntity<String> testEndpoint() {
        return ResponseEntity.ok("El servicio productor de Guias de Despacho se encuentra funcionando correctamente");
    }

    @PostMapping
    public ResponseEntity<String> crearGuiaDespacho(@Valid @RequestBody GuiaDespachoRequestDTO guiaDespachoRequestDTO) {
        guiaDespachoService.enviarGuiaDeDespacho(guiaDespachoRequestDTO);
        return ResponseEntity.accepted().body("Guia de despacho enviada a la cola");
    }
}

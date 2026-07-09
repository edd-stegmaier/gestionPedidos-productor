package com.duoc.gestionpedidos.controller;

import java.util.List;

import com.duoc.gestionpedidos.dto.ClienteRequestDTO;
import com.duoc.gestionpedidos.dto.ClienteResponseDTO;
import com.duoc.gestionpedidos.service.ClienteService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    //test endpoint
    @GetMapping("/test")
    public ResponseEntity<String> testEndpoint(){
        return ResponseEntity.ok("El servicio de Clientes se encuentra funcionando correctamente");
    }

    // obtener lista de clientes
    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> listarClientes(){
        return ResponseEntity.ok(clienteService.listarClientes());
    }

    //obtener cliente por id
    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> obtenerClienteId(@PathVariable Long id){
        ClienteResponseDTO cliente = clienteService.obtenerClienteId(id);
        if(cliente == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }


}

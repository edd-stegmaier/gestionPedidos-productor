package com.duoc.gestionpedidos.controller;

import java.util.List;

import com.duoc.gestionpedidos.dto.EmpleadoResponseDTO;
import com.duoc.gestionpedidos.service.EmpleadoService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {
    
    private final EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService){
        this.empleadoService = empleadoService;
    }
    
    // obtener lista de empleados
    @GetMapping
    public ResponseEntity<List<EmpleadoResponseDTO>> listarEmpleados(){
        return ResponseEntity.ok(empleadoService.listarEmpleados());
    }

    //obtener empleado por id
    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoResponseDTO> obtenerEmpleadoId(@PathVariable Long id){
        EmpleadoResponseDTO empleado = empleadoService.obtenerEmpleadoId(id);
        if(empleado == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(empleado);
    }


}

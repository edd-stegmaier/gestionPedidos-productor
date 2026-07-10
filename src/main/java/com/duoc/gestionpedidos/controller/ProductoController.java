package com.duoc.gestionpedidos.controller;

import java.util.List;

import com.duoc.gestionpedidos.dto.ProductoResponseDTO;
import com.duoc.gestionpedidos.service.ProductoService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService){
        this.productoService = productoService;
    }

    // obtener lista de productos
    @GetMapping
    public ResponseEntity<List<ProductoResponseDTO>> listarProductos(){
        return ResponseEntity.ok(productoService.listarProductos());
    }

    //obtener producto por id
    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> obtenerProductoId(@PathVariable Long id){
        ProductoResponseDTO producto = productoService.obtenerProductoId(id);
        if(producto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(producto);
    }

}

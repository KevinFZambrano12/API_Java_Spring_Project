/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.demo.controller;

/**
 *
 * @author Kevin Zambrano
 */
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.demo.model.Producto;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "http://localhost:3000")

public class ProductoController {
    private List<Producto> productos = new ArrayList<>(
        Arrays.asList(
            new Producto(1L, "Camiseta", 25.0),
            new Producto(2L, "Pantalón", 40.0),
            new Producto(3L, "Zapatos", 60.0)
        )
    );

    @GetMapping
    public List<Producto> getAll() {
        return productos;
    }

    @PostMapping
    public Producto addProducto(@RequestBody Producto p) {
        p.setId((long) (productos.size() + 1));
        productos.add(p);
        return p;
    }
}

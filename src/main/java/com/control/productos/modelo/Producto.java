package com.control.productos.modelo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Producto {
    private Long id;
    private String nombre;
    private Double precio;
    private List<Reseña> reseñas = new ArrayList<>(); //Relacion 1 a muchos
}

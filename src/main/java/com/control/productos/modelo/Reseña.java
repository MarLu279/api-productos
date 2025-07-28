package com.control.productos.modelo;

import lombok.Data;

@Data
public class Reseña {
    private Long id;
    private Long productoId;
    private String autor;
    private String Comentario;
    private int calificacion;
}

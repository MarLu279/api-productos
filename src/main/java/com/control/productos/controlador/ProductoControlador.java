package com.control.productos.controlador;
// Clase de controlador REST para Producto

import com.control.productos.modelo.Producto;
import com.control.productos.modelo.Reseña;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoControlador {
    private List<Producto> productos = new ArrayList<>();

    @GetMapping
    public List<Producto> listarProductos(){
        return this.productos;
    }

    @PostMapping
    public Producto agregarProducto(@RequestBody Producto producto){
        producto.setId((long)(productos.size()+1));
        productos.add(producto);
        return producto;
    }

    @GetMapping("/buscar")
    public List<Producto> buscarProductoNombre(@RequestParam String nombre){
        List<Producto> resultados = new ArrayList<>();
        for(Producto pro : productos){
            if(pro.getNombre().equalsIgnoreCase(nombre)){
                resultados.add(pro);
            }
        }
        return resultados;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarProducto(@PathVariable Long id){
        Producto producto = encontrarProductoPorId(id);
        productos.remove(producto);
        return ResponseEntity.ok("Producto con ID " + id + " eliminado");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id,
                                                       @RequestBody Producto productoActualizado){
        Producto producto = encontrarProductoPorId(id);
        //Actualizar campos nulos
        if(productoActualizado.getNombre() != null){
            producto.setNombre(productoActualizado.getNombre());
        }
        if(productoActualizado.getPrecio() != null){
            producto.setPrecio(productoActualizado.getPrecio());
        }
        return ResponseEntity.ok(producto);
    }

    //Reseñas

    @PostMapping("/{productoId}/reseñas")
    public Producto agregarReseña(@PathVariable Long productoId,
                                  @RequestBody Reseña reseña){
        Producto producto = encontrarProductoPorId(productoId);
        reseña.setId((long) (producto.getReseñas().size()+1));
        producto.getReseñas().add(reseña);
        return producto;
    }

    public List<Reseña> obtenerReseñas(@PathVariable Long productoId){
        return encontrarProductoPorId(productoId).getReseñas();
    }

    @DeleteMapping("/{productoId}/reseñas/{reseñaId}")
    public ResponseEntity<String> eliminarReseña(@PathVariable Long productoId,
                                                 @PathVariable Long reseñaId){
        Producto producto = encontrarProductoPorId(productoId);
        List<Reseña> reseñas = producto.getReseñas();
        Reseña reseñaEliminada = null;
        for(Reseña reseña: reseñas){
            if(reseña.getId().equals(reseñaId)){
                reseñaEliminada = reseña;
                break;
            }
        }
        if (reseñaEliminada != null){
            reseñas.remove(reseñaEliminada);
            return ResponseEntity.ok("Reseña con ID " + reseñaId + " eliminada");
        } else {
            throw new RuntimeException("Reseña no encontrada con ID: " + reseñaId);
        }
    }

    @PutMapping("/{productoId}/reseñas/{reseñaId}")
    public ResponseEntity<Reseña> actualizarReseña(@PathVariable Long productoId,
                                                   @PathVariable Long reseñaId,
                                                   @RequestBody Reseña reseñaActualizada){
        Producto producto = encontrarProductoPorId(productoId);
        //buscar reseña
        Reseña reseñaAct = null;
        for(Reseña reseña : producto.getReseñas()){
            if(reseña.getId().equals(reseñaId)){
                //Actualizar campos
                if(reseñaActualizada.getComentario() != null){
                    reseña.setComentario(reseñaActualizada.getComentario());
                }
                if(reseñaActualizada.getCalificacion() != 0){
                    reseña.setCalificacion(reseñaActualizada.getCalificacion());
                }
                reseñaAct = reseña;
            }
        }
        return ResponseEntity.ok(reseñaAct);
    }

    //Helper
    private Producto encontrarProductoPorId(Long id){
        Producto producto = null;
        for(Producto aux : this.productos){
            if(aux.getId().equals(id)){
                producto = aux;
            }
        }
        return producto;
    }
}

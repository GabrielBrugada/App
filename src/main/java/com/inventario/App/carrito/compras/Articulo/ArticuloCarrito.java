package com.inventario.App.carrito.compras.Articulo;

import com.inventario.App.Producto.Producto;
import com.inventario.App.Usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "articulo_carrito")
public class ArticuloCarrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public ArticuloCarrito(int cantidad, Producto producto, Usuario usuario) {
        this.cantidad = cantidad;
        this.producto = producto;
        this.usuario = usuario;
    }

}

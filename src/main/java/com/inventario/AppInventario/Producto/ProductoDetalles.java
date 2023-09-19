package com.inventario.AppInventario.Producto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "producto_detalles")
public class ProductoDetalles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45, nullable = false)
    private String nombre;
    @Column(length = 45, nullable = false)
    private String valor;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    public ProductoDetalles(String nombre, String valor, Producto producto) {
        this.nombre = nombre;
        this.valor = valor;
        this.producto = producto;
    }

    @Override
    public String toString() {
        return nombre + "-" + valor;
    }
}

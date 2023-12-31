package com.inventario.AppInventario.Categoria;

import com.inventario.AppInventario.Marca.Marca;
import jakarta.persistence.*;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45, nullable = false, unique = true)
    private String nombre;

    @ManyToOne
    @JoinColumn(name= "marca_id")
    private Marca marca;

    public Marca getMarca() {
        return marca;
    }

    public Categoria(Integer id, String nombre, Marca marca) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
    }

    public Categoria(String nombre, Marca marca) {
        this.nombre = nombre;
        this.marca = marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Categoria(Integer id, String nombre) {
        super();
        this.id = id;
        this.nombre = nombre;
    }

    public Categoria() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Categoria(Integer id) {
        super();
        this.id = id;

    }

    public Categoria(String nombre) {
        super();
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}

package com.inventario.AppInventario.Marca;

import com.inventario.AppInventario.Categoria.Categoria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45, nullable = false, unique = true)
    private String nombre;

    @OneToMany
    @JoinColumn(name= "marca_id")
    private List<Categoria> categorias = new ArrayList<>();

    public Marca(Integer id) {
        this.id = id;
    }

    public Marca(String nombre, List<Categoria> categorias) {
        this.nombre = nombre;
        this.categorias = categorias;
    }


}

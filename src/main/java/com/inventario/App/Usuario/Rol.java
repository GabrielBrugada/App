package com.inventario.App.Usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 25, nullable = false, unique = true)
    private String nombre;


    public Rol(String nombre) {
        this.nombre = nombre;
    }

    public Rol(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rol rol)) return false;
        return Objects.equals(getId(), rol.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

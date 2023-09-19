package com.inventario.AppInventario.Usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45, nullable = false, unique = true)
    private String email;

    @Column(length = 10, nullable = false)
    private String password;

    @ManyToMany //(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles = new HashSet<>();

    public Usuario(String email, String password, Set<Rol> roles) {
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public Usuario(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Usuario(Integer id) {
        this.id = id;
    }

    public void añadirRol(Rol rol) {
        this.roles.add(rol);
    }

    public void eliminarRol(Rol rol) {
        this.roles.remove(rol);
    }


}

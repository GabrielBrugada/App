package com.inventario.AppInventario;

import com.inventario.AppInventario.Usuario.Rol;
import com.inventario.AppInventario.Usuario.Usuario;
import com.inventario.AppInventario.Usuario.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.Arrays;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public  void testCrearRoles(){
        Rol rolAdmin = new Rol("Administrador");
        Rol rolEditor = new Rol("Editor");
        Rol rolVisitante = new Rol("Visitante");

        entityManager.<Rol>persist(rolAdmin);
        for (Rol rol : Arrays.asList(rolEditor, rolVisitante)) {
            entityManager.<Rol>persist(rol);
        }



    }
    @Test
    public void testCrearUnNuevoUsuarioConUnRol(){
        Rol rolAdmin = entityManager.find(Rol.class, 1);
        Usuario usuario = new Usuario("gabrielbrugada@gmail.com","1234");

        usuario.añadirRol(rolAdmin);
        usuarioRepository.save(usuario);
    }
    @Test
    public void testCrearUnNuevoUsuarioConDosRoles(){
        Rol rolEditor = entityManager.find(Rol.class, 2);
        Rol rolVisitante = entityManager.find(Rol.class, 3);
        Usuario usuario = new Usuario("gabriel@gmail.com","12345");

        usuario.añadirRol(rolEditor);
        usuario.añadirRol(rolVisitante);
        usuarioRepository.save(usuario);
    }
    @Test
    public void testAsignarRolaUsuarioExistente(){
        Usuario usuario = usuarioRepository.findById(1).get();
        Rol rolEditor = entityManager.find(Rol.class, 2);
        usuario.añadirRol(rolEditor);

    }
    @Test
    public void testEliminarRoldeUsuarioExistente(){
        Usuario usuario = usuarioRepository.findById(1).get();
        Rol rol = new Rol(2); //le pasamos el ID del rol a eliminar
        usuario.eliminarRol(rol);
    }
    @Test
    public void testCrearNuevoUsuarioConUnNuevoRol(){
        Rol rolVendedor = new Rol("Vendedor");
        Usuario usuario = new Usuario("gabriel11@gmail.com","12345");

        usuario.añadirRol(rolVendedor);
        usuarioRepository.save(usuario);
    }
    @Test
    public void testObtenerUsuario(){
        Usuario usuario = usuarioRepository.findById(1).get();
        entityManager.detach(usuario);
        System.out.println(usuario.getEmail());
        System.out.println(usuario.getRoles());

    }
    @Test
    public void testEliminarUsuario(){
        usuarioRepository.deleteById(2);
    }


}

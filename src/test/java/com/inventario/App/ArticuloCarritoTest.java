package com.inventario.App;

import com.inventario.App.Producto.Producto;
import com.inventario.App.Usuario.Usuario;
import com.inventario.App.carrito.compras.Articulo.ArticuloCarrito;
import com.inventario.App.carrito.compras.Articulo.ArticuloCarritoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class ArticuloCarritoTest {
    @Autowired
    private ArticuloCarritoRepository repository;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testañadirArticulo(){
        Producto producto = entityManager.find(Producto.class,2);
        Usuario usuario = entityManager.find(Usuario.class, 1);

        ArticuloCarrito articulo = new ArticuloCarrito(5,producto,usuario);
        repository.save(articulo);

    }
    @Test
    public void testañadirMultiplesArticulos(){
        Usuario usuario = new Usuario(1);
        Producto producto1 = new Producto(1);
        Producto producto2= new Producto(2);

        ArticuloCarrito articulo1 = new ArticuloCarrito(5,producto1,usuario);
        ArticuloCarrito articulo2 = new ArticuloCarrito(5,producto2,usuario);

        repository.saveAll(List.of(articulo1,articulo2));

    }
    @Test
    public void testListarArticulo(){
        List<ArticuloCarrito> articulos = repository.findAll();
        articulos.forEach(System.out::println);
    }
    @Test
    public void testActualizarArticulo(){
        ArticuloCarrito articulo = repository.findById(1).get();
        articulo.setCantidad(11);
        articulo.setProducto(new Producto(2));
    }
    @Test
    public void testEliminarArticulo(){
        repository.deleteById(1);
    }


}

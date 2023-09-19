package com.inventario.AppInventario.Producto;

import com.inventario.AppInventario.Categoria.Categoria;
import com.inventario.AppInventario.Categoria.CategoriaRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("productos/nuevo")
    public String mostrarFormularioDeNuevoProducto(Model modelo){
        List<Categoria> listaCategorias = categoriaRepository.findAll();
        modelo.addAttribute("producto", new Producto());
        modelo.addAttribute("listaCategorias",listaCategorias);
        return "producto_formulario";
    }
    @PostMapping("/productos/guardar")
    public String guardarProductos(Producto producto, HttpServletRequest request){
        String[] detallesID = request.getParameterValues("detallesID");
        String[] detallesNombre = request.getParameterValues("detallesNombre");
        String[] detallesValor = request.getParameterValues("detallesValor");

        for (int i=0;i<detallesNombre.length; i++){
            if(detallesID != null && detallesID.length > 0){
                producto.setDetalles(Integer.valueOf(detallesID[i]),detallesNombre[i],detallesValor[i]);
            }else {
                producto.añadirDetalles(detallesNombre[i],detallesValor[i]);
            }
        }

        productoRepository.save(producto);
        return "redirect:/";
    }
    @GetMapping("/productos")
    public String listarProductos(Model modelo){
        List<Producto> listaProductos = productoRepository.findAll();
        modelo.addAttribute("listaProductos",listaProductos);
        return "productos";
    }
    @GetMapping("/productos/editar/{id}")
    public String mostrarFormulariodeModificarProducto(@PathVariable Integer id, Model modelo){
        Producto producto = productoRepository.findById(id).get();
        modelo.addAttribute("producto", producto);
        List<Categoria> listaCategorias = categoriaRepository.findAll();
        modelo.addAttribute("listaCategorias",listaCategorias);
        return "producto_formulario";

    }
    @GetMapping("/productos/eliminar/{id}")
    public String eliminarProducto (@PathVariable("id")Integer id,Model modelo){
        productoRepository.deleteById(id);
        return "redirect:/productos";
    }

}

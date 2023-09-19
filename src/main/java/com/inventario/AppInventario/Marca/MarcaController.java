package com.inventario.AppInventario.Marca;

import com.inventario.AppInventario.Categoria.Categoria;
import com.inventario.AppInventario.Categoria.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MarcaController {

    @Autowired
    private MarcaRepository marcaRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("marcas/nueva")
    public String mostrarFormularioDeNuevaMarca(Model modelo){
        List<Categoria> listaCategorias = categoriaRepository.findAll();
        modelo.addAttribute("marca", new Marca());
        modelo.addAttribute("listaCategorias",listaCategorias);
        return "marca_formulario";
    }
    @PostMapping("/marcas/guardar")
    public String guardarMarca(Marca marca){
        marcaRepository.save(marca);
        return "redirect:/";
    }
    @GetMapping("/marcas")
    public String listarMarcas(Model modelo){
        List<Marca> listaMarcas = marcaRepository.findAll();
        modelo.addAttribute("listaMarcas",listaMarcas);
        return "marcas";
    }
    @GetMapping("/marcas/editar/{id}")
    public String mostrarFormulariodeModificarMarca(@PathVariable Integer id, Model modelo){
        Marca marca = marcaRepository.findById(id).get();
        modelo.addAttribute("marca",marca);
        List<Categoria> listaCategorias = categoriaRepository.findAll();
        modelo.addAttribute("listaCategorias",listaCategorias);
        return "marca_formulario";

    }
    @GetMapping("/marcas/eliminar/{id}")
    public String eliminarMarca (@PathVariable("id")Integer id,Model modelo){
        marcaRepository.deleteById(id);
        return "redirect:/marcas";
    }
}

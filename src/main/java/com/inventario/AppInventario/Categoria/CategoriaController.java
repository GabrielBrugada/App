package com.inventario.AppInventario.Categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CategoriaController {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/categorias")
    public String listarCategorias(Model modelo){
        List<Categoria> listaCategorias = categoriaRepository.findAll();
        modelo.addAttribute("listaCategorias",listaCategorias);
        return "categorias";
    }
    @GetMapping("categorias/nuevo")
    public String mostrarFormularioDeNuevaCategoria(Model modelo){
        modelo.addAttribute("categoria", new Categoria());
        return "categoria_formulario";
    }
    @PostMapping("categorias/guardar")
    public String guardarCategorias(Categoria categoria){
        categoriaRepository.save(categoria);
        return "redirect:/categorias";
    }
}

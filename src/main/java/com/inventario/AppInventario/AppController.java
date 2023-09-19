package com.inventario.AppInventario;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    @GetMapping("")
    public String verPaginadeInicio() {
        return "index";
    }
    @GetMapping("/Home")
    public String verPaginadeHome() {
        return "index";
    }

}





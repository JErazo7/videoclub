package com.certificacion.videoclub.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pelicula")

public class peliculaController {

    @RequestMapping("/")
    String index(Model m){
        m.addAttribute("route","pelicula/list");
        return "index";
    }
}

package com.certificacion.videoclub.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sexo")
public class sexoController {

    @RequestMapping("/")
    String index(Model m){
        m.addAttribute("route","sexo/list");
        return "index";
    }
}

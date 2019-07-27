package com.certificacion.videoclub.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/actorpelicula")
public class actorPelController {

    @RequestMapping("/")
    String index(Model m){
        m.addAttribute("route","actorpelicula/list");
        return "index";
    }
}

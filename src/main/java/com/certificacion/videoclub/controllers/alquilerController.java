package com.certificacion.videoclub.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alquiler")
public class alquilerController {

    @RequestMapping("/")
    String index(Model m){
        m.addAttribute("route","alquiler/list");
        return "index";
    }

    @RequestMapping("/new")
    String nuevo(Model m){

        return "alquiler/nuevo";
    }
}


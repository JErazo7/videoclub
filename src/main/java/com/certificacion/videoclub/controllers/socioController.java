package com.certificacion.videoclub.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/socio")
public class socioController {

    @RequestMapping("/")
    String index(Model m){
        m.addAttribute("route","socio/list");
        return "index";
    }
}

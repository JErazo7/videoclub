package com.certificacion.videoclub.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/formato")
public class formatoController {

    @RequestMapping("/")
    String index(Model m){
        m.addAttribute("route","formato/list");
        return "index";
    }
}

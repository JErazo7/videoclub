package com.certificacion.videoclub.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/actor")
public class actorController {

    @RequestMapping("/")
    String index(Model m){
        m.addAttribute("route","actor/list");
        return "index";
    }
}

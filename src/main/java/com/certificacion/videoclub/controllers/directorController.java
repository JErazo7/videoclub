package com.certificacion.videoclub.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/director")
public class directorController {

    @RequestMapping("/")
    String index(Model m){
        m.addAttribute("route","director/list");
        return "index";
    }
}

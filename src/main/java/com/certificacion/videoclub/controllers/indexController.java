package com.certificacion.videoclub.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {
    @RequestMapping("/")
    String index(Model m){
        m.addAttribute("route","dashboard");
        return "index";
    }

}



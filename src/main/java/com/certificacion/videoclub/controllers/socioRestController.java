package com.certificacion.videoclub.controllers;

import com.certificacion.videoclub.controllers.json.SocioRequestWrapper;
import com.certificacion.videoclub.controllers.json.SocioResponseWrapper;
import com.certificacion.videoclub.models.entities.Socio;
import com.certificacion.videoclub.models.services.SocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/socio")
public class socioRestController {



    @Autowired
    private SocioService socioService;


    @GetMapping("/list")
    public List<Socio> getAllSocios(){
        return socioService.getAllSocios();
    }

    @GetMapping("/view/{id}")
    public Socio getSocioById(@PathVariable("id") String id){
        return socioService.findUserByCedula(id);
    }

    @PostMapping(value = "/service", produces = "application/json")
    public SocioResponseWrapper cudSocio(@RequestBody SocioRequestWrapper wrapperObj){

        String action = wrapperObj.getAction();
        Collection<Socio> data = wrapperObj.getData().values();
        SocioResponseWrapper response = new SocioResponseWrapper();

        Iterator<Socio> iterator = data.iterator();
        while (iterator.hasNext()){
            Socio socio = iterator.next();
            switch (action){
                case "create":
                case "edit": {
                    socioService.saveSocio(socio);
                    response.getData().add(socio);
                    break;
                }
                case "remove":{
                    socioService.removeSocio(socio.getId());
                    break;
                }
            }
        }
        return response;
    }
}

package com.certificacion.videoclub.controllers;

import com.certificacion.videoclub.controllers.json.SexoRequestWrapper;
import com.certificacion.videoclub.controllers.json.SexoResponseWrapper;
import com.certificacion.videoclub.models.entities.Sexo;
import com.certificacion.videoclub.models.services.SexoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/sexo")
public class sexoRestController {

    @Autowired
    private SexoService service;




    @GetMapping("/list")
    public List<Sexo> getAllSexos(){
        return service.getAllSexos();

    }

    @GetMapping("/getone/{id}")
    public Sexo getSexoById(@PathVariable("id") long id){
        return service.getSexoById(id);
    }

    @PostMapping(value = "/service", produces = "application/json")
    public SexoResponseWrapper cudSexo(@RequestBody SexoRequestWrapper wrapperObj){

        String action = wrapperObj.action;
        Collection<Sexo> data = wrapperObj.data.values();
        SexoResponseWrapper response = new SexoResponseWrapper();

        Iterator<Sexo> iterator = data.iterator();
        while (iterator.hasNext()){
            Sexo itr = iterator.next();
            switch (action){
                case "create":
                case "edit": {
                    service.saveSexo(itr);
                    response.data.add(itr);
                    break;
                }
                case "remove":{
                    service.removeSexo(itr.getId());
                    break;
                }
            }
        }
        return response;
    }
}

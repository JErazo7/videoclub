package com.certificacion.videoclub.controllers;

import com.certificacion.videoclub.controllers.json.ActorRequestWrapper;
import com.certificacion.videoclub.controllers.json.ActorResponseWrapper;
import com.certificacion.videoclub.models.entities.Actor;
import com.certificacion.videoclub.models.entities.Sexo;
import com.certificacion.videoclub.models.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/actor")
public class actorRestController {

    @Autowired
    private ActorService service;

    @Autowired
    private SexoService sexoservice;



    @GetMapping("/list")
    public List<Actor> getAllActores(){
        return service.getAllActores();

    }

    @GetMapping("/view/{id}")
    public Actor getActorById(@PathVariable("id") long id){
        return service.getActorById(id);
    }

    @PostMapping(value = "/service", produces = "application/json")
    public ActorResponseWrapper cudActor(@RequestBody ActorRequestWrapper wrapperObj){

        String action = wrapperObj.action;
        Collection<Actor> data = wrapperObj.data.values();
        ActorResponseWrapper response = new ActorResponseWrapper();

        Iterator<Actor> iterator = data.iterator();
        while (iterator.hasNext()){
            Actor itr = iterator.next();
            switch (action){
                case "create":
                case "edit": {
                    //1
                    Sexo sexo = sexoservice.getSexoById(itr.getSexo().getId());
                    itr.getSexo().setNombre(sexo.getNombre());
                    service.saveActor(itr);
                    response.data.add(itr);
                    break;
                }
                case "remove":{
                    service.removeActor(itr.getId());
                    break;
                }
            }
        }
        return response;
    }
}

package com.certificacion.videoclub.controllers;

import com.certificacion.videoclub.controllers.json.ActorPelRequestWrapper;
import com.certificacion.videoclub.controllers.json.ActorPelResponseWrapper;
import com.certificacion.videoclub.controllers.json.AlquilerRequestWrapper;
import com.certificacion.videoclub.controllers.json.AlquilerResponseWrapper;
import com.certificacion.videoclub.models.entities.ActorPelicula;
import com.certificacion.videoclub.models.entities.Alquiler;
import com.certificacion.videoclub.models.entities.Pelicula;
import com.certificacion.videoclub.models.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/actorpelicula")
public class actorPelRestController {

    @Autowired
    private ActorPeliculaService service;

    @Autowired
    private ActorService actser;

    @Autowired
    private PeliculaService pelser;




    @GetMapping("/list")
    public List<ActorPelicula> getAllActoresPeliculas(){
        return service.getAllActoresPeliculas();

    }

    @GetMapping("/view/{id}")
    public ActorPelicula getActoresPeliculasById(@PathVariable("id") long id){
        return service.getActorPeliculaById(id);
    }

    @PostMapping(value = "/service", produces = "application/json")
    public ActorPelResponseWrapper cudAlquiler(@RequestBody ActorPelRequestWrapper wrapperObj){

        String action = wrapperObj.action;
        Collection<ActorPelicula> data = wrapperObj.data.values();
        ActorPelResponseWrapper response = new ActorPelResponseWrapper();

        Iterator<ActorPelicula> iterator = data.iterator();
        while (iterator.hasNext()){
            ActorPelicula itr = iterator.next();
            switch (action){
                case "create":
                case "edit": {
                    //1
                    itr.setActor(actser.getActorById(itr.getActor().getId()));

                    //2
                    Pelicula pel = pelser.getPeliculaById(itr.getPelicula().getId());
                    itr.getPelicula().setNombre(pel.getNombre());

                    service.saveActorPelicula(itr);
                    response.data.add(itr);
                    break;
                }
                case "remove":{
                    service.removeActorPelicula(itr.getId());
                    break;
                }
            }
        }
        return response;
    }
}

package com.certificacion.videoclub.controllers;

import com.certificacion.videoclub.controllers.json.GeneroRequestWrapper;
import com.certificacion.videoclub.controllers.json.GeneroResponseWrapper;
import com.certificacion.videoclub.controllers.json.SexoRequestWrapper;
import com.certificacion.videoclub.controllers.json.SexoResponseWrapper;
import com.certificacion.videoclub.models.entities.Genero;
import com.certificacion.videoclub.models.entities.Sexo;
import com.certificacion.videoclub.models.services.GeneroService;
import com.certificacion.videoclub.models.services.SexoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/genero")
public class generoRestController {

    @Autowired
    private GeneroService service;




    @GetMapping("/list")
    public List<Genero> getAllGeneros(){
        return service.getAllGeneros();

    }

    @GetMapping("/getone/{id}")
    public Genero getGeneroById(@PathVariable("id") long id){
        return service.getGeneroById(id);
    }

    @PostMapping(value = "/service", produces = "application/json")
    public GeneroResponseWrapper cudGenero(@RequestBody GeneroRequestWrapper wrapperObj){

        String action = wrapperObj.action;
        Collection<Genero> data = wrapperObj.data.values();
        GeneroResponseWrapper response = new GeneroResponseWrapper();

        Iterator<Genero> iterator = data.iterator();
        while (iterator.hasNext()){
            Genero itr = iterator.next();
            switch (action){
                case "create":
                case "edit": {
                    service.saveGenero(itr);
                    response.data.add(itr);
                    break;
                }
                case "remove":{
                    service.removeGenero(itr.getId());
                    break;
                }
            }
        }
        return response;
    }
}

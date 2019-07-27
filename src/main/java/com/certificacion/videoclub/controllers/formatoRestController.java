package com.certificacion.videoclub.controllers;

import com.certificacion.videoclub.controllers.json.FormatoRequestWrapper;
import com.certificacion.videoclub.controllers.json.FormatoResponseWrapper;
import com.certificacion.videoclub.controllers.json.SexoRequestWrapper;
import com.certificacion.videoclub.controllers.json.SexoResponseWrapper;
import com.certificacion.videoclub.models.entities.Formato;
import com.certificacion.videoclub.models.services.FormatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/formato")
public class formatoRestController {

    @Autowired
    private FormatoService service;




    @GetMapping("/list")
    public List<Formato> getAllFormatos(){
        return service.getAllFormatos();

    }

    @GetMapping("/getone/{id}")
    public Formato getFormatoById(@PathVariable("id") long id){
        return service.getFormatoById(id);
    }

    @PostMapping(value = "/service", produces = "application/json")
    public FormatoResponseWrapper cudFormato(@RequestBody FormatoRequestWrapper wrapperObj){

        String action = wrapperObj.action;
        Collection<Formato> data = wrapperObj.data.values();
        FormatoResponseWrapper response = new FormatoResponseWrapper();

        Iterator<Formato> iterator = data.iterator();
        while (iterator.hasNext()){
            Formato itr = iterator.next();
            switch (action){
                case "create":
                case "edit": {
                    service.saveFormato(itr);
                    response.data.add(itr);
                    break;
                }
                case "remove":{
                    service.removeFormato(itr.getId());
                    break;
                }
            }
        }
        return response;
    }
}

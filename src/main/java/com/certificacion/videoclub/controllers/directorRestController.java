package com.certificacion.videoclub.controllers;

import com.certificacion.videoclub.controllers.json.DirectorRequestWrapper;
import com.certificacion.videoclub.controllers.json.DirectorResponseWrapper;
import com.certificacion.videoclub.models.entities.Director;
import com.certificacion.videoclub.models.services.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/director")
public class directorRestController {

    @Autowired
    private DirectorService service;




    @GetMapping("/list")
    public List<Director> getAllDirectores(){
        return service.getAllDirectores();

    }

    @GetMapping("/getone/{id}")
    public Director getDirectorById(@PathVariable("id") long id){
        return service.getDirectorById(id);
    }

    @PostMapping(value = "/service", produces = "application/json")
    public DirectorResponseWrapper cudDirector(@RequestBody DirectorRequestWrapper wrapperObj){

        String action = wrapperObj.action;
        Collection<Director> data = wrapperObj.data.values();
        DirectorResponseWrapper response = new DirectorResponseWrapper();

        Iterator<Director> iterator = data.iterator();
        while (iterator.hasNext()){
            Director itr = iterator.next();
            switch (action){
                case "create":
                case "edit": {
                    service.saveDirector(itr);
                    response.data.add(itr);
                    break;
                }
                case "remove":{
                    service.removeDirector(itr.getId());
                    break;
                }
            }
        }
        return response;
    }
}

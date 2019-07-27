package com.certificacion.videoclub.controllers;

import com.certificacion.videoclub.controllers.json.PeliculaRequestWrapper;
import com.certificacion.videoclub.controllers.json.PeliculaResponseWrapper;
import com.certificacion.videoclub.models.entities.Director;
import com.certificacion.videoclub.models.entities.Formato;
import com.certificacion.videoclub.models.entities.Genero;
import com.certificacion.videoclub.models.entities.Pelicula;
import com.certificacion.videoclub.models.services.DirectorService;
import com.certificacion.videoclub.models.services.FormatoService;
import com.certificacion.videoclub.models.services.GeneroService;
import com.certificacion.videoclub.models.services.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/pelicula")
public class peliculaRestController {

    @Autowired
    private PeliculaService service;
    @Autowired
    private GeneroService generoservice;
    @Autowired
    private DirectorService directorservice;
    @Autowired
    private FormatoService formatoservice;


    @GetMapping("/list")
    public List<Pelicula> getAllPeliculas() {
        return service.getAllPeliculas();

    }

    @GetMapping("/view/{id}")
    public Pelicula getPeliculaById(@PathVariable("id") long id) {
        return service.getPeliculaById(id);
    }

    @PostMapping(value = "/service", produces = "application/json")
    public PeliculaResponseWrapper cudPelicula(@RequestBody PeliculaRequestWrapper wrapperObj) {

        String action = wrapperObj.action;
        Collection<Pelicula> data = wrapperObj.data.values();
        PeliculaResponseWrapper response = new PeliculaResponseWrapper();

        Iterator<Pelicula> iterator = data.iterator();
        while (iterator.hasNext()) {
            Pelicula itr = iterator.next();
            switch (action) {
                case "create":
                case "edit": {
                    //Genero
                    Genero gen = generoservice.getGeneroById(itr.getGenero().getId());
                    itr.getGenero().setNombre(gen.getNombre());
                    //Director
                    Director dir = directorservice.getDirectorById(itr.getDirector().getId());
                    itr.getDirector().setNombre(dir.getNombre());
                    //Formato
                    Formato formato = formatoservice.getFormatoById(itr.getFormato().getId());
                    itr.getFormato().setNombre(formato.getNombre());

                    service.savePelicula(itr);
                    response.data.add(itr);
                    break;
                }
                case "remove": {
                    service.removePelicula(itr.getId());
                    break;
                }
            }
        }
        return response;
    }
}

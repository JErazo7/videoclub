package com.certificacion.videoclub.controllers;

import com.certificacion.videoclub.controllers.json.AlquilerRequestWrapper;
import com.certificacion.videoclub.controllers.json.AlquilerResponseWrapper;
import com.certificacion.videoclub.controllers.json.SocAlqRequestWrapper;
import com.certificacion.videoclub.models.entities.Alquiler;
import com.certificacion.videoclub.models.entities.Pelicula;
import com.certificacion.videoclub.models.entities.Socio;
import com.certificacion.videoclub.models.services.AlquilerService;
import com.certificacion.videoclub.models.services.PeliculaService;
import com.certificacion.videoclub.models.services.SocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/alquiler")
public class alquilerRestController {

    @Autowired
    private AlquilerService service;

    @Autowired
    private PeliculaService pelser;

    @Autowired
    private SocioService socser;


    @GetMapping("/list")
    public List<Alquiler> getAllAlquileres() {
        return service.getAllAlquileres();

    }

    @GetMapping("/esta")
    public String getEsta() {
        return "[0, 800000, 5000, 15000, 10000, 20000, 15000, 25000, 20000, 30000, 25000, 40000]";
    }

    @GetMapping("/anual")
    public Double getsum() {
        return service.getsum();
    }

    @GetMapping("/mensual")
    public double[] getDatosTabla() {
        return service.getDatosTabla();

    }


    @GetMapping("/view/{id}")
    public Alquiler getAlquilerById(@PathVariable("id") long id) {
        return service.getAlquilerById(id);
    }

    @PostMapping(value = "/service", produces = "application/json")
    public AlquilerResponseWrapper cudAlquiler(@RequestBody AlquilerRequestWrapper wrapperObj) {

        String action = wrapperObj.action;
        Collection<Alquiler> data = wrapperObj.data.values();
        AlquilerResponseWrapper response = new AlquilerResponseWrapper();

        Iterator<Alquiler> iterator = data.iterator();
        Iterator<Alquiler> iterator1 = data.iterator();

        if(action.equals("create")){
            Alquiler alq = iterator1.next();
            if(alq.getSocio().getId()==0){
                socser.saveSocio(alq.getSocio());
            }
        }



        while (iterator.hasNext()) {
            Alquiler itr = iterator.next();
            switch (action) {
                case "create":
                case "edit": {
                    //1
                    //itr.setSocio(socser.findUserByCedula(itr.getSocio().getCedula()));
                    if (action.equals("create")){
                        itr.setSocio(socser.findUserByCedula(itr.getSocio().getCedula()));
                    }else{
                        itr.setSocio(socser.getSocioById(itr.getSocio().getId()));
                    }



                    //2
                    Pelicula pel = pelser.getPeliculaById(itr.getPelicula().getId());
                    itr.getPelicula().setNombre(pel.getNombre());

                    service.saveAlquiler(itr);
                    response.data.add(itr);
                    break;
                }
                case "remove": {
                    service.removeAlquiler(itr.getId());
                    break;
                }
            }
        }
        return response;
    }

    @PostMapping(value = "/add", produces = "application/json")
    public AlquilerResponseWrapper addAlquiler(@RequestBody AlquilerRequestWrapper wrapperObj) {



        AlquilerResponseWrapper res = new AlquilerResponseWrapper();
        return res;
    }
}

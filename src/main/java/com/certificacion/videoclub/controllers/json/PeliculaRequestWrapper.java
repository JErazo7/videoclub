package com.certificacion.videoclub.controllers.json;

import com.certificacion.videoclub.models.entities.Pelicula;
import com.certificacion.videoclub.models.entities.Sexo;

import java.util.LinkedHashMap;

public class PeliculaRequestWrapper {
    public String action;
    public LinkedHashMap<String, Pelicula> data;
}

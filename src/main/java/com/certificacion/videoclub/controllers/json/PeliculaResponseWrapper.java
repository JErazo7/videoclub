package com.certificacion.videoclub.controllers.json;


import com.certificacion.videoclub.models.entities.Pelicula;
import com.certificacion.videoclub.models.entities.Sexo;

import java.util.ArrayList;

public class PeliculaResponseWrapper {
    public ArrayList<Pelicula> data = new ArrayList<Pelicula>();
    public ArrayList<FieldErrors> fieldErrors = new ArrayList<FieldErrors>();

}

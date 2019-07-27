package com.certificacion.videoclub.controllers.json;


import com.certificacion.videoclub.models.entities.ActorPelicula;
import com.certificacion.videoclub.models.entities.Alquiler;

import java.util.ArrayList;

public class ActorPelResponseWrapper {
    public ArrayList<ActorPelicula> data = new ArrayList<ActorPelicula>();
    public ArrayList<FieldErrors> fieldErrors = new ArrayList<FieldErrors>();
}

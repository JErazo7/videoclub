package com.certificacion.videoclub.controllers.json;

import com.certificacion.videoclub.models.entities.ActorPelicula;

import java.util.LinkedHashMap;

public class ActorPelRequestWrapper {
    public String action;
    public LinkedHashMap<String, ActorPelicula> data;
}

package com.certificacion.videoclub.controllers.json;

import com.certificacion.videoclub.models.entities.Genero;

import java.util.LinkedHashMap;

public class GeneroRequestWrapper {
    public String action;
    public LinkedHashMap<String, Genero> data;
}

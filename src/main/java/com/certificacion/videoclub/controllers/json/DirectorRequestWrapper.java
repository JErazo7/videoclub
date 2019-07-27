package com.certificacion.videoclub.controllers.json;

import com.certificacion.videoclub.models.entities.Director;
import com.certificacion.videoclub.models.entities.Sexo;

import java.util.LinkedHashMap;

public class DirectorRequestWrapper {
    public String action;
    public LinkedHashMap<String, Director> data;
}

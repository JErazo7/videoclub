package com.certificacion.videoclub.controllers.json;

import com.certificacion.videoclub.models.entities.Sexo;

import java.util.LinkedHashMap;

public class SexoRequestWrapper {
    public String action;
    public LinkedHashMap<String, Sexo> data;
}

package com.certificacion.videoclub.controllers.json;

import com.certificacion.videoclub.models.entities.Formato;

import java.util.LinkedHashMap;

public class FormatoRequestWrapper {
    public String action;
    public LinkedHashMap<String, Formato> data;
}

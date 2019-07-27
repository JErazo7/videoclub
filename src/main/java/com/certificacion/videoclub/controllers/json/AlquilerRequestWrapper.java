package com.certificacion.videoclub.controllers.json;

import com.certificacion.videoclub.models.entities.Alquiler;

import java.util.LinkedHashMap;

public class AlquilerRequestWrapper {
    public String action;
    public LinkedHashMap<String, Alquiler> data;
}

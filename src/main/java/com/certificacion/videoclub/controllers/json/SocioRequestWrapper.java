package com.certificacion.videoclub.controllers.json;

import com.certificacion.videoclub.models.entities.Socio;

import java.util.LinkedHashMap;

public class SocioRequestWrapper {
    private String action;
    private LinkedHashMap<String, Socio> data;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public LinkedHashMap<String, Socio> getData() {
        return data;
    }

    public void setData(LinkedHashMap<String, Socio> data) {
        this.data = data;
    }
}

package com.certificacion.videoclub.controllers.json;


import com.certificacion.videoclub.models.entities.Socio;

import java.util.ArrayList;

public class SocAlquResponseWrapper {
    private ArrayList<Socio> data = new ArrayList<Socio>();

    private ArrayList<FieldErrors> fieldErrors = new ArrayList<FieldErrors>();

    public SocAlquResponseWrapper() {
    }

    public ArrayList<Socio> getData() {
        return data;
    }

    public void setData(ArrayList<Socio> data) {
        this.data = data;
    }

    public ArrayList<FieldErrors> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(ArrayList<FieldErrors> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }
}

package com.certificacion.videoclub.controllers.json;


import com.certificacion.videoclub.models.entities.Formato;

import java.util.ArrayList;

public class FormatoResponseWrapper {
    public ArrayList<Formato> data = new ArrayList<Formato>();

    public ArrayList<FieldErrors> fieldErrors = new ArrayList<FieldErrors>();

}

package com.certificacion.videoclub.controllers.json;


import com.certificacion.videoclub.models.entities.Genero;

import java.util.ArrayList;

public class GeneroResponseWrapper {
    public ArrayList<Genero> data = new ArrayList<Genero>();

    public ArrayList<FieldErrors> fieldErrors = new ArrayList<FieldErrors>();

}

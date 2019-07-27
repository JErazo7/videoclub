package com.certificacion.videoclub.controllers.json;


import com.certificacion.videoclub.models.entities.Sexo;
import com.certificacion.videoclub.models.entities.Socio;

import java.util.ArrayList;

public class SexoResponseWrapper {
    public ArrayList<Sexo> data = new ArrayList<Sexo>();

    public ArrayList<FieldErrors> fieldErrors = new ArrayList<FieldErrors>();

}

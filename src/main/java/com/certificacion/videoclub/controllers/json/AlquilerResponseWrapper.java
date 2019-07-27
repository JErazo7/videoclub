package com.certificacion.videoclub.controllers.json;


import com.certificacion.videoclub.models.entities.Alquiler;

import java.util.ArrayList;

public class AlquilerResponseWrapper {
    public ArrayList<Alquiler> data = new ArrayList<Alquiler>();
    public ArrayList<FieldErrors> fieldErrors = new ArrayList<FieldErrors>();
}

package com.certificacion.videoclub.controllers.json;


import com.certificacion.videoclub.models.entities.Director;


import java.util.ArrayList;

public class DirectorResponseWrapper {
    public ArrayList<Director> data = new ArrayList<Director>();

    public ArrayList<FieldErrors> fieldErrors = new ArrayList<FieldErrors>();

}

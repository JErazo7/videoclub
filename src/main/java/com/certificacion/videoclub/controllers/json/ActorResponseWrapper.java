package com.certificacion.videoclub.controllers.json;


import com.certificacion.videoclub.models.entities.Actor;

import java.util.ArrayList;

public class ActorResponseWrapper {
    public ArrayList<Actor> data = new ArrayList<Actor>();
    public ArrayList<FieldErrors> fieldErrors = new ArrayList<FieldErrors>();
}

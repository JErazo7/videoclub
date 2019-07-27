package com.certificacion.videoclub.controllers.json;

import com.certificacion.videoclub.models.entities.Actor;

import java.util.LinkedHashMap;

public class ActorRequestWrapper {
    public String action;
    public LinkedHashMap<String, Actor> data;
}

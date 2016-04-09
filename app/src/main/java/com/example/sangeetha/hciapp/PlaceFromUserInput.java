package com.example.sangeetha.hciapp;

import com.google.api.client.util.Key;

import java.io.Serializable;

/**
 * Created by sangeetha on 4/9/16.
 */
public class PlaceFromUserInput implements Serializable {

    @Key
    public Geometry geometry;

    public static class Geometry implements Serializable
    {
        @Key
        public Location location;
    }

    public static class Location implements Serializable
    {
        @Key
        public double lat;

        @Key
        public double lng;
    }
}

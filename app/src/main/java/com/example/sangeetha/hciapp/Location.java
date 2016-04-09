package com.example.sangeetha.hciapp;

import com.google.api.client.util.Key;

/**
 * Created by sangeetha on 4/9/16.
 */
public class Location {
    @Key
    private double lng;
    @Key
    private double lat;

    public double getLng ()
    {
        return lng;
    }

    public void setLng (double lng)
    {
        this.lng = lng;
    }

    public double getLat ()
    {
        return lat;
    }

    public void setLat (double lat)
    {
        this.lat = lat;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [lng = "+lng+", lat = "+lat+"]";
    }
}

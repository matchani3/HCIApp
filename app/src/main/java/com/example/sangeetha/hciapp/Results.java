package com.example.sangeetha.hciapp;

import com.google.api.client.util.Key;

import java.io.Serializable;

/**
 * Created by sangeetha on 4/9/16.
 */
public class Results implements Serializable{
    @Key
    private String place_id;

//    private Address_components[] address_components;
    @Key
    private String[] postcode_localities;
    @Key
    private String formatted_address;
    @Key
    private String[] types;

    @Key
    private Geometry geometry;

    public String getPlace_id ()
    {
        return place_id;
    }

    public void setPlace_id (String place_id)
    {
        this.place_id = place_id;
    }

//    public Address_components[] getAddress_components ()
//    {
//        return address_components;
//    }

//    public void setAddress_components (Address_components[] address_components)
//    {
//        this.address_components = address_components;
//    }

    public String[] getPostcode_localities ()
    {
        return postcode_localities;
    }

    public void setPostcode_localities (String[] postcode_localities)
    {
        this.postcode_localities = postcode_localities;
    }

    public String getFormatted_address ()
    {
        return formatted_address;
    }

    public void setFormatted_address (String formatted_address)
    {
        this.formatted_address = formatted_address;
    }

    public String[] getTypes ()
    {
        return types;
    }

    public void setTypes (String[] types)
    {
        this.types = types;
    }

    public Geometry getGeometry ()
    {
        return geometry;
    }

    public void setGeometry (Geometry geometry)
    {
        this.geometry = geometry;
    }

//    @Override
//    public String toString()
//    {
//        return "ClassPojo [place_id = "+place_id+", address_components = "+address_components+", postcode_localities = "+postcode_localities+", formatted_address = "+formatted_address+", types = "+types+", geometry = "+geometry+"]";
//    }
}

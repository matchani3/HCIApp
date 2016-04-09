package com.example.sangeetha.hciapp;

import com.google.api.client.util.Key;

import java.io.Serializable;

/**
 * Created by sangeetha on 4/9/16.
 */
public class LocationFromUserInput implements Serializable {

    @Key
    public String status;

    @Key
    public ResultFromUserInput result;

    @Override
    public String toString() {
        if (result!=null) {
            return result.toString();
        }
        return super.toString();
    }
}

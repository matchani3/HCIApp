package com.example.sangeetha.hciapp;

import com.google.api.client.util.Key;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sangeetha on 4/9/16.
 */
public class ResultFromUserInput implements Serializable{

    @Key
    public List<Results> results;

    @Key
    public String status;


//    public Results[] getResults ()
//    {
//        return results;
//    }
//
//    public void setResults (Results[] results)
//    {
//        this.results = results;
//    }
//
//    public String getStatus ()
//    {
//        return status;
//    }
//
//    public void setStatus (String status)
//    {
//        this.status = status;
//    }
//
//    @Override
//    public String toString()
//    {
//        return "ClassPojo [results = "+results+", status = "+status+"]";
//    }
}

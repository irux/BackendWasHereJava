/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services.backendwashere;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.pojos.backendwashere.PlacePojo;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.parser.JSONParser;
import okhttp3.*;

/**
 *
 * @author Alejandro Jaramillo
 */
public class ReverseGeolocationService {

    public ReverseGeolocationService() {
    
        
    
    }
    
    
    public String getReverseGoogleAPI(float longitude,float latitude)
    {
        
        String resultAddress = null;
         Response response = null;
        try {
            OkHttpClient client = new OkHttpClient();
        
            String url = "https://maps.googleapis.com/maps/api/geocode/json?latlng=" + latitude+"," + longitude + "&key=AIzaSyAvF8s-D-3K97jsgirefF0bo6YaNB26Fh4";
        Request request = new Request.Builder()
                
                .url(url)
                .build();

        response = client.newCall(request).execute();
        
        System.out.println("Response body : " + response.body().string());
        } catch (Exception e) {
            System.err.println("Error : " + e.getMessage());
            
        }
        
        
        
        if(response != null)
        {
        JsonParser parser = new JsonParser();
            
        JsonObject objectResult = null;
            try {
                objectResult = parser.parse(response.body().string()).getAsJsonObject();
            } catch (IOException ex) {
                System.err.println("Error : " + ex.getMessage());
            }
       
        JsonArray resultArray = objectResult.getAsJsonArray("results");
        
            System.out.println("Result Arrays as string : " + resultArray.toString());
        
        JsonObject resultFirst = resultArray.get(0).getAsJsonObject();
        
            System.out.println("resultfirst as array : " + resultFirst);
        
        resultAddress = resultFirst.get("formatted_address").getAsString();
        
        
            System.out.println("result Address : " + resultAddress);
        
        }
        return resultAddress;
    }
    
    public PlacePojo getReverseOpenStreetmap(float longitude,float latitude)
    {
        
        System.out.println("Longitude : " + longitude);
        System.out.println("latitude : " + latitude);
        
        Gson gsonBuilder = new Gson();
        
        Response response = null;
        try {
            OkHttpClient client = new OkHttpClient();
        
        Request request = new Request.Builder()
                .url("http://nominatim.openstreetmap.org/reverse?lat=" + latitude + "&lon=" + longitude + "&format=json&zoom=18&namedetails=1")
                .build();

        response = client.newCall(request).execute();
        } catch (Exception e) {
            System.err.println("Error : " + e.getMessage());
            
        }
        
        System.out.println("response value : " + response);
        
        if(response != null)
        {
        PlacePojo place = null;
            try {
                System.out.println("response.body : " + response.body().string());
                place = gsonBuilder.fromJson(response.body().string(), PlacePojo.class);
                System.out.println("I am already hier");
            } catch (IOException ex) {
                System.err.println("Error : " + ex.getMessage());
            }
        return place;
        }
        
        return null;
        
    }
    
    
    
}

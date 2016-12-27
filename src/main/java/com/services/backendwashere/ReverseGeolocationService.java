/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services.backendwashere;

import com.google.gson.Gson;
import com.pojos.backendwashere.PlacePojo;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.*;

/**
 *
 * @author Alejandro Jaramillo
 */
public class ReverseGeolocationService {

    public ReverseGeolocationService() {
    
        
    
    }
    
    public PlacePojo getReverse(float longitude,float latitude)
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

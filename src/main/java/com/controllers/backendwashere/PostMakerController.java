/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers.backendwashere;

import com.google.gson.Gson;
import com.pojos.backendwashere.PostPojo;
import com.services.backendwashere.PostService;
import spark.Route;

/**
 *
 * @author Alejandro Jaramillo
 */
public class PostMakerController {
    
    public static Route makePost()
    {
        
        
        Route postRoute = (request,response) -> {
            
            /*
            Gson gsonBuilder = new Gson();
            
            PostPojo post = gsonBuilder.fromJson(request.body(), PostPojo.class);
            
            PostService servicePostMaker = new PostService();
            
            servicePostMaker.saveIt(post);
            
            */            
            
            
            
            return request.body();
        };      
        
        return postRoute;
    }
    
    
}

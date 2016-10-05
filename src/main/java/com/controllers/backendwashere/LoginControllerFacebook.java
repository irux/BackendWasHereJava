/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers.backendwashere;

import com.google.gson.Gson;
import com.pojos.backendwashere.FacebookToken;
import spark.Route;



/**
 *
 * @author Alejo
 */
public class LoginControllerFacebook {
    
    
    public static Route login()
    {
        
        Route loginFacebook = (request,response) -> {
            
            
            Gson gsonObject = new Gson();
            
            FacebookToken tokenFront = gsonObject.fromJson(request.body(), FacebookToken.class);
            
            
            
            return "{token:E3fg3rfWFF3g3gtr4g4tergfregr3gtg}";
            
           
          
          
        };
        
        
        return loginFacebook;
    }
    
    
}

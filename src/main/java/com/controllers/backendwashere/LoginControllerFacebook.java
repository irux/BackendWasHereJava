/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers.backendwashere;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.interfaces.backendwashere.LoginServiceToken;
import com.pojos.backendwashere.FacebookToken;
import com.services.backendwashere.FacebookLoginService;
import spark.Route;



/**
 *
 * @author Alejo
 */
public class LoginControllerFacebook  {
    
    
    public static Route login(LoginServiceToken loginService)
    {
        
        Route loginFacebook = (request,response) -> {
            
            
            String tokenFromCliente = request.body();
            
           boolean successful = loginService.login(tokenFromCliente);
            
           
           if(successful)
           {
               
               
               
               
               
               return loginService.getServiceToken();
           }
           else
           {
               return "Error with login Facebook";
           }
            
                      
        };
        
        
        return loginFacebook;
    }
    
    
}

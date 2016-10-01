/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers.backendwashere;

import spark.Route;

/**
 *
 * @author Alejo
 */
public class LoginControllerFacebook {
    
    
    public static Route login()
    {
        
        Route loginFacebook = (request,response) -> {
            
            
          return "Here is your Input : " + request.body(); 
          
          
        };
        
        
        return loginFacebook;
    }
    
    
}

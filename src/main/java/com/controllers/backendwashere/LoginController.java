/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers.backendwashere;


import com.interfaces.backendwashere.LoginService;
import com.services.backendwashere.InstagramLoginService;
import org.javalite.activejdbc.Base;
import org.jinstagram.auth.model.Verifier;
import org.jinstagram.auth.oauth.InstagramService;
import spark.Route;

/**
 *
 * @author Alejo
 */
public class LoginController {
    
    

    
    public static Route login(LoginService service)
    {
        
        Route doLogin = (req,resp) -> {
        
        String urlLogin =  service.login(null);
        
        return urlLogin;
        
        };
        
        
        return doLogin;
    }
    
    
    public static Route tokenManagment()
    {
        Route tokenManager = (req,resp) -> {
            
            InstagramLoginService service = new InstagramLoginService();
            
            
            
           String token = req.queryParams("code");
            
           service.setToken(token);
           
           
            
            return "Your token code is : " + req.queryParams("code") + " and your user name is : " + service.getUser() ;
            
        };
        
        return tokenManager;
    }
    
    }
    
    
    


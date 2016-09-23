/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers.backendwashere;

import com.services.backendwashere.LoginService;
import spark.Route;

/**
 *
 * @author Alejo
 */
public class LoginController {
    
    
    public static Route login(LoginService service)
    {
        
        Route doLogin = (req,resp) -> {
        
        return null;
        
        };
        
        
        return doLogin;
    }
    }
    
    
    


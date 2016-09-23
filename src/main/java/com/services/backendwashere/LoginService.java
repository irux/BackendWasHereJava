/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services.backendwashere;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 *
 * @author Alejandro
 */
public abstract class LoginService {
    
    
    
    public abstract void login();
    public abstract String getUser();
    public abstract String getServiceToken();
    public String getTokenLogin()
    {
        SignatureAlgorithm algorithmSign = SignatureAlgorithm.HS512;
        
     //String token =  Jwts.builder()
        
        return null;
    }
    
    
    
}

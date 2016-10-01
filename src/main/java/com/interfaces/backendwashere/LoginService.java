/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.interfaces.backendwashere;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 *
 * @author Alejandro
 */
public abstract class LoginService {
    
    
    protected String token;
    protected String url;
    
    
    public abstract String login();
    public abstract String getUser();
    public abstract String getServiceToken();
    public String getTokenLogin()
    {
        SignatureAlgorithm algorithmSign = SignatureAlgorithm.HS512;
        
     //String token =  Jwts.builder()
        
        return null;
    }
    
    public abstract void setToken(String token);
    
    
    
}

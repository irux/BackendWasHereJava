/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.interfaces.backendwashere;

import com.google.gson.JsonParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 *
 * @author Alejo
 */
public abstract class LoginServiceToken {
    protected String token;
    protected String url;
    
    protected Object userLastLoginInfo;
    public abstract boolean login(Object information);
    public abstract Object getLastUserLogin();
    public abstract Object getLastTokenLogin();
    public abstract String getServiceToken();
    public String getTokenLogin()
    {
        JsonParser parser = new JsonParser();
        
        SignatureAlgorithm algorithmSign = SignatureAlgorithm.HS512;
        
        
        
        return parser.parse("{token:dwewefWRGFWRFgregreg}").toString();
    }
    
    
    
    
}

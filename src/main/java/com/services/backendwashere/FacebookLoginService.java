/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services.backendwashere;

import com.google.gson.Gson;
import com.interfaces.backendwashere.LoginServiceToken;
import com.pojos.backendwashere.FacebookToken;

/**
 *
 * @author Alejo
 */
public class FacebookLoginService extends LoginServiceToken{

   
    
    @Override
    public void login(Object information) {
        
        String tokenEntrada = "";
        
         if(!(information instanceof String))
         {
             new RuntimeException("The Object hast to be a String");
         }
         else
         {
             tokenEntrada = (String)information;
         }
         
         Gson gsonObject = new Gson();
         
         FacebookToken token = gsonObject.fromJson(information.toString(), FacebookToken.class);
         
         System.out.println("Token : " + token.getFacebookToken());
         
         
         setToken(token.getFacebookToken());
         
         
         
    }

    @Override
    public String getUser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getServiceToken() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setToken(String token) {

        super.setToken(token);

    }
    
}

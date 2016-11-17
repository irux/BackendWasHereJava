/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services.backendwashere;

import com.google.gson.Gson;
import com.interfaces.backendwashere.LoginServiceToken;
import com.pojos.backendwashere.FacebookToken;
import com.restfb.DefaultFacebookClient;
import com.restfb.Version;
import com.restfb.types.User;
import com.restfb.Parameter;

/**
 *
 * @author Alejo
 */
public class FacebookLoginService extends LoginServiceToken{

   
    
    @Override
    public boolean login(Object information) {
        
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
         
         
         
         return compareDataWithToken(token);
         
         
         
    }



    @Override
    public String getServiceToken() {

        return super.token;

    }

   
    
    
    private boolean compareDataWithToken(FacebookToken entryToken)
    {
        try{
            System.out.println(entryToken.getFacebookToken());
            
        DefaultFacebookClient clientFB = new DefaultFacebookClient(entryToken.getFacebookToken(),Version.LATEST);
        
        User userInfoFB = clientFB.fetchObject("me",User.class,Parameter.with("fields","first_name,gender,locale,last_name,age_range,verified,picture"));
        
        System.out.println(userInfoFB.getId());
        
        if(entryToken.getUserID().equals(userInfoFB.getId()))
        {
            super.userLastLoginInfo = userInfoFB;
            super.token = entryToken.getFacebookToken();
            return true;
            
        }
        else
        {
            return false;
        }
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
            return false;
        }
            

        
    }

    @Override
    public Object getLastUserLogin() {

        return super.userLastLoginInfo;

    }

    @Override
    public Object getLastTokenLogin() {

        return super.token;

    }
    
}

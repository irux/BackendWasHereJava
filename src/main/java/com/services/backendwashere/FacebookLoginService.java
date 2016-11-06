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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
    
    private boolean compareDataWithToken(FacebookToken entryToken)
    {
        
        DefaultFacebookClient clientFB = new DefaultFacebookClient(entryToken.getFacebookToken(),Version.LATEST);
        
        User userInfoFB = clientFB.fetchObject("me",User.class);
        
        if(entryToken.equals(userInfoFB.getId()))
        {
            super.userLastLoginInfo = userInfoFB;
            return true;
            
        }
        else
        {
            return false;
        }
        
    }

    @Override
    public Object getLastUserLogin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getLastTokenLogin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services.backendwashere;

import com.interfaces.backendwashere.LoginService;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jinstagram.Instagram;
import org.jinstagram.auth.InstagramAuthService;
import org.jinstagram.auth.model.Token;
import org.jinstagram.auth.model.Verifier;
import org.jinstagram.auth.oauth.InstagramService;
import org.jinstagram.entity.users.basicinfo.UserInfo;
import org.jinstagram.exceptions.InstagramException;

/**
 *
 * @author Alejandro
 */
public class InstagramLoginService extends LoginService {

     private static InstagramService globalService = null;
     private Instagram instagramAccount;
    
    @Override
    public String login() {
        
      
        if(globalService == null){
        InstagramService serviceInstagram = new InstagramAuthService()
                .apiKey("53a4d1817a524046857f07694849f088")
                .apiSecret("65b3d26fc53e4e26a5f0d6b46b1c8f4c")
                .callback("http://127.0.0.1:8080/instagram/callback")
                .build();
        
        globalService = serviceInstagram;
        
        super.url = serviceInstagram.getAuthorizationUrl();
        
        return url;
        
        }
        
        else
        {
            return globalService.getAuthorizationUrl();
        }
        
        
        
        
        
    
    }
    
    

    @Override
    public String getServiceToken() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTokenLogin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getUser() {

        UserInfo user;
         try {
             user = instagramAccount.getCurrentUserInfo();
             return user.getData().getUsername();
         } catch (InstagramException ex) {
             Logger.getLogger(InstagramLoginService.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        return "ERROR";
    
    }

    @Override
    public void setToken(String token) {
        
        System.out.println("Hier ist the token " + token);
        System.out.println("Hier ist die variable : " + globalService);
        
        super.token = token;
    
        Verifier verifyToken = new Verifier(token);
        
        Token accesToken = globalService.getAccessToken(verifyToken);
        
        Instagram account = new Instagram(accesToken);
        
        instagramAccount = account;
        

        
    }
    
}

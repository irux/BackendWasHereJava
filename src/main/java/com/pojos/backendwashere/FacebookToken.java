/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pojos.backendwashere;

/**
 *
 * @author Alejo
 */
public class FacebookToken {
    
    
    private String facebookToken;
    private String userID;

    public FacebookToken(String facebookToken, String userID) {
        this.facebookToken = facebookToken;
        this.userID = userID;
    }

    public String getFacebookToken() {
        return facebookToken;
    }

    public String getUserID() {
        return userID;
    }
    
    
    
}

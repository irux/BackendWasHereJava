/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pojos.backendwashere;

/**
 *
 * @author Alejandro Jaramillo
 */
public class UserTokenAuth {
    
    
    private int userID;
    private String authToken;
    private int permision;

    public UserTokenAuth(int userID, String authToken, int permision) {
        this.userID = userID;
        this.authToken = authToken;
        this.permision = permision;
    }

    public String getAuthToken() {
        return authToken;
    }

    public int getPermision() {
        return permision;
    }

    public int getUserID() {
        return userID;
    }


    
    
    
    
}

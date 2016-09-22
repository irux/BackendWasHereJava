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
public class User {
    
    private String userFullname;
    private String user;
    private String token;
    private long id;
    private String profilePicture;
    private String email;

    public User(String userFullname, String user, String token, long id, String profilePicture) {
        this.userFullname = userFullname;
        this.user = user;
        this.token = token;
        this.id = id;
        this.profilePicture = profilePicture;
        this.email = email;
    }

    /**
     * @return the userFullname
     */
    public String getUserFullname() {
        return userFullname;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @return the profilePicture
     */
    public String getProfilePicture() {
        return profilePicture;
    }
    
    
    
    
}

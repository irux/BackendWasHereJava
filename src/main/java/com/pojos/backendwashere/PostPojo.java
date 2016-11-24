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
public class PostPojo {
    
    
    private String fileLocation;
    private int likes;
    private int index;
    private float latitude;
    private float longitude;
    private String timestamp;
    private long idFB;
    private int type;

    
    public PostPojo(long idFB,int likes, float latitude, float longitude,String timestamp, int type) {
        this.fileLocation = fileLocation;
        this.likes = likes;
        this.index = index;
        this.latitude = latitude;
        this.longitude = longitude;
        this.timestamp = timestamp;
        this.idFB = idFB;
        this.type = type;
    }
    
    
    
    
    
    

    public String getFileLocation() {
        return fileLocation;
    }

    public long getIdFB() {
        return idFB;
    }

    public int getIndex() {
        return index;
    }

    public float getLatitude() {
        return latitude;
    }

    public int getLikes() {
        return likes;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public int getType() {
        return type;
    }

    public float getLongitude() {
        return longitude;
    }
    
    
    
    
    
    
    
    
}

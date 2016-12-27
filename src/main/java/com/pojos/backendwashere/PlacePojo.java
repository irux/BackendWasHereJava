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
public class PlacePojo {
    
    private float lat;
    private float lon;
    private String display_name;
    private AddressPojo address;
    private NameDetailsPojo nameDetails;

    public PlacePojo() {
    }

    /**
     * @return the lat
     */
    public float getLat() {
        return lat;
    }

    /**
     * @return the lon
     */
    public float getLon() {
        return lon;
    }

    /**
     * @return the display_name
     */
    public String getDisplay_name() {
        return display_name;
    }

    /**
     * @return the address
     */
    public AddressPojo getAddress() {
        return address;
    }

    /**
     * @return the nameDetails
     */
    public NameDetailsPojo getNameDetails() {
        return nameDetails;
    }
    
    
    
    
    
    
    
}

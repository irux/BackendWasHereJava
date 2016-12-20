/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services.backendwashere;

import com.pojos.backendwashere.PostDB;
import com.pojos.backendwashere.PostPojo;
import org.javalite.activejdbc.Base;

/**
 *
 * @author Alejandro Jaramillo
 */
public class PostService {

    public PostService() {
    }
    
    
    public boolean saveIt(PostPojo post)
    {
        
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/washereDB", "root", "TUBerlin2016");

        
        PostDB dbPostConnection = new PostDB();
        
        try {
            
            dbPostConnection.set("idFB",post.getIdFB());
        dbPostConnection.set("latitude",post.getLatitude());
        dbPostConnection.set("longitude",post.getLatitude());
        dbPostConnection.set("type",post.getType());
        if(post.getFileLocation() != "")
        {
            dbPostConnection.set("fileLocation",post.getFileLocation());
        }
        dbPostConnection.saveIt();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        
       
        
        


        
        
        Base.close();
        
        
        return true;
        
    }
    
    
    
    
}

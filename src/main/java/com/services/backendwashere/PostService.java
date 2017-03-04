/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services.backendwashere;

import com.pojos.backendwashere.PostDB;
import com.pojos.backendwashere.PostPojo;
import java.util.List;
import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.LazyList;

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
        dbPostConnection.set("longitude",post.getLongitude());
        dbPostConnection.set("type",post.getType());
        dbPostConnection.set("place_name",post.getName());
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
    
    
    public String getPostByFBID(long id)
    {
        
        System.out.println("I Am Here -----");
         Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/washereDB", "root", "TUBerlin2016");
         
         LazyList<PostDB> listPost = PostDB.where("idFB = ?",id);
            
            String jsonAnswer = listPost.toJson(true);
            
            
            
                System.out.println("here is the answer : " + jsonAnswer);
                
                Base.close();
         
         return jsonAnswer;
         
    }
    
    
    
    public String getPostsByGPS(float longitude , float latitude)
    {
       Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/washereDB", "root", "TUBerlin2016");
       
        System.out.println("I am getpotsbygps");
        
        LazyList<PostDB> listOfFind = PostDB.findBySQL("SELECT * FROM `post` WHERE (type = 1 or type = 2) and (latitude BETWEEN " +  (latitude - 0.0005) + " and " + (latitude + 0.0005) + " ) and (longitude BETWEEN " + (longitude - 0.0005) + " and " + (longitude + 0.0005) + ")");
        
        
        
        String jsonAnswer = listOfFind.toJson(true);
       
        Base.close();
       
        System.out.println("I am out :  getpotsbygps");
        return jsonAnswer;
    }
    
}
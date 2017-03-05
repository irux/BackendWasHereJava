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
    
    
    public LazyList<PostDB> getPostByFBIDArray(long id)    
    {
        
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/washereDB", "root", "TUBerlin2016");
         System.out.println("The id to search is _: " + id);
        LazyList<PostDB> listPost = PostDB.where("idFB = ?",id);
        
        
       
        
        System.out.println("I am Ready with the answer here");
         
        Base.close();
        return listPost;
    }
    
    
    public String getPostsByGPS(LazyList<PostDB> post)
    {
        
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/washereDB", "root", "TUBerlin2016");
        System.out.println("I am in the method of getpostByGPS");
        float radio = 0.001F;
        StringBuilder Query = new StringBuilder();
        try{
        Query.append("SELECT * FROM `post` WHERE (type = 1 or type = 2) and (");
        
        for (int x = 0 ; x<post.size() ; x++) {
            Float latitude = (Float)post.get(x).get("latitude");
            Float longitude = (Float)post.get(x).get("longitude");
            
            Query.append("(latitude BETWEEN " +  (latitude - radio) + " and " + (latitude + radio) + " ) and (longitude BETWEEN " + (longitude - radio) + " and " + (longitude + radio) + ") " );
            if(x != post.size() -1)
            {
                Query.append(" or ");
            }
            
           

            
        }
        
        Query.append(" )");
        
        Query.append(" ORDER BY timestamp DESC");
        
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
        
        System.out.println("Here is the query : " + Query);
        
        
         
        LazyList<PostDB> listPost = PostDB.findBySQL(Query.toString());
        
        String json = listPost.toJson(true);
        
        
        Base.close();
        
        return json;
        
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
       
       Float radio = 0.001F;
       
        System.out.println("I am getpotsbygps");
        
        LazyList<PostDB> listOfFind = PostDB.findBySQL("SELECT * FROM `post` WHERE (type = 1 or type = 2) and (latitude BETWEEN " +  (latitude - radio) + " and " + (latitude + radio) + " ) and (longitude BETWEEN " + (longitude - radio) + " and " + (longitude + radio) + ") ORDER BY timestamp DESC");
        
        
        
        String jsonAnswer = listOfFind.toJson(true);
       
        Base.close();
       
        System.out.println("I am out :  getpotsbygps");
        return jsonAnswer;
    }
    
}
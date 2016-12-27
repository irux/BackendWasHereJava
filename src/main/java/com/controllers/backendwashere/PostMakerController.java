/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers.backendwashere;

import com.google.gson.Gson;
import com.pojos.backendwashere.PlacePojo;
import com.pojos.backendwashere.PostPojo;
import com.pojos.backendwashere.UserTokenAuth;
import com.services.backendwashere.PostService;
import com.services.backendwashere.ReverseGeolocationService;
import com.services.backendwashere.TokenManagerService;
import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Authenticator;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;
import javax.servlet.MultipartConfigElement;
import spark.Route;

/**
 *
 * @author Alejandro Jaramillo
 */
public class PostMakerController {
    
    public static Route makePost()
    {
        
        
        Route postRoute = (request,response) -> {
            
            
        Gson gsonBuilder = new Gson();
        
        ReverseGeolocationService serviceGeolocation = new ReverseGeolocationService();
            
            
        
        //DataInputStream x = new DataInputStream(request.raw().getPart("post").getInputStream());
        

        
            
            
        PostPojo post = gsonBuilder.fromJson(request.headers("post"), PostPojo.class);
            
            
        
            PlacePojo placePost = serviceGeolocation.getReverse(post.getLongitude(), post.getLatitude());
        
        
        TokenManagerService tokenManager = new TokenManagerService();
            
        String token = request.headers("Authentication");
            
        UserTokenAuth infoTokenUser = gsonBuilder.fromJson(tokenManager.getInfoToken(token),UserTokenAuth.class);
        
        post.setFBId(infoTokenUser.getUserID());
        
        if(!Files.exists(Paths.get("/root/usersWashere/" + infoTokenUser.getUserID())))
        {
        Files.createDirectory(Paths.get("/root/usersWashere/" + infoTokenUser.getUserID()));
        Files.createDirectory(Paths.get("/root/usersWashere/" + infoTokenUser.getUserID()+ "/1"));
        Files.createDirectory(Paths.get("/root/usersWashere/" + infoTokenUser.getUserID()+ "/2"));
        }
        
        
         System.out.println(post);
        
        if(post.getType() == 1 || post.getType() == 2)
        {
        request.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/temp"));
        try (InputStream is = request.raw().getPart("file").getInputStream()) {
            if(is != null)
            {
               String path = "/root/usersWashere/" + infoTokenUser.getUserID()+ "/" + post.getType()  + "/"  + Calendar.getInstance().getTimeInMillis() + "-" +request.raw().getPart("file").getSubmittedFileName();
               post.setFileLocation(path);
               Files.copy(is, Paths.get(path));
            }
        }
            
        }
            
            PostService servicePostMaker = new PostService();
            
            servicePostMaker.saveIt(post);
            
                       
            
            System.out.println(request.body());
            System.out.println("Here are the headers : " + request.headers());
            
            
            
            return request.body();
        };      
        
        return postRoute;
    }
    
    
}

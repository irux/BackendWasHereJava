/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers.backendwashere;

import com.google.gson.Gson;
import com.pojos.backendwashere.PostPojo;
import com.pojos.backendwashere.UserTokenAuth;
import com.services.backendwashere.PostService;
import com.services.backendwashere.TokenManagerService;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
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
        
        System.out.println("Esto es lo que recibo : " + request.body());
        
        System.out.println("Esto es lo que recibo de get part post : " + request.raw().getPart("post"));
        
        PostPojo post = gsonBuilder.fromJson(request.body(), PostPojo.class);
            
        TokenManagerService tokenManager = new TokenManagerService();
            
        String token = request.headers("Authentication");
            
        UserTokenAuth infoTokenUser = gsonBuilder.fromJson(tokenManager.getInfoToken(token),UserTokenAuth.class);
        
        if(!Files.exists(Paths.get("/root/usersWashere/" + infoTokenUser.getUserID())))
        {
        Files.createDirectory(Paths.get("/root/usersWashere/" + infoTokenUser.getUserID()));
        Files.createDirectory(Paths.get("/root/usersWashere/" + infoTokenUser.getUserID()+ "/1"));
        Files.createDirectory(Paths.get("/root/usersWashere/" + infoTokenUser.getUserID()+ "/2"));
        }
        
        
        request.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/temp"));
        try (InputStream is = request.raw().getPart("file").getInputStream()) {
            if(is != null)
            {
               Files.copy(is, Paths.get("/root/usersWashere/" + infoTokenUser.getUserID()+ "/" + post.getType()  + "/" + Double.toString(Math.floor(Math.random() * 100000000))));
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

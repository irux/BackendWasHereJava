/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers.backendwashere;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.pojos.backendwashere.PostDB;
import com.pojos.backendwashere.PostPojo;
import com.pojos.backendwashere.UserTokenAuth;
import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.Version;
import com.restfb.types.User;
import com.services.backendwashere.PostService;
import com.services.backendwashere.TokenManagerService;
import java.util.List;
import javax.sql.DataSource;
import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.LazyList;
import spark.Route;

/**
 *
 * @author Alejo
 */
public class FeedController {
    
    public static Route getFriendFeed(DataSource pool)
    {
        
        Route friendFeed = (request,response) ->{
          
            Gson gson = new Gson();
            
            TokenManagerService tokenManager = new TokenManagerService();
            
            PostService service = new PostService(pool);
            
            UserTokenAuth user = gson.fromJson(tokenManager.getInfoToken(request.headers("Authentication")), UserTokenAuth.class);
            
            
           // System.out.println("I am going to get the post friends user");
           String friendsPost =  service.getPostFriendsFromUser(user);
            
           
           service = null;
           tokenManager = null;
           gson = null;
           user = null;
            
            
            return friendsPost;
        };
        
        return friendFeed;
        
    }
    
    
    
    
    
    public static Route getFeedProfile(DataSource pool)
    {
        
            
       
        
        
            Route feedProfile = (response,request) -> {
                
                
               // System.out.println("Ich Bin HIERRRRR");
                
            
                
                  
            
            Gson gson = new Gson();
                
            TokenManagerService tokenManager = new TokenManagerService();
            
            String infoJson = tokenManager.getInfoToken(response.headers("Authentication"));
           
            //System.out.println("Here is the token : " + response.headers("Authentication"));
           
            UserTokenAuth userInfo = gson.fromJson(infoJson, UserTokenAuth.class);
            
            //System.out.println("here is the fb id : " + userInfo.getUserID());
                
            
            PostService postService = new PostService(pool);
            
            String answer = postService.getPostByFBID(userInfo.getUserID());
            
            
            postService =null;
            userInfo = null;
            infoJson = null;
            tokenManager = null;
            gson = null;
            /*
            String answer = "[\n" +
"        { post_id: 1, postType:\"video\", location:\"Kottbusser Tor\", long: 51.83733, lat: -8.3016, timestamp: 1 , likes: 12 },\n" +
"        { post_id: 1, postType:\"video\", location:\"TU Berlin\", long: 51.83733, lat: -8.3016, date: 1473929274955 , likes: 12 },\n" +
"        { post_id: 1, postType:\"picture\", location:\"What Do You Fancy Love?\", long: 51.83733, lat: -8.3016, date: 1473929274955 , likes: 12 },\n" +
"        { post_id: 1, postType:\"video\", location:\"Kottbusser Tor\", long: 51.83733, lat: -8.3016, date: 1473929274955 , likes: 12 },\n" +
"        { post_id: 1, postType:\"video\", location:\"TU Berlin\", long: 51.83733, lat: -8.3016, date: 1473929274955 , likes: 12 },\n" +
"        { post_id: 1, postType:\"picture\", location:\"What Do You Fancy Love?\", long: 51.83733, lat: -8.3016, date: 1473929274955 , likes: 12 },\n" +
"        { post_id: 1, postType:\"video\", location:\"Kottbusser Tor\", long: 51.83733, lat: -8.3016, date: 1473929274955 , likes: 12 },\n" +
"        { post_id: 1, postType:\"video\", location:\"TU Berlin\", long: 51.83733, lat: -8.3016, date: 1473929274955 , likes: 12 },\n" +
"        { post_id: 1, postType:\"picture\", location:\"What Do You Fancy Love?\", long: 51.83733, lat: -8.3016, date: 1473929274955 , likes: 12 },\n" +
"        { post_id: 1, postType:\"video\", location:\"Kottbusser Tor\", long: 51.83733, lat: -8.3016, date: 1473929274955 , likes: 12 },\n" +
"        { post_id: 1, postType:\"video\", location:\"TU Berlin\", long: 51.83733, lat: -8.3016, date: 1473929274955 , likes: 12 },\n" +
"        { post_id: 1, postType:\"picture\", location:\"What Do You Fancy Love?\", long: 51.83733, lat: -8.3016, date: 1473929274955 , likes: 12 },\n" +
"        { post_id: 1, postType:\"video\", location:\"Kottbusser Tor\", long: 51.83733, lat: -8.3016, date: 1473929274955 , likes: 12 },\n" +
"        { post_id: 1, postType:\"video\", location:\"TU Berlin\", long: 51.83733, lat: -8.3016, date: 1473929274955 , likes: 12 },\n" +
"        { post_id: 1, postType:\"picture\", location:\"What Do You Fancy Love?\", long: 51.83733, lat: -8.3016, date: 1473929274955 , likes: 12 },\n" +
"        { post_id: 1, postType:\"video\", location:\"Kottbusser Tor\", long: 51.83733, lat: -8.3016, date: 1473929274955 , likes: 12 },\n" +
"        { post_id: 1, postType:\"video\", location:\"TU Berlin\", long: 51.83733, lat: -8.3016, date: 1473929274955 , likes: 12 },\n" +
"        { post_id: 1, postType:\"picture\", location:\"What Do You Fancy Love?\", long: 51.83733, lat: -8.3016, date: 1473929274955 , likes: 12 },\n" +
"        { post_id: 1, postType:\"video\", location:\"Kottbusser Tor\", long: 51.83733, lat: -8.3016, date: 1473929274955 , likes: 12 },\n" +
"        { post_id: 1, postType:\"video\", location:\"TU Berlin\", long: 51.83733, lat: -8.3016, date: 1473929274955 , likes: 12 },\n" +
"        { post_id: 1, postType:\"picture\", location:\"What Do You Fancy Love?\", long: 51.83733, lat: -8.3016, date: 1473929274955 , likes: 12 },\n" +
"        { post_id: 1, postType:\"video\", location:\"Kottbusser Tor\", long: 51.83733, lat: -8.3016, date: 1473929274955 , likes: 12 },\n" +
"        { post_id: 1, postType:\"video\", location:\"TU Berlin\", long: 51.83733, lat: -8.3016, date: 1473929274955 , likes: 12 },\n" +
"        { post_id: 1, postType:\"picture\", location:\"What Do You Fancy Love?\", long: 51.83733, lat: -8.3016, date: 1473929274955 , likes: 12 },\n" +
"        { post_id: 1, postType:\"video\", location:\"Kottbusser Tor\", long: 51.83733, lat: -8.3016, date: 1473929274955 , likes: 12 },\n" +
"        { post_id: 1, postType:\"video\", location:\"TU Berlin\", long: 51.83733, lat: -8.3016, date: 1473929274955 , likes: 12 },\n" +
"        { post_id: 1, postType:\"picture\", location:\"What Do You Fancy Love?What Do You Fancy Love?\", long: 51.83733, lat: -8.3016, date: 1473929274955 , likes: 12 },\n" +
"        { post_id: 1, postType:\"video\", location:\"Kottbusser Tor\", long: 51.83733, lat: -8.3016, date: 1473929274955 , likes: 12 },\n" +
"        { post_id: 1, postType:\"video\", location:\"TU Berlin\", long: 51.83733, lat: -8.3016, date: 1473929274955 , likes: 12 },\n" +
"        { post_id: 1, postType:\"picture\", location:\"What Do You Fancy Love?\", long: 51.83733, lat: -8.3016, date: 45 , likes: 15 }\n" +
"    ]";
            
            
            JsonParser parser = new JsonParser();

*/
            
           return answer;
            
             
            
        };
        
        
        return feedProfile;
        
    }
    
    public static Route getFeedCategory(DataSource pool)
    {
        
        
        Route FeedGeo = (request,response) -> {
            
            float latitude = Float.valueOf(request.queryParams("lat"));
            
           // System.out.println("Esta es latitud : " + latitude);
            
            float longitude = Float.valueOf(request.queryParams("long"));
           // System.out.println("Esta es la longitud : " + longitude);
            
            String category = request.params(":category");
            
           // System.out.println("Esta es la categoria : " + category);
            
            TokenManagerService tokenManager = new TokenManagerService();
            
            String infoJson = tokenManager.getInfoToken(request.headers("Authentication"));
            
            Gson gson = new Gson();
            
            UserTokenAuth userInfo = gson.fromJson(infoJson, UserTokenAuth.class);
            
            
             PostService postService = new PostService(pool);
             
             String json = null;
             
             switch(category.toLowerCase())
             {
                 case "here":
                     
                     json = postService.getPostsByGPS(longitude, latitude);
                   //  System.out.println("It is json for getFeedCategory " + json);
                     break ;
                 case "favorites":
                   //  System.out.println("Ich bin bei favorites");
                     LazyList<PostDB> WhereIWas = postService.getPostByFBIDArray(userInfo.getUserID());
                     json = postService.getPostsByGPS(WhereIWas);
                     break;
                     
                     
             }
             
             
             
             tokenManager = null;
             postService = null;
             userInfo = null;
             gson = null;
             category = null;
             infoJson = null;
             
             
            
            
           
            
            return json;
        };
        
        return FeedGeo;
    }
    
    
}

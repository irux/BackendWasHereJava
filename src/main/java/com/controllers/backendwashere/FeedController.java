/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers.backendwashere;

import com.google.gson.JsonParser;
import spark.Route;

/**
 *
 * @author Alejo
 */
public class FeedController {
    
    public static Route getFeedProfile()
    {
        
        Route feedProfile = (response,request) -> {
            
            String answer = "[\n" +
"        { post_id: 1, postType:\"video\", location:\"Kottbusser Tor\", long: 51.83733, lat: -8.3016, date: 1 , likes: 12 },\n" +
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
            
           return parser.parse(answer);
            
             
            
        };
        
        
        return feedProfile;
        
    }
    
    public static Route getFeedCategory()
    {
        
        
        Route FeedGeo = (request,response) -> {
            
            float latitude = Float.valueOf(request.queryParams("lat"));
            
            System.out.println("Esta es latitud : " + latitude);
            
            float longitude = Float.valueOf(request.queryParams("long"));
            System.out.println("Esta es la longitud : " + longitude);
            
            String category = request.params(":category");
            
            System.out.println("Esta es la categoria : " + category);
            
            String temporalRequest = "[\n" +
"            {\n" +
"              post_id:1,\n" +
"              type:\"video\",\n" +
"              url:\"http://clips.vorwaerts-gmbh.de/VfE_html5.mp4\",\n" +
"              username:\"Valentino\",\n" +
"              likes:59,\n" +
"              date:1473933055,\n" +
"              location:'bar1',\n" +
"              typeDetails:'video/mp4'\n" +
"            },\n" +
"            {\n" +
"              post_id:3,\n" +
"              type:\"img\",\n" +
"              url:\"http://cdn.fansided.com/wp-content/blogs.dir/229/files/2013/12/706147-himym_renewed.jpg\",\n" +
"              username:\"Valentino3\",\n" +
"              likes:154,\n" +
"              date:1473933055,\n" +
"              location:'bar1',\n" +
"              typeDetails:'img/png'\n" +
"            },\n" +
"            {\n" +
"              post_id:3,\n" +
"              type:\"img\",\n" +
"              url:\"https://img.buzzfeed.com/buzzfeed-static/static/enhanced/terminal05/2012/10/27/5/enhanced-buzz-762-1351329772-1.jpg\",\n" +
"              username:\"Ted\",\n" +
"              likes:154,\n" +
"              date:1473933055,\n" +
"              location:'bar1',\n" +
"              typeDetails:'img/jpg'\n" +
"            },\n" +
"            {\n" +
"              post_id:3,\n" +
"              type:\"img\",\n" +
"              url:\"https://img.buzzfeed.com/buzzfeed-static/static/enhanced/web04/2012/10/27/5/enhanced-buzz-28331-1351329868-5.jpg\",\n" +
"              username:\"Barney\",\n" +
"              likes:154,\n" +
"              date:1473933055,\n" +
"              location:'bar1',\n" +
"              typeDetails:'img/jpg'\n" +
"            },\n" +
"            {\n" +
"              post_id:3,\n" +
"              type:\"img\",\n" +
"              url:\"https://img.buzzfeed.com/buzzfeed-static/static/enhanced/terminal05/2012/10/27/5/enhanced-buzz-778-1351329830-3.jpg\",\n" +
"              username:\"Lilly\",\n" +
"              likes:154,\n" +
"              date:1473933055,\n" +
"              location:'bar1',\n" +
"              typeDetails:'img/jpg'\n" +
"            },\n" +
"            {\n" +
"              post_id:3,\n" +
"              type:\"img\",\n" +
"              url:\"https://img.buzzfeed.com/buzzfeed-static/static/enhanced/web03/2012/10/27/5/enhanced-buzz-28846-1351329818-3.jpg\",\n" +
"              username:\"Marshall\",\n" +
"              likes:154,\n" +
"              date:1473933055,\n" +
"              location:'bar1',\n" +
"              typeDetails:'img/jpg'\n" +
"            }\n" +
"        ]";
            
            
            JsonParser parser = new JsonParser();
            
           
            
            return parser.parse(temporalRequest);
        };
        
        return FeedGeo;
    }
    
    
}

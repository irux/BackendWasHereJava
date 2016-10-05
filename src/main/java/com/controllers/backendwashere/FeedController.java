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
    
    
}

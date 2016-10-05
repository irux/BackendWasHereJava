package com.init.spark;

import com.controllers.backendwashere.LoginController;
import com.controllers.backendwashere.LoginControllerFacebook;
import java.sql.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

import java.net.URI;
import java.net.URISyntaxException;

import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.get;

import com.heroku.sdk.jdbc.DatabaseUrl;
import com.services.backendwashere.InstagramLoginService;
import com.interfaces.backendwashere.LoginService;

public class Main {

  public static void main(String[] args) {

    port(Integer.valueOf(System.getenv("PORT")));
    
    InstagramLoginService servicioInstagram = new InstagramLoginService();
    
    get("/hello", (req,res) -> "HELLO WORLD");
    get("/instagram/login",LoginController.login(servicioInstagram));
    get("/instagram/callback",LoginController.tokenManagment());
    post("/login",LoginControllerFacebook.login());
    get("/profile/feed",(req,res) -> "[\n" +
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
"    ]");
    

  }

}

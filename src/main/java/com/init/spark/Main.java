package com.init.spark;

import com.controllers.backendwashere.FeedController;
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
import com.services.backendwashere.FacebookLoginService;

public class Main {

  public static void main(String[] args) {

    port(Integer.valueOf(System.getenv("PORT")));
    
      FacebookLoginService servicioFacebook = new FacebookLoginService();
    
    get("/hello", (req,res) -> "HELLO WORLD");
    //get("/instagram/login",LoginController.login(servicioFacebook));
    get("/instagram/callback",LoginController.tokenManagment());
    post("/login",LoginControllerFacebook.login(servicioFacebook));
    get("/profile/feed",FeedController.getFeedProfile());
    

  }

}

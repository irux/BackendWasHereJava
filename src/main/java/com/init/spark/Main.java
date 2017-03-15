package com.init.spark;

import com.controllers.backendwashere.FeedController;
import com.controllers.backendwashere.LoginController;
import com.controllers.backendwashere.LoginControllerFacebook;
import com.controllers.backendwashere.PostMakerController;
import java.sql.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

import java.net.URI;
import java.net.URISyntaxException;

import static spark.Spark.*;

import spark.ModelAndView;
import static spark.Spark.get;


import com.services.backendwashere.InstagramLoginService;
import com.interfaces.backendwashere.LoginService;
import com.mchange.v2.c3p0.DataSources;
import com.services.backendwashere.FacebookLoginService;
import javax.sql.DataSource;
import org.javalite.activejdbc.Base;
import spark.debug.DebugScreen;

public class Main {

    
    
  public static void main(String[] args) throws SQLException {

      System.setProperty("com.mchange.v2.log.MLog", "com.mchange.v2.log.FallbackMLog");
      System.setProperty("com.mchange.v2.log.FallbackMLog.DEFAULT_CUTOFF_LEVEL", "WARNING");

    
     staticFiles.externalLocation("/root/usersWashere");
     staticFiles.expireTime(600);
     
     DataSource source = DataSources.unpooledDataSource("jdbc:mysql://172.17.0.2:3306/washereDB", "root", "TUBerlin2016");
     DataSource pool = DataSources.pooledDataSource(source);
      
    port(Integer.parseInt(System.getenv("PORTWASHERE")));

    FacebookLoginService servicioFacebook = new FacebookLoginService();
    
    get("/hello", (req,res) -> "HELLO WORLD");
    //get("/instagram/login",LoginController.login(servicioFacebook));
    get("/instagram/callback",LoginController.tokenManagment());
    post("/login",LoginControllerFacebook.login(servicioFacebook,pool));
    get("/profile/feed",FeedController.getFeedProfile(pool));
    get("/search/category/:category","application/json",FeedController.getFeedCategory(pool));
    post("/post"    ,PostMakerController.makePost(pool));
    get("/profile/friends/all/feed",FeedController.getFriendFeed(pool));
    
    
      DebugScreen.enableDebugScreen();
  }

}

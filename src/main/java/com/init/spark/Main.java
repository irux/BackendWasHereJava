package com.init.spark;

import com.controllers.backendwashere.LoginController;
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

    port(8080);
    
    InstagramLoginService servicioInstagram = new InstagramLoginService();
      System.out.println("Prueba de reinicio");
    
    get("/hello", (req,res) -> "HELLO WORLD");
    get("/instagram/login",LoginController.login(servicioInstagram));
    get("/instagram/callback",LoginController.tokenManagment());
    

  }

}

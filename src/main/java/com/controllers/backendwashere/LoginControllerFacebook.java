/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers.backendwashere;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.interfaces.backendwashere.LoginServiceToken;
import com.pojos.backendwashere.FacebookToken;
import com.pojos.backendwashere.UserDB;
import com.pojos.backendwashere.UserTokenAuth;
import com.restfb.types.User;
import com.services.backendwashere.FacebookLoginService;
import java.math.BigInteger;
import java.util.List;
import javax.sql.DataSource;
import org.eclipse.jetty.security.UserAuthentication;
import org.javalite.activejdbc.Base;
import spark.Route;

/**
 *
 * @author Alejo
 */
public class LoginControllerFacebook {

    public static Route login(LoginServiceToken loginService ,DataSource pool) {

        Route loginFacebook = (request, response) -> {

            String tokenFromCliente = request.body();

            boolean successful = loginService.login(tokenFromCliente);

            if (successful) {
                Base.open(pool);

                User userFB = (User) loginService.getLastUserLogin();

                UserDB userInDB = UserDB.findFirst("idFB = ?", Long.parseLong(userFB.getId()));

               // System.out.println(userInDB);

                if (userInDB == null) {
                    try {
                        UserDB user = new UserDB();
                        user.set("tokenFB", loginService.getLastTokenLogin());
                        user.set("idFB", Long.parseLong(userFB.getId()));
                        user.set("first_name", userFB.getFirstName());
                        user.set("last_name", userFB.getLastName());
                        user.set("age_range", userFB.getAgeRange().getMin() + "-" + userFB.getAgeRange().getMax());
                        user.set("gender", userFB.getGender());
                        user.set("locale", userFB.getLocale());
                        user.set("verified", userFB.getVerified().toString());
                        user.set("tokenLogin", "test");
                        user.set("picture", userFB.getPicture().getUrl());  
                        user.saveIt();

                        //System.err.println(user.errors());

                    } catch (Exception e) {
                        //System.err.println("Error en la transaccion : " + e.getMessage() + " " + e.getLocalizedMessage());
                        Base.close();
                    }

                    Gson gsonSerialized = new Gson();
                    UserTokenAuth userAuth = new UserTokenAuth(Long.parseLong(userFB.getId()), (String) loginService.getLastTokenLogin(), 2);
                    String userAuthString = gsonSerialized.toJson(userAuth);
                    JsonParser parser = new JsonParser();
                    String AuthTokenFinal = loginService.getTokenLogin(userAuthString);
                    Base.close();
                    return parser.parse("{token:" + AuthTokenFinal + "}");
                } else {
                    Gson gsonSerialized = new Gson();
                    UserTokenAuth userAuth = new UserTokenAuth(Long.parseLong(userFB.getId()), (String) loginService.getLastTokenLogin(), 2);
                    String userAuthString = gsonSerialized.toJson(userAuth);
                    JsonParser parser = new JsonParser();
                    String AuthTokenFinal = loginService.getTokenLogin(userAuthString);
                    Base.close();
                    return parser.parse("{token:" + AuthTokenFinal + "}");

                    //return "Error with login Facebook";
                }
                
                

            }
            
            Base.close();
            
            return "Error with login with FB";

        };

        return loginFacebook;
    }

}

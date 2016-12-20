/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services.backendwashere;

import com.pojos.backendwashere.KeyDB;
import java.security.Key;
import org.javalite.activejdbc.Base;
import org.jose4j.jwe.JsonWebEncryption;
import org.jose4j.keys.AesKey;

/**
 *
 * @author Alejandro Jaramillo
 */
public class TokenManagerService {

    public TokenManagerService() {
    }
    
    
    public String getInfoToken(String info)
    {
        
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/washereDB", "root", "TUBerlin2016");
        
        KeyDB keyForAuth = KeyDB.findFirst("keyService = ?", "AuthService");
        byte[] keyInBytes = keyForAuth.getBytes("keyBinary");
        Key finalKey = new AesKey(keyInBytes);
        JsonWebEncryption encryptionJSON = new JsonWebEncryption();
        encryptionJSON.setKey(finalKey);
        try {
            encryptionJSON.setCompactSerialization(info);
            Base.close();
            return encryptionJSON.getPayload();
        } catch (Exception e) {
        }
        
        Base.close();
        return null;
    }
    
    
}

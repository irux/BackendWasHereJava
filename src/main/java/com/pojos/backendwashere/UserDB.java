/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pojos.backendwashere;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.IdName;
import org.javalite.activejdbc.annotations.Table;

/**
 *
 * @author Alejo
 */

@Table("user")
//@IdName("idFB")
@CompositePK({"idFB"})
public class UserDB extends Model {
    
    
    
    public UserDB() {
    }

    

    
    
    
    
    
    
}

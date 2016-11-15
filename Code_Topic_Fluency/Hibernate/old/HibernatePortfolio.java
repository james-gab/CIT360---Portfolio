/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernateportfolio;

import java.util.Date;




/**
 *
 * @author gab
 */
public class HibernatePortfolio {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        
//        Date date = new Date();
        
        User person = new User();
        //person.setUserId(0);
        person.setUsername("gabJames");
        person.setCreatedBy("Aplication");
        person.setCreatedDate(new Date());
        
        Model.insertUser(person);
                
        System.exit(0);
        
        
    }
    
    
    
}

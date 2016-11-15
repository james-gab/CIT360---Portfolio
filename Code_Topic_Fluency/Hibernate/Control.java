/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernateportfolio;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author gab
 */


public class Control {
     Scanner userInput = new Scanner(System.in);
     
    
    public static void main(String[] args) {}
        
    static void creatUser(String aUserName, String aCreatedBy) {
        
//        System.out.print(aUserName);
//        System.out.print(aCreatedBy);
        
        
             DBUser person = new DBUser();
             person.setUsername(aUserName);
             person.setCreatedBy(aCreatedBy);
             person.setCreatedDate(new Date());
             
             Model.insertUser(person);
    }
    
    public static void updateUser(){
        
    }
    
    static List<DBUser> listUser(){
        
        List<DBUser> userList = Model.showAllUsers();
        Iterator<DBUser> iteratedUsers = userList.iterator();
//        return (List<User>) iteratedUsers;
        return null;
    }
    
    public static void deleteUser(){
        
    }
    
    public static void getMainMenu(){
        DBMainMenu menu = new DBMainMenu();
    }

    
}

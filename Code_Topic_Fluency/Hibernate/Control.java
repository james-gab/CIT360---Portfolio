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
    
    static DBUser updateUser(Integer user){
        DBUser theUser = Model.showUserByID(user);
        return theUser;
    }
    
    static DBUser updateTheUser(Integer user, String name, String by){
             DBUser person = new DBUser();
             person.setUserId(user);
             person.setUsername(name);
             person.setCreatedBy(by);
             person.setCreatedDate(new Date());
             
             Model.updateUser(person);
             return person;
        
    }




    static List<DBUser> listUser(){
        List<DBUser> userList = Model.showAllUsers();
       return userList;
    }
    
    public static void deleteUser(){
        
    }
    
    public static void getMainMenu(){
        DBMainMenu menu = new DBMainMenu();
    }
    
    static String ckForUser(Integer user, String name){
        if(!"".equals(name)){
            return name;
        } else{
            DBUser theUser = Model.showUserByID(user);
//            DBUser theUser = updateUser(user);
            return theUser.getUsername();
        }
    }

    
    static String ckForCreatedBy(Integer user, String by){
        if(!"".equals(by)){
            return by;
        } else{
            DBUser theUser = Model.showUserByID(user);
//            DBUser theUser = updateUser(user);
            return theUser.getCreatedBy();
        }
    }
    
    static void exit(Integer user){
        if(user == 0){
            View.main(null);
        }
    }
    
    
}

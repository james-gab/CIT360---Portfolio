/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernateportfolio;

import java.util.Date;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author gab
 */


public class Control {




     private Scanner userInput = new Scanner(System.in);
     
    
//    public static void main(String[] args) {}

     
     
     

    static DB_user_table userLogin(String username, String password) {
        DB_user_table user = Model.showUserByUniqueSearch(username, password);
        if (user != null){
            return user;
        }
        return user;
    }

    static boolean ckAdmin(DB_user_table theUser) {
        Integer admin = theUser.getAdminUser();
        
        if (admin == 1){
            return true;
        } else {
            return false;
        }
    }


    static void creatUser(String aUserName, String aCreatedBy) {
        
             DB_user person = new DB_user();
             person.setUsername(aUserName);
             person.setCreatedBy(aCreatedBy);
             person.setCreatedDate(new Date());
             
             Model.insertUser(person);
    }
    
    static DB_user updateUser(Integer user){
         if("".equals(user)){
             return null;
         } else{
             DB_user theUser = Model.showUserByID(user);
             return theUser;
         }
    }
    
    static DB_user updateTheUser(Integer user, String name, String by){
         DB_user person = new DB_user();
         person.setUserId(user);
         person.setUsername(name);
         person.setCreatedBy(by);
         person.setCreatedDate(new Date());
             
         Model.updateUser(person);
         return person;
    }
    
    static List<DB_user> listUser(){
         List<DB_user> userList = Model.showAllUsers();
         return userList;
    }
    
    static List<DB_user> listSearchedUser(String user){
         List<DB_user> userList = Model.showUserListByUniqueSearch(user);
         return userList;
    }

    static String deleteUser(Integer user, String YESorNO) {
         if (YESorNO.equalsIgnoreCase("Y")){
             Model.deletUser(Model.showUserByID(user));
             return "User Removed!";
         } else {
             return "User Not Removed, Returning to Main Menu";
         }
    }
    
    public static void getMainMenu(){
         DBMainMenu menu = new DBMainMenu();
    }
    
    static String ckForUser(Integer user, String name){
         if(!"".equals(name)){
             return name;
         } else{
             return theUser(user);
         }
    }

    
    static String ckForCreatedBy(Integer user, String by){
         if(!"".equals(by)){
             return by;
         } else{
             return theCreatedBy(user);
         }
    }
    
    static void exit(Integer user){
         if(user == 0){
             View.main(null);
        }
    }
    
    static String ckUser(Integer user){
         if(user == null){
             return "";
         } else{
             return theUser(user)+" - update to:  ";
         }
    }

    static String ckCreatedBy(Integer user){
         if(user == null){
             return "";
         } else{
             return theCreatedBy(user)+" - update to:  ";
         }
    }

    static String theUser(Integer user){
         DB_user theUser = Model.showUserByID(user);
         return theUser.getUsername();
    }
    
    static String theCreatedBy(Integer user){
         DB_user theUser = Model.showUserByID(user);
         return theUser.getCreatedBy();
    }

    /**
     * @return the userInput
     */
    public Scanner getUserInput() {
         return userInput;
    }

    /**
     * @param userInput the userInput to set
     */
    public void setUserInput(Scanner userInput) {
         this.userInput = userInput;
    }


// THIS IS TESTING AREA
    
    static List<DB_user_table> DBTESTlistUser(){
         List<DB_user_table> userList = Model.showAllDBUsers();
         return userList;
    }



    
}

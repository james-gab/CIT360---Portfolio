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
     
    
    public static void main(String[] args) {}
        
    static void creatUser(String aUserName, String aCreatedBy) {
        
             DBUser person = new DBUser();
             person.setUsername(aUserName);
             person.setCreatedBy(aCreatedBy);
             person.setCreatedDate(new Date());
             
             Model.insertUser(person);
    }
    
    static DBUser updateUser(Integer user){
        if("".equals(user)){
            return null;
        } else{
        DBUser theUser = Model.showUserByID(user);
        return theUser;
        }
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
    
    static List<DBUser> listSearchedUser(String user){
        List<DBUser> userList = Model.showUserListByUniqueSearch(user);
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
//            DBUser theUser = Model.showUserByID(user);
//            DBUser theUser = updateUser(user);
//            return theUser.getUsername();

// this line makes this ACP compliant
            return theUser(user);
        }
    }

    
    static String ckForCreatedBy(Integer user, String by){
        if(!"".equals(by)){
            return by;
        } else{
//            DBUser theUser = Model.showUserByID(user);
//            DBUser theUser = updateUser(user);
//            return theUser.getCreatedBy();

// This line makes this ACP compliant
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
//            DBUser theUser = Model.showUserByID(user);
//            return theUser.getUsername();
//This makes these ACP compliant
            return theUser(user);
        }
    }
    static String ckCreatedBy(Integer user){
        if(user == null){
            return "";
        } else{
//            DBUser theUser = Model.showUserByID(user);
//            return theUser.getCreatedBy();
//This makes these ACP compliant
              return theCreatedBy(user);
        }
    }

    
    static String theUser(Integer user){
            DBUser theUser = Model.showUserByID(user);
            return theUser.getUsername();
    }
    
    static String theCreatedBy(Integer user){
            DBUser theUser = Model.showUserByID(user);
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
    
}

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

    static void creatUserRecord(String aUserName, String aPassword, String aIsAdmin, 
            String aFirstName, String aMiddelName, String aLastName, String aPhone, 
            Integer aPhoneType, String aEmail, String aStreetAddress, String aCity, 
            String aState, String aZipCode) {
// Skills Resource Assistant ~ method        
System.out.println("VListAllUser()~creatUserRecord() - STUB Not supported yet.");

        DB_user_table user = new DB_user_table();
        DB_member_table member = new DB_member_table();
        DB_address_table address = new DB_address_table();
        int newMemberID = newMemNumber();
        
//        aPhone = aPhone.replaceAll("[-+.^:,_]","");
        
        user.setUserName(aUserName);
        user.setPassword(aPassword);
        if (aIsAdmin.equalsIgnoreCase("Y")){
            user.setAdminUser(1);
        } else {
            user.setAdminUser(0);
        }
        user.setIsActive(1);
        
        member.setMemberID(newMemberID);
        member.setLName(aLastName);
        member.setFName(aFirstName);
        member.setMName(aMiddelName);
        if (aPhone != null){
           aPhone = aPhone.replaceAll("[-+.^:,_*]","");
//            member.setPhone(Integer.parseInt(aPhone));
            member.setPhone(Long.parseLong(aPhone));
        } else {
            member.setPhone(Long.parseLong(aPhone));
        }
        member.setPhoneType(aPhoneType);
        member.setEmail(aEmail);
        member.setSkillsID("");
        member.setWardID(0);
        user.setMemberMapping(member);
//        address.setAddressID(newMemberID);
        address.setStreetAddress(aStreetAddress);
        address.setCity(aCity);
        address.setHomeState(aState);
        address.setZipCode(aZipCode);
        member.setAddressTableMapping(address);
        
        System.out.println("user name - " + user.getUserName());
        System.out.println("user password - " + user.getPassword());
        System.out.println("user isadmin - " + user.getAdminUser());
        System.out.println("member ID - " + member.getMemberID());
        
        Model.insertUser(user,member,address,newMemberID);
             
             
    }
    
    static Integer newMemNumber (){
// Skills Resource Assistant ~ method
// this works
        List<DB_address_table> query = Model.newMemberNumber();
        int result = Integer.parseInt(query.toString().replace("[", "").replace("]",""))+1;
//        System.out.println("results - "+result);
        return result;
    }

    
    
    static List<DB_member_table> listMemberTable() {
// Skills Resource Assistant ~ method        
         List<DB_member_table> userList = Model.showAllDBMemberTable();
         return userList;
    }

    static List<DB_member_table> listSearchedMemberTable(String user) {
// Skills Resource Assistant ~ method        
         List<DB_member_table> userList = Model.showMemberTableListByUniqueSearch(user);
         return userList;
    }

    static boolean ckIsActive(DB_user_table theUser) {
// Skills Resource Assistant ~ method        
        if (theUser != null){
        Integer active = theUser.getIsActive();
        
        if (active == 1){
            return true;
        }} else {
            return false;
        }
         return false;
        
        
    }

// check to see is member is active and an administator
    static boolean ckIfActive(boolean admin, boolean memberActive) {
// Skills Resource Assistant ~ method        
        if(memberActive == true && admin == true){
                return true;
            } else {
                return false;
            }
    }

    static List<DB_member_table> listIsActiveMemberTable() {
// Skills Resource Assistant ~ method        
         List<DB_member_table> userList = Model.showAllActiveDBMemberTable();
         return userList;
    }


     private Scanner userInput = new Scanner(System.in);




     
    
//    public static void main(String[] args) {}

     
     
     

    static DB_user_table userLogin(String username, String password) {
// Skills Resource Assistant ~ method        
        DB_user_table user = Model.showUserByUniqueSearch(username, password);
        if (user != null){
            return user;
        }
        return user;
    }

    static boolean ckAdmin(DB_user_table theUser) {
// Skills Resource Assistant ~ method        
        if (theUser != null){
        Integer admin = theUser.getAdminUser();
        
        if (admin == 1){
            return true;
        }} else {
            return false;
        }
         return false;
        
        
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

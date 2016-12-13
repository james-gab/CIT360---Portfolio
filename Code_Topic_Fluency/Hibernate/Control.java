/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernateportfolio;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import org.json.simple.JSONArray;


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

        DB_user_table user = new DB_user_table();
        DB_member_table member = new DB_member_table();
        DB_address_table address = new DB_address_table();
        int newMemberID = newMemNumber();
        
        aPhone = aPhone.replaceAll("[-+.^:,_]","");
        
        user.setUserName(aUserName);
        user.setPassword(aPassword);
        if (aIsAdmin.equalsIgnoreCase("Y")){
            user.setAdminUser(1);
        } else {
            user.setAdminUser(0);
        }
        user.setIsActive(1);
        
        member.setLName(aLastName);
        member.setFName(aFirstName);
        member.setMName(aMiddelName);
        if (aPhone != null){
           aPhone = aPhone.replaceAll("[-+.^:,_*]","");
            member.setPhone(Long.parseLong(aPhone));
        } else {
           aPhone = aPhone.replaceAll("[-+.^:,_*]","");
            member.setPhone(Long.parseLong(aPhone));
        }
        member.setPhoneType(aPhoneType);
        member.setEmail(aEmail);
        member.setSkillsID("");
        member.setWardID(0);
        user.setMemberMapping(member);
        address.setStreetAddress(aStreetAddress);
        address.setCity(aCity);
        address.setHomeState(aState);
        address.setZipCode(aZipCode);
        member.setAddressTableMapping(address);
        
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

    static DB_member_table findMember(Integer user) {
// Skills Resource Assistant ~ method        
         if("".equals(user)){
             return null;
         } else{
             DB_member_table theUser = Model.showMemberByID(user);
             return theUser;
         }
    }

    static DB_user_table findUser(DB_member_table theMember) {
// Skills Resource Assistant ~ method        
        DB_user_table user = Model.userByMemberNumber(theMember);
        return user;
    }

    static DB_address_table findAddress(DB_member_table theMember) {
// Skills Resource Assistant ~ method        
        DB_address_table address;
        address = Model.AddressByMemberNumber(theMember.getAddressTableMapping());
        return address;
    }

    static String ckForUserName(DB_user_table user) {
// Skills Resource Assistant ~ method        
         if("".equals(user)){
             return null;
         } else{
             return user.getUserName() + "  -  update to: ";
         }
    }

    static String ckForPassword(DB_user_table user) {
// Skills Resource Assistant ~ method        
         if("".equals(user)){
             return null;
         } else{
             return user.getPassword() + "  -  update to: ";
         }
    }

    static String ckForAdmin(DB_user_table user) {
// Skills Resource Assistant ~ method        
         switch (user.getAdminUser()){
             case 0:
                 return "  NO  -  update to: ";
             case 1:
                 return "  YES  -  update to: ";
             default:
                 return null;
             
             
         }
    }

    static String ckForFirstName(DB_member_table user) {
// Skills Resource Assistant ~ method        
         if("".equals(user)){
             return null;
         } else{
             return user.getFName() + "  -  update to: ";
         }
    }

    static String ckForMiddleName(DB_member_table user) {
// Skills Resource Assistant ~ method        
         if("".equals(user)){
             return null;
         } else{
             return user.getMName() + "  -  update to: ";
         }
    }

    static String ckForLastName(DB_member_table user) {
// Skills Resource Assistant ~ method        
         if("".equals(user)){
             return null;
         } else{
             return user.getLName() + "  -  update to: ";
         }
    }

    static String ckForPhone(DB_member_table user) {
// Skills Resource Assistant ~ method        
         if("".equals(user)){
             return null;
         } else{
             return user.getPhone() + "  -  update to: ";
         }
    }

    static String ckForPhoneType(DB_member_table user) {
// Skills Resource Assistant ~ method        
         switch (user.getPhoneType()){
             case 1:
                 return "\n Home Phone - update to: ";
             case 2:
                 return "\n Cell Phone - update to: ";
             case 3:
                 return "\n Business Phone - update to: ";
             default:
                 return null;
                 
             
         }
         
    }

    static String ckForEmail(DB_member_table user) {
// Skills Resource Assistant ~ method        
         if("".equals(user)){
             return null;
         } else{
             return user.getEmail() + "\nupdate to: ";
         }
    }

    static String ckForStreetAdress(DB_address_table user) {
// Skills Resource Assistant ~ method        
         if("".equals(user)){
             return null;
         } else{
             return user.getStreetAddress() + "  -  update to: ";
         }
    }

    static String ckForCity(DB_address_table user) {
// Skills Resource Assistant ~ method        
         if("".equals(user)){
             return null;
         } else{
             return user.getCity() + "  -  update to: ";
         }
    }

    static String ckForState(DB_address_table user) {
// Skills Resource Assistant ~ method        
         if("".equals(user)){
             return null;
         } else{
             return user.getHomeState() + "  -  update to: ";
         }
    }

    static String ckForZipCode(DB_address_table user) {
// Skills Resource Assistant ~ method        
         if("".equals(user)){
             return null;
         } else{
             return user.getZipCode() + "  -  update to: ";
         }
    }

    static Integer updateMemberRecord(String aUserName, String aPassword, String aIsAdmin, String aFirstName, String aMiddelName, String aLastName, String aPhone, Integer aPhoneType, String aEmail, String aStreetAddress, String aCity, String aState, String aZipCode, DB_user_table theOldUser, DB_member_table theOldMember, DB_address_table theOldAddress) {
        DB_user_table theUser = theOldUser;
        DB_member_table theMember = theOldMember;
        DB_address_table theAddress = theOldAddress;
        
         if (!aUserName.isEmpty()){
             theUser.setUserName(aUserName);
         }
         if (!aPassword.isEmpty()){
             theUser.setPassword(aPassword);
         }
         if (!aIsAdmin.isEmpty()){
             if (aIsAdmin.equalsIgnoreCase("Y")){
                 theUser.setAdminUser(1);
             } else {
                 theUser.setAdminUser(0);
             }
         }
         if(!aFirstName.isEmpty()){
             theMember.setFName(aFirstName);
         }
         if (!aMiddelName.isEmpty()){
             theMember.setMName(aMiddelName);
         }
         if(!aLastName.isEmpty()){
             theMember.setLName(aLastName);
         }
         if(!aPhone.isEmpty()){
            aPhone = aPhone.replaceAll("[-+.^:,_*]","");
            theMember.setPhone(Long.parseLong(aPhone));
         }  
         if(aPhoneType>0){
             theMember.setPhoneType(aPhoneType);
         }
         if(!aEmail.isEmpty()){
             theMember.setEmail(aEmail);
         }
         if(!aStreetAddress.isEmpty()){
             theAddress.setStreetAddress(aStreetAddress);
         }
         if(!aCity.isEmpty()){
             theAddress.setCity(aCity);
         }
         if(!aState.isEmpty()){
             theAddress.setHomeState(aState);
         }
         if(!aZipCode.isEmpty()){
             theAddress.setZipCode(aZipCode);
         }
         
         Model.updateTheUser(theUser);
         Model.updateTheMember(theMember);
         Model.updateTheAddress(theAddress);
         
         return theMember.getMemberID();




    }

    static String printTheFullMemberDetails(DB_member_table theUpdatedMember, DB_user_table theUpdatedUser, DB_address_table theUpdatedAddress) {
         return "\nUpdated User information:\n" +
                 "\nUser:           " + theUpdatedUser.getUserName() + 
                 "\npassword:       " + theUpdatedUser.getPassword() + 
                 "\nName:           " + theUpdatedMember.getFName() + " " + theUpdatedMember.getMName() + " " + theUpdatedMember.getLName()+
                 "\nPhone:          " + theUpdatedMember.getPhone()+
                 "\nPhone Type:     " + theUpdatedMember.getPhoneType()+
                 "\nE-Mail:         " + theUpdatedMember.getEmail() + 
                 "\nStreet Address: " + theUpdatedAddress.getStreetAddress() + 
                 "\nCity:           " + theUpdatedAddress.getCity() + 
                 "\nState:          " + theUpdatedAddress.getHomeState() + 
                 "\nZip Code:       " + theUpdatedAddress.getZipCode() + 
                 "\n\n\n";
    }

    static String deleteMemberRecords(Integer user, String YESorNO) {
         if (YESorNO.equalsIgnoreCase("Y")){
             DB_member_table aMember = Model.showMemberByID(user);
             Model.deletMembersRecord(aMember);
             return "User Removed!";
         } else {
             return "User Not Removed, Returning to Main Menu";
         }
    }

    static void addJSONArrayToDB(DB_member_table theMember, JSONArray userSkillList) {
        
        theMember.setSkillsID(userSkillList.toString());
        
        Model.updateTheMember(theMember);
        
        
    }


    static JSONArray makeJSONArrayForMember(DB_member_table theMember) {
//        String newString = theMember.getSkillsID().replaceAll("[\"]", "").replace("[", "").replace("]", "");
//        String[] temp = newString.split(",");
//        System.out.println("This is theMember.getSkillsID() in Control " + newString );
        JSONArray theList = new JSONArray();
        String[] temp = theMember.getSkillsID().replaceAll("[\"]", "").replace("[", "").replace("]", "").split(",");
        for(int i=0; i<temp.length; i++){
        theList.add(temp[i]);            
        }
        return theList;
    }

//    static void ckForEndOfUserInput(String x) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    





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

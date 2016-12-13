/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernateportfolio;

import antlr.StringUtils;
import antlr.collections.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import org.json.simple.JSONArray;

/**
 *
 * @author gab
 */
public class View {


    Scanner userInput = new Scanner(System.in);
    
    public static void main(String[] args){
        View view = new View();
        boolean logOut = false;
        
        while (!logOut){
//            logOut = view.mainMenu();
            logOut = view.userLogin();
//            logOut = view.DBTESTlistUser();
        }
        
        System.exit(0);
        
    }
    
    
    private boolean userLogin(){
        boolean logOut = false;
        
        while (!logOut){
            String username = null;
            String password = null;
            DB_user_table user = new DB_user_table();
            
            System.out.println("\nFor testing\nAdministrator Menu access:\nU: gab4   P: gab4\nUser Menu access:\nU: matt5  P: matt5");
            System.out.println("\n\nWelcom to Skills Resource Assistant\nPlease enter: ");
// disabled for testing
//            username = VUserName(user);
//            password = VPassword(user);

// remove after testing
            String fakeUserName = "gab4";
// Remove after testing            
//            String fakeUserName = "matt5";
// Remove after testing            
            username = fakeUserName;
// Remove after testing            
            password = fakeUserName;
            
            
            boolean isAdmin = Control.ckAdmin(Control.userLogin(username, password));
            boolean isMemberActive = Control.ckIsActive(Control.userLogin(username, password));
            
            isAdmin = Control.ckIfActive(isAdmin, isMemberActive);
            
            while (isAdmin && !logOut){
                logOut = AdministratorMenu();
// remove after program is working
//                logOut = adminMainMenu();
            }
            
            while (!isAdmin && !logOut){
                logOut = endUser();
// remove after program is working
//              logOut = userMainMenu();
            }
             logOut = true;
        }
        return logOut;
    }
    
    private boolean AdministratorMenu(){
        boolean logOut = false;
        
        while (!logOut){
            Integer choice = null;
            
            System.out.println("\nAdministrator Main Menu");
            
            // FUTURE PLANNING: place while loop for main menu here
            // and remove unneeded System.out.println()'s
            
            System.out.println(" 1 - Add User                 - Working(see comments)");
            System.out.println(" 2 - List All User's          - FINISHED");
            System.out.println(" 3 - List User by name search - Working(see comments)");
            System.out.println(" 4 - List inactive users      - FINISHED");
            System.out.println(" 5 - Update Member            - FINISHED");
            System.out.println(" 6 - Remove Member            - FINISHED");
            System.out.println(" 7 - Add to Member Skills List");
            System.out.println(" 8 - List Member Skills List");
            System.out.println(" 9 - QUIT");
            System.out.println("\nPlease make a Selection");
            
            while (choice == null){
            choice = getANumber();
            }
//            try{
//                choice = Integer.parseInt(userInput.nextLine());
//            } catch (NumberFormatException e) {
//                System.out.println();
//                System.out.println("Invalid Entry, please try again.");
//                System.out.println();
//                return false;
//            }
            
            switch (choice){
                
                case 1:
                    VCreateRecord();
                    break;
                    
                case 2:
                    VListAllUser();
                    break;
                
                case 3:
                    VListUserByName();
                    break;
                
                case 4:
                    VListUserByInActive();
                    break;
                
                case 5:
                    VEditRecord();
                    break;
                    
                case 6:
                    VHideRecord();
                    break;
                    
                case 7:
                    VaddSkillToUser();
                    break;
                
                case 8:
                    VlistSkillsofUser();
                    break;
                
                case 9:
                    logOut = true;
                    break;
                
                default:
                    System.out.println("\n\nInvalid Entry, please try again.");
                    break;
            }
        }
        
        return logOut;
    
    }

    private boolean endUser(){
        boolean logOut = false;
        
        while (!logOut){
            Integer choice = null;
            
            System.out.println();
            System.out.println("Main Menu");
            
            // FUTURE PLANNING: place while loop for main menu here
            // and remove unneeded System.out.println()'s
            
            System.out.println("Search Skills List by:");
            System.out.println("----------------------");
            System.out.println(" 1 - Category & Name");
            System.out.println(" 2 - Skill Name");
            System.out.println(" 3 - QUIT");
            
            System.out.println("Please make a Selection");
            
            while (choice == null){
            choice = getANumber();
            }
            
            switch (choice){
                
                case 1:
                    VSearchCategoryAndName();
                    break;
                    
                case 2:
                    VSearchSkillName();
                    break;
                
                case 3:
                    logOut = true;
                    break;
                
                default:
                    System.out.println("\n\nInvalid Entry, please try again.");
                    break;
            }
        }
        
        return logOut;
    
    }










    /**
     *
     * Administrator View Methods
     * 
     */

    private String VUserName(DB_user_table user){
// Skills Resource Assistant ~ method        
         System.out.print("User Name: " + Control.ckForUserName(user));
         return userInput.nextLine();
    }

    private String VPassword(DB_user_table user){
// Skills Resource Assistant ~ method        
         System.out.print("Password:  " + Control.ckForPassword(user));
         return userInput.nextLine();
    }

    private String VIsAdmin(DB_user_table user){
// Skills Resource Assistant ~ method        
         System.out.print("Administrator\n(y/n):  " + Control.ckForAdmin(user));
         return userInput.nextLine();
    }

    private String VFirstName(DB_member_table user){
// Skills Resource Assistant ~ method        
         System.out.print("First Name:\n::::  " + Control.ckForFirstName(user));
         return userInput.nextLine();
    }

    private String VMiddleName(DB_member_table user){
// Skills Resource Assistant ~ method        
         System.out.print("Middle Name:\n::::  " + Control.ckForMiddleName(user));
         return userInput.nextLine();
    }

    private String VLastName(DB_member_table user){
// Skills Resource Assistant ~ method        
         System.out.print("Last Name:\n::::  " + Control.ckForLastName(user));
         return userInput.nextLine();
    }

    private String VPhone(DB_member_table user){
// Skills Resource Assistant ~ method        
         System.out.print("Phone Number:\n::::  " + Control.ckForPhone(user));
         return userInput.nextLine();
    }

    private Integer VPhoneType(DB_member_table user){
// Skills Resource Assistant ~ method        
         System.out.print("Phone Type?\n1-Home, 2-cell, 3-business\n::::  " + Control.ckForPhoneType(user));
         Integer oldNumber = user.getPhoneType();
         Integer number = null;
         while (oldNumber==null){
             while (number==null){
                 return getANumber();
             }
         }
         
        try{
            number = Integer.parseInt(userInput.nextLine());
        } catch (NumberFormatException e) {
            if (number==null){
                return number = oldNumber;
            } else {
             System.out.println("\n\nInvalid Entry, please try again.");
             return null;
            }}
         
         
         return number;
    }

    private String VEmail(DB_member_table user){
// Skills Resource Assistant ~ method        
         System.out.print("Email Address:\n::::  " + Control.ckForEmail(user));
         return userInput.nextLine();
    }

    private String VStreetAddress(DB_address_table user){
// Skills Resource Assistant ~ method        
         System.out.print("Street Address\n::::  " + Control.ckForStreetAdress(user));
         return userInput.nextLine();
    }

    private String VCity(DB_address_table user){
// Skills Resource Assistant ~ method        
         System.out.print("City\n::::  " + Control.ckForCity(user));
         return userInput.nextLine();
    }

    private String VState(DB_address_table user){
// Skills Resource Assistant ~ method        
         System.out.print("State\n::::  " + Control.ckForState(user));
         return userInput.nextLine();
    }

    private String VZipCode(DB_address_table user){
// Skills Resource Assistant ~ method        
         System.out.print("Zip Code\n::::  " + Control.ckForZipCode(user));
         return userInput.nextLine();
    }
    
    private Integer getANumber(){
        Integer numBer = null;
        try{
            numBer = Integer.parseInt(userInput.nextLine());
        } catch (NumberFormatException e) {
             System.out.println("\n\nInvalid Entry, please try again.");
             return null;
            }
        return numBer;            
    }
    

    private void VCreateRecord() {
// Skills Resource Assistant ~ method    
// METHOD working - See STUB statment for more info
        System.out.println("VCreateRecord() - STUB Needs final touches.");
        System.out.println("Add check for user name in DB before accepting.");
        System.out.println("Add check that phone num is 10 digits");
        System.out.println("Add check that email address is valid format");

        System.out.println("\nTo create a new record\nPlease Enter the following:\n");
        
        DB_user_table theUser = null;
        DB_member_table theMember = null;
        DB_address_table theAddress = null;
        
         String aUserName = VUserName(theUser);
         String aPassword = VPassword(theUser);
         String aIsAdmin = VIsAdmin(theUser);
         String aFirstName = VFirstName(theMember);
         String aMiddelName = VMiddleName(theMember);
         String aLastName = VLastName(theMember);
         String aPhone = VPhone(theMember);
         Integer aPhoneType = VPhoneType(theMember);
         String aEmail = VEmail(theMember);
         String aStreetAddress = VStreetAddress(theAddress);
         String aCity = VCity(theAddress);
         String aState = VState(theAddress);
         String aZipCode = VZipCode(theAddress);

        Control.creatUserRecord(aUserName,aPassword,aIsAdmin,aFirstName, aMiddelName,aLastName,aPhone, aPhoneType,aEmail, aStreetAddress,aCity, aState, aZipCode);
    }

    private void VListAllUser() {
// Skills Resource Assistant ~ method
// METHOD COMPLETE
         Iterator<DB_member_table> iteratedUsers = Control.listMemberTable().iterator();
         System.out.printf("%-10s%-20s%-20s\n","ID","First Name", "Last Name");
         System.out.printf("%-10s%-20s%-20s\n","--","----------", "---------");
         while(iteratedUsers.hasNext()){
             DB_member_table user = iteratedUsers.next();
             System.out.printf("%-10s%-20s%-20s\n", user.getMemberID(),user.getFName(), user.getLName());
         }
    }

    private void VListUserByName() {
// Skills Resource Assistant ~ method        
// METHOD working - needs an escape path
         System.out.println("\nPlease enter the name of a user to search for, \nor Enter to return to main menu:");
         String searchedUser = null;
         try{
             searchedUser = userInput.nextLine();
         } catch (NumberFormatException e) {
             System.out.println("\n\nInvalid Entry, please try again.");
             return;
         }
         
    //NEED to ADD AN ESCAPE PATH
         
         //Control.exit(Integer.parseInt(searchedUser));
         
         Iterator<DB_member_table> iteratedUsers = Control.listSearchedMemberTable(searchedUser).iterator();
         System.out.printf("%-10s%-20s%-20s\n","ID","First Name", "Last Name");
         System.out.printf("%-10s%-20s%-20s\n","--","----------", "---------");
         while(iteratedUsers.hasNext()){
             DB_member_table user = iteratedUsers.next();
             System.out.printf("%-10s%-20s%-20s\n", user.getMemberID(),user.getFName(), user.getLName());
         }
    }

    private void VListUserByInActive() {
// Skills Resource Assistant ~ method        
// METHOD COMPLETE
         Iterator<DB_member_table> iteratedUsers = Control.listIsActiveMemberTable().iterator();
         System.out.printf("%-10s%-20s%-20s\n","ID","First Name", "Last Name");
         System.out.printf("%-10s%-20s%-20s\n","--","----------", "---------");
         while(iteratedUsers.hasNext()){
             DB_member_table user = iteratedUsers.next();
             System.out.printf("%-10s%-20s%-20s\n", user.getMemberID(), user.getFName(), user.getLName());
         }
        
    }

    private void VEditRecord() {
// Skills Resource Assistant ~ method
// FUTURE UPDATE - Call a new menu to list all user or search by user name

         VListAllUser();
         
         System.out.println("\nPlease select a User to update from the list, or 0 to return to main menu:\n");
         Integer user = null;
         try{
             user = Integer.parseInt(userInput.nextLine());
         } catch (NumberFormatException e) {
             System.out.println("\n\nInvalid Entry, please try again.");
             return;
         }
         
         Control.exit(user);

         DB_member_table theMember = Control.findMember(user);
         DB_user_table theUser = Control.findUser(theMember);
         DB_address_table theAddress = Control.findAddress(theMember);
         
         System.out.println("\nUpdating: " + theMember.getFName() + " " + theMember.getMName() + " " + theMember.getLName() + 
                 "\nEnter the corrected Information or press enter to keep the current Information just press Enter....");
         
         String aUserName = VUserName(theUser);
         String aPassword = VPassword(theUser);
         String aIsAdmin = VIsAdmin(theUser);
         String aFirstName = VFirstName(theMember);
         String aMiddelName = VMiddleName(theMember);
         String aLastName = VLastName(theMember);
         String aPhone = VPhone(theMember);
         Integer aPhoneType = VPhoneType(theMember);
         String aEmail = VEmail(theMember);
         String aStreetAddress = VStreetAddress(theAddress);
         String aCity = VCity(theAddress);
         String aState = VState(theAddress);
         String aZipCode = VZipCode(theAddress);

         user = Control.updateMemberRecord(aUserName,aPassword,aIsAdmin,aFirstName, aMiddelName,aLastName,aPhone, aPhoneType,aEmail, aStreetAddress,aCity, aState, aZipCode, theUser, theMember, theAddress);
         DB_member_table theUpdatedMember = Control.findMember(user);
         DB_user_table theUpdatedUser = Control.findUser(theMember);
         DB_address_table theUpdatedAddress = Control.findAddress(theMember);
         
         System.out.println(Control.printTheFullMemberDetails(theUpdatedMember, theUpdatedUser, theUpdatedAddress) + "\n\n");
         
    }

    private void VHideRecord() {
// Skills Resource Assistant ~ method        
        System.out.println("VHideRecord() - STUB Not supported yet.");
//        INSERT INTO `DB_user_table` (`userID`, `username`, `password`, `adminuser`, `isActive`, `memberID`) VALUES ('1008', 'rierubeirb', 'eriubeirb', '0', '0', '1008');

// Sends to different method that will be depreciated later
        VRemoveMemberRecord();
    }
    
    
    private void VRemoveMemberRecord(){
// Skills Resource Assistant ~ method        
// METHOD COMPLETE
         System.out.println("Member delete user stub, \nthis will not be part of the normal program\n");
         
         VListAllUser();
         
         System.out.println("\nPlease select a User to Remove from the list,\nor 0 to return to main menu:");
         
         Integer user = null;
         
         try{
             user = Integer.parseInt(userInput.nextLine());
         } catch (NumberFormatException e) {
             System.out.println("\n\nInvalid Entry, please try again.");
             return;
         }
    
         Control.exit(user);
    
         System.out.println("Please confirm remove USER (Y/N)\nCaution: This can not be undone!");
    
         String YESorNO = userInput.nextLine();
        
         System.out.println("\n" + Control.deleteMemberRecords(user,YESorNO) + "\n");
    
    }

    private void VaddSkillToUser() {
// Skills Resource Assistant ~ method        
        
         VListAllUser();
         
         System.out.println("\nPlease select a User to update from the list, or 0 to return to main menu:\n");
         Integer user = null;
         try{
             user = Integer.parseInt(userInput.nextLine());
         } catch (NumberFormatException e) {
             System.out.println("\n\nInvalid Entry, please try again.");
             return;
         }
         
         Control.exit(user);

         DB_member_table theMember = Control.findMember(user);
         
         System.out.println("\nUpdating: " + theMember.getFName() + " " + theMember.getMName() + " " + theMember.getLName() + 
                 "\nEnter a Skill followed by <ENTER> for each Skill"+
                         "\nWhen done Press Enter to save the Skill list.");
         
         JSONArray userSkillList = VuserSkillList();
         
         Control.addJSONArrayToDB(theMember,userSkillList);
         
    }
     
    private JSONArray VuserSkillList() {
// Skills Resource Assistant ~ method        
        JSONArray userInputSkillList = new JSONArray();
        
        String x = null;
        
        do{
            x=userInput.nextLine();
            
//            Control.ckForEndOfUserInput(x);
            
            if(x==null || "".equals(x)){
                break;
            } else {
                userInputSkillList.add(x);
            }
            
            
        }while(true);
        return userInputSkillList;
    }





    private void VlistSkillsofUser() {
// Skills Resource Assistant ~ method        
         VListAllUser();
         
         System.out.println("\nPlease select a User to update from the list, or 0 to return to main menu:\n");
         Integer user = null;
         try{
             user = Integer.parseInt(userInput.nextLine());
         } catch (NumberFormatException e) {
             System.out.println("\n\nInvalid Entry, please try again.");
             return;
         }
         
         Control.exit(user);

         DB_member_table theMember = Control.findMember(user);
         
         JSONArray MemberSkillList = new JSONArray();
         MemberSkillList = Control.makeJSONArrayForMember(theMember);
         
         
         System.out.println("\nSkills List For: \n" + theMember.getFName() + " " + theMember.getMName() + " " + theMember.getLName() + "\n\n");
        
        System.out.println(MemberSkillList);
        
        
        
        
        
        
    }



    /**
     *
     * User View Methods
     * 
     */




    
    
    
    
    private void VSearchCategoryAndName() {
// Skills Resource Assistant ~ method        
        System.out.println("VSearchCategoryAndName() - STUB Not supported yet.");
    }

    private void VSearchSkillName() {
// Skills Resource Assistant ~ method        
        System.out.println("VSearchSkillName() - STUB Not supported yet.");
    }




// *************************************************************************************************
// *************************************************************************************************
// *************************************************************************************************
// *************************************************************************************************
// *************************************************************************************************
// *************************************************************************************************
// *************************************************************************************************
// *************************************************************************************************
// *************************************************************************************************
// *************************************************************************************************
// *************************************************************************************************
// *************************************************************************************************
// *************************************************************************************************
// *************************************************************************************************
// *************************************************************************************************
// *************************************************************************************************
    



















    

    /**
     *
     * @return
     * 
     */
    public boolean adminMainMenu(){
        boolean logOut = false;
        
        while (!logOut){
            Integer choice = null;
            
            System.out.println();
            System.out.println("Administrator Main Menu");
            
            // FUTURE PLANNING: place while loop for main menu here
            // and remove unneeded System.out.println()'s
            
            System.out.println(" 1 - Add User");
            System.out.println(" 2 - List All User's");
            System.out.println(" 3 - List User by name search");
            System.out.println(" 4 - Update User");
            System.out.println(" 5 - Remove User");
            System.out.println(" 6 - QUIT");
            
            System.out.println("Please make a Selection");
            
            try{
                choice = Integer.parseInt(userInput.nextLine());
            } catch (NumberFormatException e) {
                System.out.println();
                System.out.println("Invalid Entry, please try again.");
                System.out.println();
                return false;
            }
            
            switch (choice){
                
                case 1:
                    VcreatUser();
                    break;
                    
                case 2:
                    VlistUser();
                    break;
                
                case 3:
                    VlistSearchedUser();
                    break;
                
                case 4:
                    VupdateUser();
                    break;
                    
                case 5:
                    VdeleteUser();
                    break;
                    
                case 6:
                    logOut = true;
                    break;
                
                default:
                    System.out.println();
                    System.out.println("Invalid Entry, please try again.");
                    System.out.println();
                    break;
                    
            }
            
        }
        
        return logOut;
        
    }
    
    
    private void VcreatUser(){
        Integer user = null;
        System.out.println();
        System.out.println("Please Enter the following");

        String aUserName = VsystemInputUserName(user);
        String aCreatedBy = VsystemInputCreatedBy(user);

        Control.creatUser(aUserName,aCreatedBy);
        System.out.println();
        
        
    }
    
    private void VlistUser(){
         UsersCurrentlyInDatabase();
         Iterator<DB_user> iteratedUsers = Control.listUser().iterator();
         while(iteratedUsers.hasNext()){
             DB_user user = iteratedUsers.next();
             System.out.printf("%-10s%-20s%-20s%-20s\n", user.getUserId(),user.getUsername(),user.getCreatedBy(),user.getCreatedDate());
         }
    }
    
    private void VlistSearchedUser(){
         System.out.println("");
         System.out.println("Please enter the name of a user to search for, or Enter to return to main menu:");
         String searchedUser = null;
         try{
             searchedUser = userInput.nextLine();
         } catch (NumberFormatException e) {
             System.out.println();
             System.out.println("Invalid Entry, please try again.");
             System.out.println();
             return;
         }
         
    //NEED to ADD AN ESCAPE PATH
         
         //Control.exit(Integer.parseInt(searchedUser));
         
         UsersCurrentlyInDatabase();
         Iterator<DB_user> iteratedUsers = Control.listSearchedUser(searchedUser).iterator();
         while(iteratedUsers.hasNext()){
             DB_user user = iteratedUsers.next();
             System.out.printf("%-10s%-20s%-20s%-20s\n", user.getUserId(),user.getUsername(),user.getCreatedBy(),user.getCreatedDate());
         }
    }
    
   
   
   
   
    
    private void VupdateUser(){
         String aUserName = null;
         String aCreatedBy = null;
         
         VlistUser();
         
         System.out.println("");
         System.out.println("Please select a User to update from the list, or 0 to return to main menu:");
         Integer user = null;
         try{
             user = Integer.parseInt(userInput.nextLine());
         } catch (NumberFormatException e) {
             System.out.println();
             System.out.println("Invalid Entry, please try again.");
             System.out.println();
             return;
         }
         
         Control.exit(user);
         DB_user updateUser = Control.updateUser(user);
         
         System.out.println("");
         System.out.println("Updating User: " + updateUser.getUsername());
         System.out.println("");
         System.out.println("Enter the corrected Information or press enter to keep the current Information just press Enter....");
         
         aUserName = VsystemInputUserName(user);
         aCreatedBy = VsystemInputCreatedBy(user);
         
         Control.updateTheUser(user,aUserName,aCreatedBy);
         
         System.out.println();
         updateUser = Control.updateUser(user);
         
    // added the new user lised here
         
         System.out.println("Updated User information:");
         System.out.println("User:       " + updateUser.getUsername());
         System.out.println("CREATED_BY: " + updateUser.getCreatedBy());
         
         System.out.println();
         System.out.println();
         
    }
    
    private void VdeleteUser(){
    
         System.out.println("delete user stub");
         VlistUser();
    
         System.out.println("");
         System.out.println("Please select a User to Remove from the list, ");
         System.out.println("or 0 to return to main menu:");
         Integer user = null;
         try{
             user = Integer.parseInt(userInput.nextLine());
         } catch (NumberFormatException e) {
             System.out.println();
             System.out.println("Invalid Entry, please try again.");
             System.out.println();
             return;
         }
    
         Control.exit(user);
    
         System.out.println("Please confirm remove USER (Y/N)");
         System.out.println("Caution: This can not be undone!");
    
         String YESorNO = userInput.nextLine();
        
         System.out.println("");
         System.out.println(Control.deleteUser(user,YESorNO));
         System.out.println("");
    }
    
    private String VsystemInputUserName(Integer user){
         System.out.print("User Name:       " + Control.ckUser(user) + "   ");
         String aUserName = Control.ckForUser(user,userInput.nextLine());
         return aUserName;
    }

    private String VsystemInputCreatedBy(Integer user){
         System.out.print("User CREATED_BY: " + Control.ckCreatedBy(user) + "   ");
         String aCreatedBy = Control.ckForCreatedBy(user,userInput.nextLine());
         return aCreatedBy;
    }
     
    private void UsersCurrentlyInDatabase(){
         System.out.println("Users currently in Database");
         System.out.printf("%-10s%-20s%-20s%-20s\n","user_id","username","created_by","created_date");
         System.out.printf("%-10s%-20s%-20s%-20s\n","+++++++","++++++++","++++++++++","++++++++++++");
         System.out.println();
    }
    
    
// THIS IS TESTING AREA
    
        private boolean DBTESTlistUser(){
         UsersCurrentlyInDatabase();
         Iterator<DB_user_table> iteratedUsers = Control.DBTESTlistUser().iterator();
         while(iteratedUsers.hasNext()){
             DB_user_table user = iteratedUsers.next();
             System.out.printf("%-10s%-20s%-20s\n", user.getUserName(),user.getPassword(),user.getAdminUser());
         }
         
         return true;
    }

    private boolean userMainMenu() {
        boolean logOut = false;
        
        while (!logOut){
            Integer choice = null;
            
            System.out.println();
            System.out.println("Main Menu");
            
            // FUTURE PLANNING: place while loop for main menu here
            // and remove unneeded System.out.println()'s
            
            System.out.println(" 1 - List All User's");
            System.out.println(" 2 - List User by name search");
            System.out.println(" 3 - QUIT");
            
            System.out.println("Please make a Selection");
            
            try{
                choice = Integer.parseInt(userInput.nextLine());
            } catch (NumberFormatException e) {
                System.out.println();
                System.out.println("Invalid Entry, please try again.");
                System.out.println();
                return false;
            }
            
            switch (choice){
                
                case 1:
                    VlistUser();
                    break;
                
                case 2:
                    VlistSearchedUser();
                    break;
                
                case 3:
                    logOut = true;
                    break;
                
                default:
                    System.out.println();
                    System.out.println("Invalid Entry, please try again.");
                    System.out.println();
                    break;
                    
            }
            
        }
        
        return logOut;
        
    }









    
    
}

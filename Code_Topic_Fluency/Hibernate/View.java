/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernateportfolio;

import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author gab
 */
public class View {


    Scanner userInput = new Scanner(System.in);
    
    public static void main(String[] args){
        View view = new View();
        boolean stopUsing = false;
        
        while (!stopUsing){
//            stopUsing = view.mainMenu();
            stopUsing = view.userLogin();
//            stopUsing = view.DBTESTlistUser();
        }
        
        System.exit(0);
        
    }
    
    
    private boolean userLogin(){
        boolean stopUsing = false;
        
        while (!stopUsing){
            String username = null;
            String password = null;
            Integer user = null;
            
            System.out.println("For testing");
            System.out.println("Administrator Menu access:");
            System.out.println("U: gab4   P: gab4");
            System.out.println();
            System.out.println("User Menu access:");
            System.out.println("U: matt5  P: matt5");
            System.out.println();
            System.out.println();
            System.out.println("Welcom to Skills Resource Assistant");
            System.out.println("Please enter: ");
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
            
            while (isAdmin && !stopUsing){
                stopUsing = Administrator();
// remove after program is working
//                stopUsing = adminMainMenu();
            }
            
            while (!isAdmin && !stopUsing){
                stopUsing = endUser();
// remove after program is working
//              stopUsing = userMainMenu();
            }
             stopUsing = true;
        }
        return stopUsing;
    }
    
    private boolean Administrator(){
        boolean stopUsing = false;
        
        while (!stopUsing){
            Integer choice = null;
            
            System.out.println();
            System.out.println("Administrator Main Menu");
            
            // FUTURE PLANNING: place while loop for main menu here
            // and remove unneeded System.out.println()'s
            
            System.out.println(" 1 - Add User");
            System.out.println(" 2 - List All User's          - FINISHED");
            System.out.println(" 3 - List User by name search - FINSIHED");
            System.out.println(" 4 - List inactive users      - FINISHED");
            System.out.println(" 5 - Update User");
            System.out.println(" 6 - Remove User");
            System.out.println(" 7 - Search Skills List");
            System.out.println(" 8 - QUIT");
            
            System.out.println("Please make a Selection");
            
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
                    VSearchSkillList();
                    break;
                
                case 8:
                    stopUsing = true;
                    break;
                
                default:
                    System.out.println();
                    System.out.println("Invalid Entry, please try again.");
                    System.out.println();
                    break;
            }
        }
        
        return stopUsing;
    
    }

    private boolean endUser(){
        boolean stopUsing = false;
        
        while (!stopUsing){
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
                    VSearchCategoryAndName();
                    break;
                    
                case 2:
                    VSearchSkillName();
                    break;
                
                case 3:
                    stopUsing = true;
                    break;
                
                default:
                    System.out.println();
                    System.out.println("Invalid Entry, please try again.");
                    System.out.println();
                    break;
            }
        }
        
        return stopUsing;
    
    }










    /**
     *
     * Administrator View Methods
     * 
     */

    private String VUserName(Integer user){
// Skills Resource Assistant ~ method        
         System.out.print("User Name: ");
         return userInput.nextLine();
    }

    private String VPassword(Integer user){
// Skills Resource Assistant ~ method        
         System.out.print("Password:  ");
         return userInput.nextLine();
    }

    private String VIsAdmin(Integer user){
// Skills Resource Assistant ~ method        
         System.out.print("Administrator\n(y/n):  ");
         return userInput.nextLine();
    }

    private String VFirstName(Integer user){
// Skills Resource Assistant ~ method        
         System.out.print("First Name:\n::::  ");
         return userInput.nextLine();
    }

    private String VMiddleName(Integer user){
// Skills Resource Assistant ~ method        
         System.out.print("Middle Name:\n::::  ");
         return userInput.nextLine();
    }

    private String VLastName(Integer user){
// Skills Resource Assistant ~ method        
         System.out.print("Last Name:\n::::  ");
         return userInput.nextLine();
    }

    private String VPhone(Integer user){
// Skills Resource Assistant ~ method        
         System.out.print("Phone Number:\n::::  ");
         return userInput.nextLine();
    }

    private Integer VPhoneType(Integer user){
// Skills Resource Assistant ~ method        
         System.out.print("Phone Type?\n1-Home, 2-cell, 3-business\n::::  ");
         Integer number = null;
         
         while (number==null){
         number = getANumber();
         }
         
         return number;
    }

    private String VEmail(Integer user){
// Skills Resource Assistant ~ method        
         System.out.print("Email Address:\n::::  ");
         return userInput.nextLine();
    }

    private String VStreetAddress(Integer user){
// Skills Resource Assistant ~ method        
         System.out.print("Street Address\n::::  ");
         return userInput.nextLine();
    }

    private String VCity(Integer user){
// Skills Resource Assistant ~ method        
         System.out.print("City\n::::  "+"");
         return userInput.nextLine();
    }

    private String VState(Integer user){
// Skills Resource Assistant ~ method        
         System.out.print("State\n::::  ");
         return userInput.nextLine();
    }

    private String VZipCode(Integer user){
// Skills Resource Assistant ~ method        
         System.out.print("Zip Code\n::::  ");
         return userInput.nextLine();
    }
    
    private Integer getANumber(){
        Integer numBer = null;
        try{
            numBer = Integer.parseInt(userInput.nextLine());
        } catch (NumberFormatException e) {
             System.out.println();
             System.out.println("Invalid Entry, please try again.");
             System.out.println();
             return null;
            }
        return numBer;            
    }
    

    private void VCreateRecord() {
// Skills Resource Assistant ~ method    
        System.out.println("VCreateRecord() - STUB Not supported yet.");
        Integer user = null;
        System.out.println();
        System.out.println("To create a new record" );
        System.out.println("Please Enter the following~");

//        String aUserName = VUserName(user);
//        String aPassword = VPassword(user);
//        String aIsAdmin = VIsAdmin(user);
//        String aFirstName = VFirstName(user);
//        String aMiddelName = VMiddleName(user);
//        String aLastName = VLastName(user);
        String aPhone = VPhone(user);
//        Integer aPhoneType = null;
//        while (aPhoneType == null){aPhoneType = VPhoneType(user);}
//        String aEmail = VEmail(user);
//        String aStreetAddress = VStreetAddress(user);
//        String aCity = VCity(user);
//        String aState = VState(user);
//        String aZipCode = VZipCode(user);
        
//        String aUserName = "newUser";
//        String aPassword = "password";
//        String aIsAdmin = "y";
//        String aFirstName = "NewDude";
//        String aMiddelName = "is";
//        String aLastName = "Here";
//        String aPhone = "214-568-7519";
//        Integer aPhoneType = 2;
//        String aEmail = "dude@dude.com";
//        String aStreetAddress = "321654 the steet";
//        String aCity = "DudesTown";
//        String aState = "TX";
//        String aZipCode = "98732";
        
        String aUserName = "srjbg";
        String aPassword = "password";
        String aIsAdmin = "n";
        String aFirstName = "sjfb";
        String aMiddelName = "B";
        String aLastName = "Doe";
//        String aPhone = "214-568-7519";
        Integer aPhoneType = 2;
        String aEmail = "dudes@dude.com";
        String aStreetAddress = "321654 a steet";
        String aCity = "DudersTown";
        String aState = "TX";
        String aZipCode = "98732";


        Control.creatUserRecord(aUserName,aPassword,aIsAdmin,aFirstName, aMiddelName,aLastName,aPhone, aPhoneType,aEmail, aStreetAddress,aCity, aState, aZipCode);
        System.out.println();
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
        System.out.println("VListUserByName() - STUB Not supported yet.");
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
//Call a new menu???
        System.out.println("VEditRecord() - STUB Not supported yet.");
        
    }

    private void VHideRecord() {
// Skills Resource Assistant ~ method        
        System.out.println("VHideRecord() - STUB Not supported yet.");
    }

    private void VSearchSkillList() {
// Skills Resource Assistant ~ method        
        System.out.println("VSearchSkillList() - STUB Not supported yet.");
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
        boolean stopUsing = false;
        
        while (!stopUsing){
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
                    stopUsing = true;
                    break;
                
                default:
                    System.out.println();
                    System.out.println("Invalid Entry, please try again.");
                    System.out.println();
                    break;
                    
            }
            
        }
        
        return stopUsing;
        
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
        boolean stopUsing = false;
        
        while (!stopUsing){
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
                    stopUsing = true;
                    break;
                
                default:
                    System.out.println();
                    System.out.println("Invalid Entry, please try again.");
                    System.out.println();
                    break;
                    
            }
            
        }
        
        return stopUsing;
        
    }








    
    
}

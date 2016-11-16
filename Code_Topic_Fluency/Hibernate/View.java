/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernateportfolio;

import java.util.Iterator;
import java.util.List;
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
            stopUsing = view.mainMenu();
        }
        
        System.exit(0);
        
    }
    
    private boolean mainMenu(){
        boolean stopUsing = false;
        
        while (!stopUsing){
            Integer choice = null;
            
            System.out.println();
            System.out.println("Main Menu");
            
            // place while loop for main menu here
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

// The following code was change to add ACP compliance to the program 
//        System.out.print("User Name:  ");
//        String aUserName = userInput.nextLine();
//        System.out.print("Created By:  ");
//        String aCreatedBy = userInput.nextLine();

// The following was added for ACP compliance
        String aUserName = VsystemInputUserName(user);
        String aCreatedBy = VsystemInputCreatedBy(user);

        Control.creatUser(aUserName,aCreatedBy);
        System.out.println();
        
        
    }
    
    
    
    
    
    
    
    
    private void VlistUser(){
    
         System.out.println("Users currently in Database");
         System.out.printf("%-10s%-20s%-20s%-20s\n","user_id","username","created_by","created_date");
         System.out.printf("%-10s%-20s%-20s%-20s\n","+++++++","++++++++","++++++++++","++++++++++++");
         System.out.println();

         Iterator<DBUser> iteratedUsers = Control.listUser().iterator();

         while(iteratedUsers.hasNext()){
             DBUser user = iteratedUsers.next();
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
    
    
         System.out.println("Users currently in Database");
         System.out.printf("%-10s%-20s%-20s%-20s\n","user_id","username","created_by","created_date");
         System.out.printf("%-10s%-20s%-20s%-20s\n","+++++++","++++++++","++++++++++","++++++++++++");
         System.out.println();

//         Iterator<DBUser> iteratedUsers = Control.listUser().iterator();
         Iterator<DBUser> iteratedUsers = Control.listSearchedUser(searchedUser).iterator();

         while(iteratedUsers.hasNext()){
             DBUser user = iteratedUsers.next();
             System.out.printf("%-10s%-20s%-20s%-20s\n", user.getUserId(),user.getUsername(),user.getCreatedBy(),user.getCreatedDate());
         }
    }
    
   
   
   
   
    
    private void VupdateUser(){
    String aUserName = null;
    String aCreatedBy = null;
    
//    System.out.println("update user stub");
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
    DBUser updateUser = Control.updateUser(user);
        
    System.out.println("");
    System.out.println("Updating User: " + updateUser.getUsername());
    System.out.println("");
    System.out.println("Enter the corrected Information or press enter to keep the current Information just press Enter....");

// The following code was change to add ACP compliance to the program 

//    System.out.println("User Name:       " + updateUser.getUsername());
//    System.out.print("new User Name:   ");
//    aUserName = Control.ckForUser(user,userInput.nextLine());

//    System.out.println("User CREATED_BY: " + updateUser.getCreatedBy());
//    System.out.print("new CREATED_BY:  ");
//    aCreatedBy = Control.ckForCreatedBy(user,userInput.nextLine());

// add a confirm info is correst here
// to do that right the 16 lines above will need ot be moved 
// to a new method and called as a package
// IF done right the Add user could also call this method
// and the view would become ACP compliant 


// The following was added for ACP compliance
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
    
    
//    String Happened = Control.deleteUser(user,YESorNO);
        
    System.out.println("");
    System.out.println(Control.deleteUser(user,YESorNO));
    System.out.println("");
    
    
    
    }
    

// THESE ARE NOT FULLY WORKING

// changing code to ACP compliance
    
    private String VsystemInputUserName(Integer user){
//    DBUser updateUser = Control.updateUser(user);
    
    System.out.print("User Name:       " + Control.ckUser(user) + "   ");
    String aUserName = Control.ckForUser(user,userInput.nextLine());
    return aUserName;
    }

    private String VsystemInputCreatedBy(Integer user){
//    DBUser updateUser = Control.updateUser(user);
    
    System.out.print("User CREATED_BY: " + Control.ckCreatedBy(user) + "   ");
    String aCreatedBy = Control.ckForCreatedBy(user,userInput.nextLine());
    
    return aCreatedBy;
    }
     
 

    
}

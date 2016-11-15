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
            System.out.println(" 3 - Update User");
            System.out.println(" 4 - Remove User");
            System.out.println(" 5 - QUIT");
            
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
                    VupdateUser();
                    break;
                    
                case 4:
                    VdeleteUser();
                    break;
                    
                case 5:
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
    
    
    public void VcreatUser(){
        System.out.println();
        System.out.println("Please Enter the following");
        System.out.print("User Name:  ");
        String aUserName = userInput.nextLine();
        System.out.print("Created By:  ");
        String aCreatedBy = userInput.nextLine();

        Control.creatUser(aUserName,aCreatedBy);
        System.out.println();
        
        
    }
    
    
    
    
    
    
    
    
    public void VlistUser(){
    
//         System.out.println("list user stub");
         System.out.println("Users currently in Database");
         System.out.printf("%-10s%-20s%-20s%-20s\n","user_id","username","created_by","created_date");
//         System.out.printf("%-10s%-20s%-20s%-20s\n","*******","********","**********","************");
         System.out.printf("%-10s%-20s%-20s%-20s\n","+++++++","++++++++","++++++++++","++++++++++++");
//         System.out.printf("%-10s%-20s%-20s%-20s\n","_______","________","__________","____________");
//         System.out.println();
 
//Control.listUser() has a problm with the return value.
//         Iterator<User> iteratedUsers = (Iterator) Control.listUser();

// These next 2 lines should be in the Control and NOT HERE
// placed here for testing to confirm DB connection and While loop works
         List<DBUser> userList = Model.showAllUsers();
         Iterator<DBUser> iteratedUsers = userList.iterator();

// Sucesssssss!!!! This WHILE LOOP finally works!!!!!!!
         while(iteratedUsers.hasNext()){
             DBUser user = iteratedUsers.next();
             System.out.printf("%-10s%-20s%-20s%-20s\n", user.getUserId(),user.getUsername(),user.getCreatedBy(),user.getCreatedDate());
         }
    }
    
   
   
   
   
    
    public void VupdateUser(){
    
    System.out.println("update user stub");
    }
    
 
 
 
    
       
    public void VdeleteUser(){
    
    System.out.println("delete user stub");
    }
    

    
    
     
 

    
}

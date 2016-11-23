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
            
            System.out.println("For testing");
            System.out.println("Administrator Menu access:");
            System.out.println("U: gab4   P: gab4");
            System.out.println();
            System.out.println("User Menu access:");
            System.out.println("U: matt5  P: matt5");
            System.out.println();
            System.out.println();
            System.out.println("Welcom to Skills lister");
            System.out.print("Please enter user name: ");
            username = userInput.nextLine();
            System.out.print("Please enter password: ");
            password = userInput.nextLine();
            
//            DB_user_table theUser = Control.userLogin(username, password);
//            boolean isAdmin = Control.ckAdmin(theUser);
            
            boolean isAdmin = Control.ckAdmin(Control.userLogin(username, password));
            
            while (isAdmin && !stopUsing){
                stopUsing = adminMainMenu();
            }
            
            while (!isAdmin && !stopUsing){
                stopUsing = userMainMenu();
            }
            
             stopUsing = true;
        }
        
        return stopUsing;
    }
    
    
    
    
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
             System.out.printf("%-10s%-20s%-20s%-20s\n", user.getUserName(),user.getPassword(),user.getAdminUser(),user.getMember_ID());
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

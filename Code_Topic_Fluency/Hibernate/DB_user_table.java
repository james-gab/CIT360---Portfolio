/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernateportfolio;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author gab
 */





@Entity
@Table(name = "DB_user_table")
public class DB_user_table implements Serializable{
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "userID")
     private int userID;
    
    @Column(name = "username")
     private String userName;
    
    @Column(name = "password")
     private String password;
    
    @Column(name = "adminuser")
     private int adminUser;
    
    @OneToOne
    @JoinColumn(name = "memberID", nullable=false)
     private DB_member_table memberMapping;
    
    @Column(name = "isActive")
     private int isActive;
    
    public DB_user_table(){
    }
    


    public DB_user_table(Integer userID, String username, String password, Integer adminuser, DB_member_table id, Integer isActive){
        this.userID = userID;
        this.userName = username;
        this.password = password;
        this.adminUser = adminuser;        
//        this.memberMapping = id;
        this.isActive = isActive;
    }


    public String getUserName() {
        return userName;
    }
    public void setUserName(String username) {
        this.userName = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getAdminUser() {
        return adminUser;
    }
    public void setAdminUser(int adminuser) {
        this.adminUser = adminuser;
    }

    /**
     * @return the isActive
     */
    public int getIsActive() {
        return isActive;
    }

    /**
     * @param isActive the isActive to set
     */
    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    /**
     * @return the memberMapping
     */
    public DB_member_table getMemberMapping() {
        return memberMapping;
    }

    /**
     * @param memberMapping the memberMapping to set
     */
    public void setMemberMapping(DB_member_table memberMapping) {
        this.memberMapping = memberMapping;
    }

    /**
     * @return the userID
     */
    public int getUserID() {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernateportfolio;

/**
 *
 * @author gab
 */
 
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;



@Entity
@Table(name = "DBUSER")
public class DBUser implements Serializable{
 
@Id @GeneratedValue(strategy=GenerationType.IDENTITY)

@Column(name = "USER_ID")
 private int userId;
 
@Column(name = "USERNAME")
 private String username;
 
@Column(name = "CREATED_BY")
 private String createdBy;
 
@Column(name = "CREATED_DATE")
 private Date createdDate;
 
public DBUser(){
    
}
    
public DBUser(Integer id, String name, String by, Date date){
        this.userId = id;
        this.username = name;
        this.createdBy = by;
        this.createdDate = date;
    }
    
 
public int getUserId() {
 return userId;
 }
 public void setUserId(int userId) {
 this.userId = userId;
 }
 public String getUsername() {
 return username;
 }
 public void setUsername(String username) {
 this.username = username;
 }
 public String getCreatedBy() {
 return createdBy;
 }
 public void setCreatedBy(String createdBy) {
 this.createdBy = createdBy;
 }
 public Date getCreatedDate() {
 return createdDate;
 }
 public void setCreatedDate(Date createdDate) {
 this.createdDate = createdDate;
 }

 
}

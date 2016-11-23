/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernateportfolio;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

/**
 *
 * @author gab
 * 
 */

public class Model {
    
    /*
     * DB_user Database functions
     */
    
    
    
    
    
    
    static void insertUser(DB_user user) {
        Session session = DBSessionFactory.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
    }
    
    static void updateUser(DB_user updateDB){
        Session session = DBSessionFactory.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
	Query userDB = session.createQuery("Select u from DB_user as u where u.id = :uId");
	userDB.setParameter("uId", updateDB.getUserId());
	session.merge(updateDB);
        transaction.commit();
    }
    
    static void deletUser(DB_user user){
        Session session = DBSessionFactory.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
    }
    
    static DB_user showUserByID(Integer user){
        Session session = DBSessionFactory.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query userDB = (Query) session.createQuery("Select u from DB_user as u where u.id = :uId");
        userDB.setParameter("uId", user);
        DB_user theUser = (DB_user) userDB.uniqueResult();
        transaction.commit();
        return theUser;
    }
    
    static List<DB_user> showAllUsers(){
        Session session = DBSessionFactory.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query userDB = (Query) session.createQuery("Select u from DB_user as u");
        @SuppressWarnings("unchecked")
        List<DB_user> userList = userDB.list();
        transaction.commit();
        return userList;
    }
    
    static List<DB_user> showUserListByUniqueSearch(String user){
        Session session = DBSessionFactory.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query userDB = (Query) session.createQuery("from DB_user as u where u.username like :searchName");
        userDB.setParameter("searchName", "%"+user+"%");
        @SuppressWarnings("unchecked")
        List<DB_user> userList = userDB.list();
        transaction.commit();
        return userList;
    }
    
     

// NOT working below this line  -  YET
// http://javabeat.net/how-to-use-named-parameters-and-named-query-in-hibernate/

    static DB_user_table showUserByUniqueSearch(String user, String password){
        Session session = DBSessionFactory.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
//        Query userDB = (Query) session.createQuery("Select u from DB_user_table as u where u.userName = :username");
        Query userDB = (Query) session.createQuery("Select u from DB_user_table as u where u.userName = :username and u.password = :password");
//        Query userDB = (Query) session.createQuery("from DB_user_table as u where u.username = :username" );
        userDB.setParameter("username", user);
        userDB.setParameter("password", password);
        DB_user_table theUser = (DB_user_table) userDB.uniqueResult();
        transaction.commit();
        return theUser;
    }

    static List<DB_user_table> showAllDBUsers(){
        Session session = DBSessionFactory.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query userDB = (Query) session.createQuery("Select u from DB_user_table as u");
        @SuppressWarnings("unchecked")
        List<DB_user_table> userList = userDB.list();
        transaction.commit();
        return userList;
    }
    
    
// END of FILE
}

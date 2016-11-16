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
     * DBUser Database functions
     */
    
    
    
    
    
    
    static void insertUser(DBUser user) {
        Session session = DBSessionFactory.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
    }
    
    static void updateUser(DBUser updateDB){
        Session session = DBSessionFactory.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
	Query userDB = session.createQuery("Select u from DBUser as u where u.id = :uId");
	userDB.setParameter("uId", updateDB.getUserId());
	session.merge(updateDB);
        transaction.commit();
    }
    
    static void deletUser(DBUser user){
        Session session = DBSessionFactory.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
    }
    
    static DBUser showUserByID(Integer user){
        Session session = DBSessionFactory.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query userDB = (Query) session.createQuery("Select u from DBUser as u where u.id = :uId");
        userDB.setParameter("uId", user);
        DBUser theUser = (DBUser) userDB.uniqueResult();
        transaction.commit();
        return theUser;
    }
    
    static List<DBUser> showAllUsers(){
        Session session = DBSessionFactory.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query userDB = (Query) session.createQuery("Select u from DBUser as u");
        @SuppressWarnings("unchecked")
        List<DBUser> userList = userDB.list();
        transaction.commit();
        return userList;
    }
    
    
     

    
}

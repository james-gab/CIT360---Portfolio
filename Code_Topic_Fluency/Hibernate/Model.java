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

    static List<DB_member_table> showAllDBMemberTable() {
        Session session = DBSessionFactory.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query userDB = (Query) session.createQuery("Select u from DB_member_table as u");
        @SuppressWarnings("unchecked")
        List<DB_member_table> userList = userDB.list();
        transaction.commit();
        return userList;
    }

    static List<DB_member_table> showMemberTableListByUniqueSearch(String user) {
        Session session = DBSessionFactory.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query userDB = (Query) session.createQuery("from DB_member_table as u where u.FName like :searchName or u.LName like :searchName");
        userDB.setParameter("searchName", "%"+user+"%");
        @SuppressWarnings("unchecked")
        List<DB_member_table> userList = userDB.list();
        transaction.commit();
        return userList;
    }

    static List<DB_member_table> showAllActiveDBMemberTable() {
        Session session = DBSessionFactory.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query userDB = (Query) session.createQuery("Select m from DB_member_table as m inner join m.memberUser as u where u.isActive = :searchActive");
        userDB.setParameter("searchActive", 0);
        @SuppressWarnings("unchecked")
        List<DB_member_table> userList = userDB.list();
        transaction.commit();
        return userList;
    }

    static void insertUser(DB_user_table user, DB_member_table member, DB_address_table address, Integer id) {
        Session session = DBSessionFactory.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

// address
//        session.saveOrUpdate(address);
        session.save(address);
//        transaction.commit();        
//        session = DBSessionFactory.getSessionFactory().getCurrentSession();
//        transaction = session.beginTransaction();

//member
//        session.saveOrUpdate(member);
        session.save(member);

//        transaction.commit();        
//        session = DBSessionFactory.getSessionFactory().getCurrentSession();
//        transaction = session.beginTransaction();

//user
//        session.saveOrUpdate(user);
        session.save(user);

        transaction.commit();        


    }
    
    static List<DB_address_table> newMemberNumber(){
        Session session = DBSessionFactory.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query memberDB = (Query) session.createQuery("Select u.addressID from DB_address_table AS u where u.addressID = (select max(t.addressID) from DB_address_table AS t)");
        @SuppressWarnings("unchecked")
        List<DB_address_table> memberList = memberDB.list();
        transaction.commit();
        return memberList;
    }

    static DB_member_table showMemberByID(Integer user) {
        Session session = DBSessionFactory.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query userDB = (Query) session.createQuery("Select m from DB_member_table as m where m.id = :mId");
        userDB.setParameter("mId", user);
        DB_member_table theUser = (DB_member_table) userDB.uniqueResult();
        transaction.commit();
        return theUser;
    }

    static DB_address_table AddressByMemberNumber(DB_address_table theMember) {
        Session session = DBSessionFactory.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query userDB = (Query) session.createQuery("Select a from DB_address_table as a where a.addressID = :aId");
        userDB.setParameter("aId", theMember.getAddressID());
        DB_address_table theAddress = (DB_address_table) userDB.uniqueResult();
        transaction.commit();
        return theAddress;
    }

    static DB_user_table userByMemberNumber(DB_member_table theMember) {
        Session session = DBSessionFactory.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query userDB = (Query) session.createQuery("Select m from DB_user_table as m where m.memberMapping = :mId");
        userDB.setParameter("mId", theMember);
        DB_user_table theUser = (DB_user_table) userDB.uniqueResult();
        transaction.commit();
        return theUser;
    }


    static void updateTheUser(DB_user_table theUser) {
        Session session = DBSessionFactory.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
	Query userDB = session.createQuery("Select u from DB_user_table as u where u.id = :uId");
	userDB.setParameter("uId", theUser.getUserID() );
        session.merge(theUser);
        transaction.commit();
    }

    static void updateTheMember(DB_member_table theMember) {
        Session session = DBSessionFactory.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
	Query memberDB = session.createQuery("Select m from DB_member_table as m where m.id = :mId");
	memberDB.setParameter("mId", theMember.getMemberID());
	session.merge(theMember);
        transaction.commit();
    }

    static void updateTheAddress(DB_address_table theAddress) {
        Session session = DBSessionFactory.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
	Query addressDB = session.createQuery("Select a from DB_address_table as a where a.id = :aId");
	addressDB.setParameter("aId", theAddress.getAddressID());
	session.merge(theAddress);
        transaction.commit();
    }

    static void deletMembersRecord(DB_member_table aMember) {
        Session session = DBSessionFactory.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
//Address
        Query addressDB = (Query) session.createQuery("DELETE from DB_address_table AS a where a = :aId");
        addressDB.setParameter("aId", aMember.getAddressTableMapping());
//user
        Query userDB = (Query) session.createQuery("DELETE from DB_user_table as m where m = :uId");
        userDB.setParameter("uId", aMember.getMemberUser());
//member
        Query memberDB = (Query) session.createQuery("DELETE from DB_member_table where memberID = :mId");
        memberDB.setParameter("mId", aMember.getMemberID());

        userDB.executeUpdate();
        memberDB.executeUpdate();
        addressDB.executeUpdate();
        
        
        transaction.commit();
    }

    
    
}

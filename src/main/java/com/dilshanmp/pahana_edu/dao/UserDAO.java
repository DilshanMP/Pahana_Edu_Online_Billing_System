package com.dilshanmp.pahana_edu.dao;


import com.dilshanmp.pahana_edu.model.User;


import java.sql.SQLException;

/** * User DAO interface extending Generic DAO ------ //
 *
 * Single Responsibility Principle SRP - handles only User data access
 */
public interface UserDAO extends GenericDAO<User, Integer> {


    User findByUsernameAndPassword(String username, String password) throws SQLException;


    User findByUsername(String username) throws SQLException;
}
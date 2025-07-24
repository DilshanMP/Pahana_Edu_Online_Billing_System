package com.dilshanmp.pahana_edu.dao;


import com.dilshanmp.pahana_edu.model.User;


import java.sql.SQLException;


public interface UserDAO extends GenericDAO<User, Integer> {


    User findByUsernameAndPassword(String username, String password) throws SQLException;


    User findByUsername(String username) throws SQLException;
}
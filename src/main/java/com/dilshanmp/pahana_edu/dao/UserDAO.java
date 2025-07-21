package com.dilshanmp.pahana_edu.dao;


import com.dilshanmp.pahana_edu.model.User;


import java.sql.SQLException;

/**
 * User DAO interface extending Generic DAO
 * Single Responsibility Principle (SRP) - handles only User data access
 */
public interface UserDAO extends GenericDAO<User, Integer> {

    /**
     * Find user by username and password for authentication
     *
     * @param username Username
     * @param password Password
     * @return User if credentials match, null otherwise
     * @throws SQLException if database operation fails
     */
    User findByUsernameAndPassword(String username, String password) throws SQLException;

    /**
     * Find user by username
     *
     * @param username Username to search
     * @return User if found, null otherwise
     * @throws SQLException if database operation fails
     */
    User findByUsername(String username) throws SQLException;
}
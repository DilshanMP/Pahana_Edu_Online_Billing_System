package com.dilshanmp.pahana_edu.dao;


import lk.pahana.billing.model.Customer;

import java.sql.SQLException;
import java.util.List;

/**
 * Customer DAO interface extending Generic DAO
 */
public interface CustomerDAO extends GenericDAO<Customer, Integer> {

    /**
     * Search customers by name
     * @param name Name or partial name to search
     * @return List of matching customers
     * @throws SQLException if database operation fails
     */
    List<Customer> searchByName(String name) throws SQLException;

    /**
     * Find customer by email
     * @param email Email to search
     * @return Customer if found, null otherwise
     * @throws SQLException if database operation fails
     */
    Customer findByEmail(String email) throws SQLException;
}
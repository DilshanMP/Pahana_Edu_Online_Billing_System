package com.dilshanmp.pahana_edu.dao;


import lk.pahana.billing.model.Item;

import java.sql.SQLException;
import java.util.List;


/**
 * Item DAO interface extending Generic DAO
 */
public interface ItemDAO extends GenericDAO<Item, Integer> {

    /**
     * Find items by name pattern
     * @param namePattern Name pattern to search
     * @return List of matching items
     * @throws SQLException if database operation fails
     */
    List<Item> findByNamePattern(String namePattern) throws SQLException;

    /**
     * Find all available items (stock > 0)
     * @return List of available items
     * @throws SQLException if database operation fails
     */
    List<Item> findAvailableItems() throws SQLException;

    /**
     * Update item stock quantity
     * @param itemId Item ID
     * @param quantity New stock quantity
     * @return true if update successful
     * @throws SQLException if database operation fails
     */
    boolean updateStock(int itemId, int quantity) throws SQLException;
}
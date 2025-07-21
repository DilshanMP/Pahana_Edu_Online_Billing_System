package com.dilshanmp.pahana_edu.dao;


import com.dilshanmp.pahana_edu.model.Item;

import java.sql.SQLException;
import java.util.List;


/**
 * Item DAO interface extending Generic DAO
 */
public interface ItemDAO extends GenericDAO<Item, Integer> {


    List<Item> findByNamePattern(String namePattern) throws SQLException;


    List<Item> findAvailableItems() throws SQLException;


    boolean updateStock(int itemId, int quantity) throws SQLException;
}
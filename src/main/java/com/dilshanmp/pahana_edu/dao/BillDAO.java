package com.dilshanmp.pahana_edu.dao;

import lk.pahana.billing.model.Bill;
import lk.pahana.billing.model.BillItem;

import java.sql.SQLException;
import java.util.List;


/**
 * Bill DAO interface extending Generic DAO
 */
public interface BillDAO extends GenericDAO<Bill, Integer> {

    /**
     * Save bill with all its items
     * @param bill Bill with items to save
     * @return Saved bill with generated IDs
     * @throws SQLException if database operation fails
     */
    Bill saveWithItems(Bill bill) throws SQLException;

    /**
     * Find bills by customer ID
     * @param customerId Customer ID
     * @return List of bills for the customer
     * @throws SQLException if database operation fails
     */
    List<Bill> findByCustomerId(int customerId) throws SQLException;

    /**
     * Find bills by date range
     * @param startDate Start date (format: yyyy-MM-dd)
     * @param endDate End date (format: yyyy-MM-dd)
     * @return List of bills in date range
     * @throws SQLException if database operation fails
     */
    List<Bill> findByDateRange(String startDate, String endDate) throws SQLException;

    /**
     * Get bill items for a specific bill
     * @param billId Bill ID
     * @return List of bill items
     * @throws SQLException if database operation fails
     */
    List<BillItem> getBillItems(int billId) throws SQLException;
}
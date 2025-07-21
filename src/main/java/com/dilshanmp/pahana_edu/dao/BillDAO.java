package com.dilshanmp.pahana_edu.dao;

import com.dilshanmp.pahana_edu.model.Bill;
import com.dilshanmp.pahana_edu.model.BillItem;


import java.sql.SQLException;
import java.util.List;


/**
 * Bill DAO interface extending Generic DAO
 */
public interface BillDAO extends GenericDAO<Bill, Integer> {


    Bill saveWithItems(Bill bill) throws SQLException;


    List<Bill> findByCustomerId(int customerId) throws SQLException;


    List<Bill> findByDateRange(String startDate, String endDate) throws SQLException;


    List<BillItem> getBillItems(int billId) throws SQLException;
}
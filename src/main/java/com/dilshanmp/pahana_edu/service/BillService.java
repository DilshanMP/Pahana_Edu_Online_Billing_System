package com.dilshanmp.pahana_edu.service;

import com.dilshanmp.pahana_edu.model.Bill;
import com.dilshanmp.pahana_edu.model.BillItem;
import com.dilshanmp.pahana_edu.model.User;

import java.util.List;
import java.util.Map;

public interface BillService extends BaseService<Bill>{
    Bill createBill(Bill bill, User createdBy) throws Exception;
    List<Bill> getBillsByCustomer(int customerId) throws Exception;
    List<Bill> getBillsByDateRange(String startDate, String endDate) throws Exception;
    List<BillItem> getBillItems(int billId) throws Exception;
    double calculateTotalRevenue() throws Exception;
    Map<String, Object> getSalesSummary() throws Exception;

}

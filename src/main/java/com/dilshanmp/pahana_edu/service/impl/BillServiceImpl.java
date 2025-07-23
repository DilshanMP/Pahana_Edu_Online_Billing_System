package com.dilshanmp.pahana_edu.service.impl;

import com.dilshanmp.pahana_edu.model.Bill;
import com.dilshanmp.pahana_edu.model.BillItem;
import com.dilshanmp.pahana_edu.model.User;
import com.dilshanmp.pahana_edu.service.BillService;

import java.util.List;
import java.util.Map;

public class BillServiceImpl implements BillService {
    @Override
    public Bill save(Bill entity) throws Exception {
        return null;
    }

    @Override
    public Bill update(Bill entity) throws Exception {
        return null;
    }

    @Override
    public Bill delete(Bill entity) throws Exception {
        return null;
    }

    @Override
    public Bill findById(int id) throws Exception {
        return null;
    }

    @Override
    public Bill findAll(int id) throws Exception {
        return null;
    }

    @Override
    public boolean validate(Bill entity) {
        return false;
    }

    @Override
    public Bill createBill(Bill bill, User createdBy) throws Exception {
        return null;
    }

    @Override
    public List<Bill> getBillsByCustomer(int customerId) throws Exception {
        return null;
    }

    @Override
    public List<Bill> getBillsByDateRange(String startDate, String endDate) throws Exception {
        return null;
    }

    @Override
    public List<BillItem> getBillItems(int billId) throws Exception {
        return null;
    }

    @Override
    public double calculateTotalRevenue() throws Exception {
        return 0;
    }

    @Override
    public Map<String, Object> getSalesSummary() throws Exception {
        return null;
    }
}

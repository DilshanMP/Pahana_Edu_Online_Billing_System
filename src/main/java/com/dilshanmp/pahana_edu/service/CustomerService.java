package com.dilshanmp.pahana_edu.service;

import com.dilshanmp.pahana_edu.model.Customer;

import java.util.List;

public interface CustomerService extends BaseService<Customer> {
    List<Customer> searchByName(String searchTerm) throws Exception;
    boolean isEmailExists(String email, Integer excludeId) throws Exception;
    int getTotalCustomers() throws Exception;
}

package com.dilshanmp.pahana_edu.dao.impl;

import com.dilshanmp.pahana_edu.model.Customer;
import com.dilshanmp.pahana_edu.util.Generic.GenericRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerDAO extends GenericRepository<Customer, Integer> {
    Optional<Customer> findByCode(String customerCode);
    List<Customer> search(String keyword);
}

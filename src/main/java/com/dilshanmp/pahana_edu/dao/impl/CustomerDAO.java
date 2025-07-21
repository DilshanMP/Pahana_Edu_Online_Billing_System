package com.dilshanmp.pahana_edu.dao.impl;

import com.dilshanmp.pahana_edu.model.Customer;


import java.util.List;
import java.util.Optional;

public interface CustomerDAO  {
    Optional<Customer> findByCode(String customerCode);
    List<Customer> search(String keyword);
}

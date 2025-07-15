package com.dilshanmp.pahana_edu.dao.impl.impl;

import com.dilshanmp.pahana_edu.dao.impl.CustomerDAO;
import com.dilshanmp.pahana_edu.model.Customer;

import java.util.List;
import java.util.Optional;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public Optional<Customer> findByCode(String customerCode) {
        return Optional.empty();
    }

    @Override
    public List<Customer> search(String keyword) {
        return null;
    }

    @Override
    public Optional<Customer> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public Customer save(Customer entity) {
        return null;
    }

    @Override
    public Customer update(Customer entity) {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public boolean exists(Integer integer) {
        return false;
    }
}

package com.dilshanmp.pahana_edu.dao.impl.impl;

import com.dilshanmp.pahana_edu.dao.impl.ItemDAO;
import com.dilshanmp.pahana_edu.model.Item;

import java.util.List;
import java.util.Optional;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public Optional<Item> findByCode(String itemCode) {
        return Optional.empty();
    }

    @Override
    public List<Item> search(String keyword) {
        return null;
    }
}

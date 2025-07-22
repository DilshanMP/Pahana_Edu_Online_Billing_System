package com.dilshanmp.pahana_edu.service.impl;

import com.dilshanmp.pahana_edu.model.Item;
import com.dilshanmp.pahana_edu.service.ItemService;

import java.util.List;

public class ItemServiceImpl implements ItemService {
    @Override
    public List<Item> searchByName(String name) throws Exception {
        return List.of();
    }

    @Override
    public List<Item> getAvailableItems() throws Exception {
        return List.of();
    }

    @Override
    public boolean updateStock(int itemId, int quantity) throws Exception {
        return false;
    }

    @Override
    public boolean hasSufficientStock(int itemId, int requiredQuantity) throws Exception {
        return false;
    }

    @Override
    public List<Item> getLowStockItems() throws Exception {
        return List.of();
    }

    @Override
    public Item save(Item entity) throws Exception {
        return null;
    }

    @Override
    public boolean update(Item entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(Item id) throws Exception {
        return false;
    }

    @Override
    public Item findById(Integer id) throws Exception {
        return null;
    }

    @Override
    public List<Item> findAll() throws Exception {
        return List.of();
    }

    @Override
    public boolean validate(Item entity) {
        return false;
    }
}

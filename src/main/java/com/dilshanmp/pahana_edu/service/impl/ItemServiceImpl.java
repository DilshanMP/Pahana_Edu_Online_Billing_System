package com.dilshanmp.pahana_edu.service.impl;

import com.dilshanmp.pahana_edu.model.Item;
import com.dilshanmp.pahana_edu.service.ItemService;

import java.util.List;

public class ItemServiceImpl implements ItemService {
    @Override
    public Item save(Item entity) throws Exception {
        return null;
    }

    @Override
    public Item update(Item entity) throws Exception {
        return null;
    }

    @Override
    public Item delete(Item entity) throws Exception {
        return null;
    }

    @Override
    public Item findById(int id) throws Exception {
        return null;
    }

    @Override
    public Item findAll(int id) throws Exception {
        return null;
    }

    @Override
    public boolean validate(Item entity) {
        return false;
    }

    @Override
    public List<Item> searchByName(String namePattern) throws Exception {
        return null;
    }

    @Override
    public List<Item> getAvailableItems() throws Exception {
        return null;
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
        return null;
    }
}

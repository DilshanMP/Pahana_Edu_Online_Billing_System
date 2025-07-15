package com.dilshanmp.pahana_edu.dao.impl;

import com.dilshanmp.pahana_edu.model.Item;

import java.util.List;
import java.util.Optional;

public interface ItemDAO {
    Optional<Item> findByCode(String itemCode);
    List<Item> search(String keyword);
}

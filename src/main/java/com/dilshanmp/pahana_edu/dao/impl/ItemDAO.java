package com.dilshanmp.pahana_edu.dao.impl;

import com.dilshanmp.pahana_edu.model.Billitem;

import java.util.List;
import java.util.Optional;

public interface ItemDAO {
    Optional<Billitem> findByCode(String itemCode);
    List<Billitem> search(String keyword);
}

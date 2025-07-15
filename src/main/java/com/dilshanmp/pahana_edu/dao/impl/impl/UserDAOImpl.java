package com.dilshanmp.pahana_edu.dao.impl.impl;

import com.dilshanmp.pahana_edu.dao.impl.UserDAO;
import com.dilshanmp.pahana_edu.model.User;

import java.util.Optional;

public class UserDAOImpl implements UserDAO {
    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public Optional<User> authenticate(String username, String password) {
        return Optional.empty();
    }

    @Override
    public User save(User user) {
        return null;
    }
}

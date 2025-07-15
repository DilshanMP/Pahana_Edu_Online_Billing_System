package com.dilshanmp.pahana_edu.dao.impl;

import com.dilshanmp.pahana_edu.model.User;

import java.util.Optional;

public interface UserDAO {
    Optional<User> findByUsername(String username);
    Optional<User> authenticate(String username, String password);
    User save(User user);

}

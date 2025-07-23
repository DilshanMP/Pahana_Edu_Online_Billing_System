package com.dilshanmp.pahana_edu.service.impl;

import com.dilshanmp.pahana_edu.model.User;
import com.dilshanmp.pahana_edu.service.AuthService;

public class AuthServiceImpl implements AuthService {
    @Override
    public User authenticate(String username, String password) throws Exception {
        return null;
    }

    @Override
    public boolean isUsernameExists(String username) throws Exception {
        return false;
    }

    @Override
    public User register(User user) throws Exception {
        return null;
    }

    @Override
    public boolean changePassword(int userId, String oldPassword, String newPassword) throws Exception {
        return false;
    }
}

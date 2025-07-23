package com.dilshanmp.pahana_edu.service;

import com.dilshanmp.pahana_edu.model.User;

public interface AuthService {

    User authenticate(String username,String password) throws Exception;
    boolean isUsernameExists(String username) throws Exception;

    User register(User user) throws Exception; // Will be impl in register path
    boolean changePassword(int userId, String oldPassword, String newPassword) throws Exception; //  Will be Update this path on system
}

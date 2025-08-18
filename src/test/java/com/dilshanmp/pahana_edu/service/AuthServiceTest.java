package com.dilshanmp.pahana_edu.service;



import com.dilshanmp.pahana_edu.model.User;
import com.dilshanmp.pahana_edu.service.impl.AuthServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;


import static org.junit.jupiter.api.Assertions.*;

public class AuthServiceTest {

    private AuthService authService;

    @BeforeEach
    void setUp() {
        authService = new AuthServiceImpl();
    }

    @Test
    @DisplayName("Test login with valid credentials")
    void testValidLogin() {
        // Note: This test assumes database has default admin user
        try {
            // Test with valid credentials
            User user = authService.authenticate("admin", "admin123");

            // Assertions
            assertNotNull(user, "User should not be null for valid credentials");
            assertEquals("admin", user.getUsername());
            assertEquals("System Administrator", user.getFullName());

        } catch (Exception e) {
            fail("Should not throw exception for valid credentials: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Test login with invalid username")
    void testInvalidUsername() {
        // Test with invalid username
        Exception exception = assertThrows(Exception.class, () -> {
            authService.authenticate("invaliduser", "admin123");
        });

        assertEquals("Invalid username or password", exception.getMessage());
    }

    @Test
    @DisplayName("Test login with invalid password")
    void testInvalidPassword() {
        // Test with valid username but invalid password
        Exception exception = assertThrows(Exception.class, () -> {
            authService.authenticate("admin", "wrongpassword");
        });

        assertEquals("Invalid username or password", exception.getMessage());
    }

    @Test
    @DisplayName("Test login with empty username")
    void testEmptyUsername() {
        // Test with empty username
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            authService.authenticate("", "admin123");
        });

        assertEquals("Username cannot be empty", exception.getMessage());
    }

    @Test
    @DisplayName("Test login with null username")
    void testNullUsername() {
        // Test with null username
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            authService.authenticate(null, "admin123");
        });

        assertEquals("Username cannot be empty", exception.getMessage());
    }

    @Test
    @DisplayName("Test login with empty password")
    void testEmptyPassword() {
        // Test with empty password
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            authService.authenticate("admin", "");
        });

        assertEquals("Password cannot be empty", exception.getMessage());
    }

    @Test
    @DisplayName("Test username exists check")
    void testUsernameExists() {
        try {
            // Test with existing username
            boolean exists = authService.isUsernameExists("admin");
            assertTrue(exists, "Should return true for existing username");

            // Test with non-existing username
            boolean notExists = authService.isUsernameExists("nonexistentuser");
            assertFalse(notExists, "Should return false for non-existing username");

        } catch (Exception e) {
            fail("Should not throw exception: " + e.getMessage());
        }
    }
}
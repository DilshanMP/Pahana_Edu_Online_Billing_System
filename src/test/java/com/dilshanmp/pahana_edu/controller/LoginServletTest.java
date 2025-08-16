package com.dilshanmp.pahana_edu.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class LoginServletTest {

    private LoginServlet loginServlet;

    @BeforeEach
    void setUp() {
        loginServlet = new LoginServlet();
    }

    @Test
    void testInit() {
        assertDoesNotThrow(() -> loginServlet.init());
    }

    @Test
    void testDoGet_withoutMocks() {

        assertThrows(NullPointerException.class, () -> {
            loginServlet.doGet(null, null);
        });
    }

    @Test
    void testDoPost_withoutMocks() {

        assertThrows(NullPointerException.class, () -> {
            loginServlet.doPost(null, null);
        });
    }
}

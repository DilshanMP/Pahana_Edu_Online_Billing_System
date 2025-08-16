package com.dilshanmp.pahana_edu.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

class CustomerServletTest {

    private CustomerServlet customerServlet;

    @BeforeEach
    void setUp() {
        customerServlet = new CustomerServlet();
    }

    @Test
    void testInit() {
        assertDoesNotThrow(() -> customerServlet.init());
    }

    @Test
    void testDoGet_withoutMocks() {

        assertThrows(NullPointerException.class, () -> {
            customerServlet.doGet(null, null);
        });
    }

    @Test
    void testDoPost_withoutMocks() {

        assertThrows(NullPointerException.class, () -> {
            customerServlet.doPost(null, null);
        });
    }
}

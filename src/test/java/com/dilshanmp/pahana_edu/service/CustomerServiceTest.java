package com.dilshanmp.pahana_edu.service;

import com.dilshanmp.pahana_edu.model.Customer;
import com.dilshanmp.pahana_edu.service.impl.CustomerServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;




import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.DisplayName;




public class CustomerServiceTest {

    private CustomerService customerService;

    @BeforeEach
    void setUp() {
        customerService = new CustomerServiceImpl();
    }

    @Test
    @DisplayName("Test add customer with valid data")
    void testAddCustomerWithValidData() {
        try {
            // Create valid customer
            Customer customer = new Customer();
            customer.setName("Test Customer");
            customer.setEmail("test@example.com");
            customer.setPhone("0771234567");
            customer.setAddress("123 Test Street, Colombo");

            // Save customer
            Customer savedCustomer = customerService.save(customer);

            // Assertions
            assertNotNull(savedCustomer, "Saved customer should not be null");
            assertNotNull(savedCustomer.getId(), "Customer ID should be generated");
            assertEquals("Test Customer", savedCustomer.getName());
            assertEquals("test@example.com", savedCustomer.getEmail());

        } catch (Exception e) {
            fail("Should not throw exception for valid customer: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Test add customer with null data")
    void testAddCustomerWithNullData() {
        // Test with null customer
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            customerService.save(null);
        });

        assertEquals("Invalid customer data", exception.getMessage());
    }

    @Test
    @DisplayName("Test add customer with empty name")
    void testAddCustomerWithEmptyName() {
        // Create customer with empty name
        Customer customer = new Customer();
        customer.setName("");
        customer.setEmail("test@example.com");

        // Test
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            customerService.save(customer);
        });

        assertEquals("Invalid customer data", exception.getMessage());
    }

    @Test
    @DisplayName("Test add customer with invalid email")
    void testAddCustomerWithInvalidEmail() {
        // Create customer with invalid email
        Customer customer = new Customer();
        customer.setName("Test Customer");
        customer.setEmail("invalid-email");

        // Test
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            customerService.save(customer);
        });

        assertEquals("Invalid customer data", exception.getMessage());
    }

    @Test
    @DisplayName("Test add customer with invalid phone")
    void testAddCustomerWithInvalidPhone() {
        // Create customer with invalid phone (less than 10 digits)
        Customer customer = new Customer();
        customer.setName("Test Customer");
        customer.setPhone("123");

        // Test
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            customerService.save(customer);
        });

        assertEquals("Invalid customer data", exception.getMessage());
    }

    @Test
    @DisplayName("Test validate customer method")
    void testValidateCustomer() {
        CustomerServiceImpl service = new CustomerServiceImpl();

        // Test null customer
        assertFalse(service.validate(null), "Should return false for null customer");

        // Test valid customer
        Customer validCustomer = new Customer();
        validCustomer.setName("Valid Customer");
        validCustomer.setEmail("valid@example.com");
        validCustomer.setPhone("0771234567");
        assertTrue(service.validate(validCustomer), "Should return true for valid customer");

        // Test customer with invalid data
        Customer invalidCustomer = new Customer();
        invalidCustomer.setName("");
        assertFalse(service.validate(invalidCustomer), "Should return false for empty name");
    }

    @Test
    @DisplayName("Test customer search")
    void testSearchCustomers() {
        try {
            // Search should not throw exception even if no results
            var results = customerService.searchByName("NonExistent");
            assertNotNull(results, "Search results should not be null");

            // Search with empty string should return all
            var allResults = customerService.searchByName("");
            assertNotNull(allResults, "Search with empty string should return results");

        } catch (Exception e) {
            fail("Search should not throw exception: " + e.getMessage());
        }
    }
}
package com.dilshanmp.pahana_edu.model;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Bill {
    private Customer customer;
    private List<BillItem> items;  // Using ArrayList (Java Collections)
    private BigDecimal totalAmount;

    public Bill() {
        this.items = new ArrayList<>();
        this.totalAmount = BigDecimal.ZERO;
    }

    public Bill(Customer customer) {
        this();
        this.customer = customer;
    }

    // Inner class for Bill Items
    public static class BillItem {
        private Item item;
        private int quantity;
        private BigDecimal amount;

        public BillItem(Item item, int quantity) {
            this.item = item;
            this.quantity = quantity;
            this.amount = item.calculateTotal(quantity);
        }

        // Getters and setters
        public Item getItem() {
            return item;
        }

        public void setItem(Item item) {
            this.item = item;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public BigDecimal getAmount() {
            return amount;
        }

        public void setAmount(BigDecimal amount) {
            this.amount = amount;
        }
    }

    // Business methods
    public void addItem(Item item, int quantity) {
        BillItem billItem = new BillItem(item, quantity);
        items.add(billItem);
        calculateTotal();
    }

    public void removeItem(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
            calculateTotal();
        }
    }

    private void calculateTotal() {
        totalAmount = items.stream()
                .map(BillItem::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    // Getters and setters
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<BillItem> getItems() {
        return items;
    }

    public void setItems(List<BillItem> items) {
        this.items = items;
        calculateTotal();
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }
}
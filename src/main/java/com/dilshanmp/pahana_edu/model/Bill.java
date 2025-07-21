package com.dilshanmp.pahana_edu.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Bill extends BaseModel {


    private String billNumber;
    private Customer customer;
    private int customerId;
    private double totalAmount;
    private Date billDate;
    private User createdBy;
    private int createdById;
    private List<Billitem> billitems; // < --------Using ArrayList Collection

    public Bill() {
        super();
        this.billitems = new ArrayList<>();
        this.billDate = new Date(System.currentTimeMillis());
    }

    public Bill(String billNumber, Customer customer, User createdBy) {
        this();
        this.billNumber = billNumber;
        this.customer = customer;
        this.customerId = customer.getId();
        this.createdBy = createdBy;
        this.createdById = createdBy.getId();

    }

    //--- > Implementation of abstract method <----- //
    @Override
    public String getDisplayName() {
        return "Bill #" + this.billNumber;
    }

    //Apply to Business logic methods --- >
    public void addBillItem(Billitem item) {
        this.billitems.add(item);
        calculateTotalAmount();
    }

    public void removeBillItem(Billitem item) {
        this.billitems.remove(item);
        calculateTotalAmount();
    }

    private void calculateTotalAmount() {
        this.totalAmount = 0;
        for (Billitem item : billitems) {
            this.totalAmount += item.getTotalPrice();
        }
    }
    //Bill Number Generate method
    public static String generateBillNumber(){
        return "BILL-" + System.currentTimeMillis();
    }

    public String getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public int getCreatedById() {
        return createdById;
    }

    public void setCreatedById(int createdById) {
        this.createdById = createdById;
    }

    public List<Billitem> getBillitems() {
        return billitems;
    }

    public void setBillitems(List<Billitem> billitems) {
        this.billitems = billitems;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id" + id +
                "billNumber='" + billNumber + '\'' +
                ", customerId=" + customerId +
                ", totalAmount=" + totalAmount +
                ", billDate=" + billDate +
                ", createdBy=" + createdBy +
                ", createdById=" + createdById +
                ", itemCount=" + billitems.size() +
                '}';
    }
}

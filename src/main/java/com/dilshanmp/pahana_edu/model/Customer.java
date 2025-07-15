package com.dilshanmp.pahana_edu.model;

import com.dilshanmp.pahana_edu.model.abstract_Class.BaseEntity;

public class Customer extends BaseEntity {

    private String customerCode;
    private String name;
    private String email;
    private String phone;
    private String address;

    public Customer() {
        super();
    }

    public Customer(String customerCode, String name, String email, String phone, String address) {
        super();
        this.customerCode = customerCode;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    @Override
    public String getDisplayName() {
        return name +"("+customerCode+")";
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

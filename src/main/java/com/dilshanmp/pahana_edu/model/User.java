package com.dilshanmp.pahana_edu.model;

public class User extends BaseEntity {
    public String username;
    public String password;
    public String fullName;
    public String role;

    public User(){   // ---> is this Constructors
        super();
    }

    @Override   // use in Polymorphism
    public String getDisplayName() {  // --> Implementation of abstract method
        return fullName;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }




}

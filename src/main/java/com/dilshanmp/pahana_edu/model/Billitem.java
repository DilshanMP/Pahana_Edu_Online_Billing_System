package com.dilshanmp.pahana_edu.model;


import java.math.BigDecimal;

public class Billitem extends BaseModel {
    private String itemCode;
    private String name;
    private String description;
    private BigDecimal unitPrice;
    private String unitType;

    // Constructors
    public Billitem() {
        super();
    }

    public Billitem(String itemCode, String name, String description, BigDecimal unitPrice, String unitType) {
        super();
        this.itemCode = itemCode;
        this.name = name;
        this.description = description;
        this.unitPrice = unitPrice;
        this.unitType = unitType;
    }

    @Override
    public String getDisplayName() {
        return name + " (" + itemCode + ")";
    }


    public BigDecimal calculateTotal(int quantity) {
        return unitPrice.multiply(BigDecimal.valueOf(quantity));
    }

    // Getters and setters
    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }
}

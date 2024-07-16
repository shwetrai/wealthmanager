package com.ibm.eeba.wealthmanager.api.model.customer;

public class Investment {

    private String name;
    private String type;
    private String subType;
    private String purchaseCost;
    private String currentValue;


    private String cagReturn;
    private String purchasedDate;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getPurchaseCost() {
        return purchaseCost;
    }

    public void setPurchaseCost(String purchaseCost) {
        this.purchaseCost = purchaseCost;
    }

    public String getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(String currentValue) {
        this.currentValue = currentValue;
    }

    public String getCagReturn() {
        return cagReturn;
    }

    public void setCagReturn(String cagReturn) {
        this.cagReturn = cagReturn;
    }

    public String getPurchasedDate() {
        return purchasedDate;
    }

    public void setPurchasedDate(String purchasedDate) {
        this.purchasedDate = purchasedDate;
    }
}

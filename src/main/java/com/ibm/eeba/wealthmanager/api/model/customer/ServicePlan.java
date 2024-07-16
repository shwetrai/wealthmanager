package com.ibm.eeba.wealthmanager.api.model.customer;

public class ServicePlan {

    private String productName;
    private String productType;
    // private Product product;
    private Integer allocation; //New | offered

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Integer getAllocation() {
        return allocation;
    }

    public void setAllocation(Integer allocation) {
        this.allocation = allocation;
    }
}

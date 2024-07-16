package com.ibm.eeba.wealthmanager.api.model.product;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Component;

@Component
@Document("productmaster")
public class Product {

    @Id
    private String productID;

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    @Field
    private String name;
    @Field
    private String type;
    @Field
    private int minInvestment;
    @Field
    private int investPeriod;
    @Field
    private int maturityPeriod;
    @Field
    private int returnPerc;
    @Field
    private String permiumInterval;
    @Field

    private int monthlyPrem;
    @Field
    private int annualPrem;

    @Field
    private int risk;

    public int getRisk() {
        return risk;
    }

    public void setRisk(int risk) {
        this.risk = risk;
    }

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

    public int getMinInvestment() {
        return minInvestment;
    }

    public void setMinInvestment(int minInvestment) {
        this.minInvestment = minInvestment;
    }

    public int getInvestPeriod() {
        return investPeriod;
    }

    public void setInvestPeriod(int investPeriod) {
        this.investPeriod = investPeriod;
    }

    public int getMaturityPeriod() {
        return maturityPeriod;
    }

    public void setMaturityPeriod(int maturityPeriod) {
        this.maturityPeriod = maturityPeriod;
    }

    public int getReturnPerc() {
        return returnPerc;
    }

    public void setReturnPerc(int returnPerc) {
        this.returnPerc = returnPerc;
    }

    public String getPermiumInterval() {
        return permiumInterval;
    }

    public void setPermiumInterval(String permiumInterval) {
        this.permiumInterval = permiumInterval;
    }

    public int getMonthlyPrem() {
        return monthlyPrem;
    }

    public void setMonthlyPrem(int monthlyPrem) {
        this.monthlyPrem = monthlyPrem;
    }

    public int getAnnualPrem() {
        return annualPrem;
    }

    public void setAnnualPrem(int annualPrem) {
        this.annualPrem = annualPrem;
    }
}

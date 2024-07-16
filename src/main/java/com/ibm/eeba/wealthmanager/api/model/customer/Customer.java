package com.ibm.eeba.wealthmanager.api.model.customer;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Document("customer")
public class Customer {

    @Id
    private String customerID;
    @Field
    private PersonalInfo personalInfo;
    @Field
    private List<AmountType> income;
    @Field
    private List<AmountType> expense;
    @Field
    private List<AmountType> debt;
    @Field
    private List<Investment> investment;
    @Field
    private String creditRating;

    @Field
    private String riskTolerance;
    @Field
    private List<Goal> financialGoal;

    @Field
    private List<Offer> offers;

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    public String getRiskTolerance() {
        return riskTolerance;
    }

    public void setRiskTolerance(String riskTolerance) {
        this.riskTolerance = riskTolerance;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

    public List<AmountType> getIncome() {
        return income;
    }

    public void setIncome(List<AmountType> income) {
        this.income = income;
    }

    public List<AmountType> getExpense() {
        return expense;
    }

    public void setExpense(List<AmountType> expense) {
        this.expense = expense;
    }

    public List<AmountType> getDebt() {
        return debt;
    }

    public void setDebt(List<AmountType> debt) {
        this.debt = debt;
    }

    public List<Investment> getInvestment() {
        return investment;
    }

    public void setInvestment(List<Investment> investment) {
        this.investment = investment;
    }

    public String getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(String creditRating) {
        this.creditRating = creditRating;
    }

    public List<Goal> getFinancialGoal() {
        return financialGoal;
    }

    public void setFinancialGoal(List<Goal> financialGoal) {
        this.financialGoal = financialGoal;
    }
}


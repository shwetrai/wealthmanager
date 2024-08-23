package com.ibm.eeba.wealthmanager.api.model.customer;

import org.springframework.stereotype.Component;

@Component
public class RequestToBuy {

    private Offer offer;
    private String customerID;

    private Double investmentAmount;

    public Double getInvestmentAmount() {
        return investmentAmount;
    }

    public void setInvestmentAmount(Double investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }
}

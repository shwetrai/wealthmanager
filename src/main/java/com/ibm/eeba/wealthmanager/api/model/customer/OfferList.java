package com.ibm.eeba.wealthmanager.api.model.customer;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OfferList {

    private List<Offer> instances;

    public List<Offer> getInstances() {
        return instances;
    }

    public void setInstances(List<Offer> instances) {
        this.instances = instances;
    }
}

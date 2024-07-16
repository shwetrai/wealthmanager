package com.ibm.eeba.wealthmanager.api.model.customer;

import com.ibm.eeba.wealthmanager.api.model.product.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Offer {

   private List<ServicePlan> servicePlans;
    private String notes;

    private String risk;

    public List<ServicePlan> getServicePlans() {
        return servicePlans;
    }

    public void setServicePlans(List<ServicePlan> servicePlans) {
        this.servicePlans = servicePlans;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getRisk() {
        return risk;
    }

    public void setRisk(String risk) {
        this.risk = risk;
    }
}

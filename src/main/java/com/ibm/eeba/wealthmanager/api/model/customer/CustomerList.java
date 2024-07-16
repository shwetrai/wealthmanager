package com.ibm.eeba.wealthmanager.api.model.customer;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CustomerList {

    private List<Customer> customers;

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}

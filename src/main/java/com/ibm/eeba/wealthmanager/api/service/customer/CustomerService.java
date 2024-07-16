package com.ibm.eeba.wealthmanager.api.service.customer;

import com.ibm.eeba.wealthmanager.api.model.customer.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CustomerService {


    void create(Customer customer);

    Optional<Customer> findById(String id);

    List<Customer> findAll();

    Customer findAndUpdateCustomerInvestmentByID(Customer customer);
    Customer findAndUpdateCustomerPersonalInfoByID(Customer customer);
    Customer findAndUpdateCustomerOfferByID(Customer customer);

}

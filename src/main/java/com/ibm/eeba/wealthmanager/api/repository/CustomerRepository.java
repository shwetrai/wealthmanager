package com.ibm.eeba.wealthmanager.api.repository;

import com.ibm.eeba.wealthmanager.api.model.customer.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends MongoRepository<Customer,String> {


    @Override
    Optional<Customer> findById(String id);

    @Override
    List<Customer> findAll();
}

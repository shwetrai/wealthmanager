package com.ibm.eeba.wealthmanager.api.repository;

import com.ibm.eeba.wealthmanager.api.model.accounts.Account;
import com.ibm.eeba.wealthmanager.api.model.customer.Customer;
import com.ibm.eeba.wealthmanager.api.model.product.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AccountsRepository extends MongoRepository<Account,String> {

    @Override
    Optional<Account> findById(String id);

    @Override
    List<Account> findAll();

    @Query("{'customerID':?0}")
    List<Account> findAccountBycustomerID(String customerID);
}

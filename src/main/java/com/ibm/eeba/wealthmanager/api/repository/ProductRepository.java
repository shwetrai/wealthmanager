package com.ibm.eeba.wealthmanager.api.repository;


import com.ibm.eeba.wealthmanager.api.model.product.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product,String> {

    @Override
    Optional<Product> findById(String id);

    @Query("{'type':?0}")
    List<Product> findProductByType(String type);

    @Query("{'name':?0}")
    List<Product> findProductByName(String name);

    @Override
    List<Product> findAll();
}

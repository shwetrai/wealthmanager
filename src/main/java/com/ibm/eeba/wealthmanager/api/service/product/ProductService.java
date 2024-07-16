package com.ibm.eeba.wealthmanager.api.service.product;

import com.ibm.eeba.wealthmanager.api.model.product.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {

    void create(Product product);
    Optional<Product> findById(String id);
    List<Product> findProductByType(String type);
    List<Product> findProductByName(String name);
    List<Product> findAll();
    Product findAndUpdateProductByID(Product product);
}

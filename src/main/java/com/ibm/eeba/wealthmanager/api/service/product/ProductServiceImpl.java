package com.ibm.eeba.wealthmanager.api.service.product;

import com.ibm.eeba.wealthmanager.api.model.product.Product;
import com.ibm.eeba.wealthmanager.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    ProductRepository repository;

    public void create(Product product){
        repository.insert(product);
    }
    public Optional<Product> findById(String id){
        return repository.findById(id);
    }
    public List<Product> findProductByType(String type){
            return repository.findProductByType(type);
    }

    public List<Product> findProductByName(String name){
        return repository.findProductByName(name);
    }
    public List<Product> findAll(){
        return repository.findAll();
    }
    public Product findAndUpdateProductByID(Product product){
        Query query = new Query().addCriteria(Criteria.where("_id").is(product.getProductID()));
        FindAndModifyOptions options = new FindAndModifyOptions().returnNew(true).upsert(true);
       Update updateDefinition = new Update().set("name",product.getName());
        updateDefinition.set("type",product.getType());
        return mongoTemplate.findAndModify(query,updateDefinition,options, Product.class);
    }
}

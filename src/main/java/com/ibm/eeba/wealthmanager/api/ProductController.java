package com.ibm.eeba.wealthmanager.api;

import com.ibm.eeba.wealthmanager.api.model.RespMessage;
import com.ibm.eeba.wealthmanager.api.model.customer.Customer;
import com.ibm.eeba.wealthmanager.api.model.product.Product;
import com.ibm.eeba.wealthmanager.api.model.product.ProductList;
import com.ibm.eeba.wealthmanager.api.repository.ProductRepository;
import com.ibm.eeba.wealthmanager.api.service.product.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @Autowired
    private ProductList productList;

    @Autowired
    private RespMessage message;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value = "/create")
    public RespMessage createProduct(@RequestBody Product product){

        productServiceImpl.create(product);
        message.setRespMessage("Product created");
        return message;
    }

    @GetMapping(value = "/type/{type}")
    public ProductList getProductByType(@PathVariable("type") String  type){

        List<Product> products =productServiceImpl.findProductByType(type);
        productList.setProductList(products);
        return productList;
    }

    @GetMapping(value = "/name/{name}")
    public Product getProductByName(@PathVariable("name") String  name){

        List<Product> products =productServiceImpl.findProductByName(name);
        //productList.setProductList(products);

        return products.get(0);
    }

    @PutMapping (consumes = MediaType.APPLICATION_JSON_VALUE, value = "/update")
    public RespMessage updateProduct(@RequestBody Product product){

        productServiceImpl.findAndUpdateProductByID(product);
        message.setRespMessage("Product Updated");
        return message;
    }

}

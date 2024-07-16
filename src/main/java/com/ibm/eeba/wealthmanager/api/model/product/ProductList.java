package com.ibm.eeba.wealthmanager.api.model.product;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductList {

    private List<Product> productList;

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}

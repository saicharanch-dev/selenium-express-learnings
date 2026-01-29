package com.seleniumexpress.trans.service;

import com.seleniumexpress.trans.dto.Product;
import com.seleniumexpress.trans.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Transactional
    public void saveProductInfo() {
        //create a product
        for (int i = 0; i < 10; i++) {
            Product product = new Product();
            product.setId(i);
            product.setName("Test Product " + i);

            productRepo.saveProduct(product);

            if(i ==7){
                throw new RuntimeException("something occured");
            }
        }
    }
}

package com.seleniumexpress.trans;

import com.seleniumexpress.trans.config.ProductConfig;
import com.seleniumexpress.trans.service.ProductService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ProductConfig.class);
        context.registerShutdownHook();

        ProductService productService = context.getBean("productService", ProductService.class);
        productService.saveProductInfo();

        context.close();
    }
}

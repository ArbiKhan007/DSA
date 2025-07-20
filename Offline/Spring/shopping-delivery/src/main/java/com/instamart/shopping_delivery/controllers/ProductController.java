package com.instamart.shopping_delivery.controllers;

import com.instamart.shopping_delivery.dto.ProductDto;
import com.instamart.shopping_delivery.models.Product;
import com.instamart.shopping_delivery.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    /*
    This function will run when /api/v1/product/add endoint will get triggered.
     */
    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody ProductDto productDto,
                                     @RequestParam UUID userId){
        // We need to call product service to add product
        ProductDto product = productService.addProduct(productDto,userId);
        return new ResponseEntity(product, HttpStatus.CREATED);
    }
}

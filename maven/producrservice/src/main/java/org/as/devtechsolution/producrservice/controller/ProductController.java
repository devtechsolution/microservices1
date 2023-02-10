package org.as.devtechsolution.producrservice.controller;

import org.as.devtechsolution.producrservice.model.ProductRequest;
import org.as.devtechsolution.producrservice.model.ProductResponse;
import org.as.devtechsolution.producrservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Aditya Srivastva on 08-02-2023
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest){
        long productId= productService.addProduct(productRequest);

        return new ResponseEntity<>(productId, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("id") long productId){
        ProductResponse productResponse= productService.getProductById(productId);

        return new ResponseEntity<ProductResponse>(productResponse, HttpStatus.OK);
    }

}

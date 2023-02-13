package org.as.devtechsolution.productservice.service.service;

import org.as.devtechsolution.productservice.model.model.ProductRequest;
import org.as.devtechsolution.productservice.model.model.ProductResponse;

/**
 * @author Aditya Srivastva on 08-02-2023
 */
public interface ProductService {
    long addProduct(ProductRequest productRequest);

    ProductResponse getProductById(long productId);
}

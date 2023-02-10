package org.as.devtechsolution.producrservice.service;

import org.as.devtechsolution.producrservice.model.ProductRequest;
import org.as.devtechsolution.producrservice.model.ProductResponse;

/**
 * @author Aditya Srivastva on 08-02-2023
 */
public interface ProductService {
    long addProduct(ProductRequest productRequest);

    ProductResponse getProductById(long productId);
}

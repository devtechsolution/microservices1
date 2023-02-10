package org.as.devtechsolution.producrservice.service;

import lombok.extern.log4j.Log4j2;
import org.as.devtechsolution.producrservice.entity.Product;
import org.as.devtechsolution.producrservice.exception.ProductServiceCustomException;
import org.as.devtechsolution.producrservice.model.ProductRequest;
import org.as.devtechsolution.producrservice.model.ProductResponse;
import org.as.devtechsolution.producrservice.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.beans.BeanUtils.*;

/**
 * @author Aditya Srivastva on 08-02-2023
 */
@Service
@Log4j2
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public long addProduct(final ProductRequest productRequest) {
        log.info("Adding product....");
        Product product= Product.builder()
                .productName(productRequest.getName())
                .price(productRequest.getPrice())
                .quantity(productRequest.getQuantity())
                .build();

       productRepository.save(product);
       log.info("Product Created...");
        return product.getProductId();
    }

    @Override
    public ProductResponse getProductById(final long productId) {
        log.info("Get the product for producctId:{}", productId);
        final var product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductServiceCustomException("Product with given id is not found","PRODUCT_NOT_FOUND"));
        ProductResponse productResponse= new ProductResponse();
        copyProperties(product, productResponse);
        return productResponse;
    }
}

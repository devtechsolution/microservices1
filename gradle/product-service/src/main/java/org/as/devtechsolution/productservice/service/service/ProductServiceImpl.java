package org.as.devtechsolution.productservice.service.service;

import lombok.extern.log4j.Log4j2;
import org.as.devtechsolution.productservice.entity.entity.Product;
import org.as.devtechsolution.productservice.entity.exception.ProductServiceCustomException;
import org.as.devtechsolution.productservice.model.model.ProductRequest;
import org.as.devtechsolution.productservice.model.model.ProductResponse;
import org.as.devtechsolution.productservice.repository.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.beans.BeanUtils.copyProperties;

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

    @Override
    public void resuceQuantity(final long productId, final long quantity) {
        log.info("Reduce Quantity {} for id: {}", quantity, productId);
        Product product =productRepository.findById(productId)
                .orElseThrow(()-> new ProductServiceCustomException("Product with given Id not found"
                        , "PRODUCT_NOT_FOUND"));

        if(product.getQuantity() < quantity) {
            throw new ProductServiceCustomException(
                    "Product does not have sufficient Quantity",
                    "INSUFFICIENT_QUANTITY"
            );
        }
        product.setQuantity(product.getQuantity() - quantity);
        productRepository.save(product);
        log.info("Product Quantity updated Successfully");

    }
}

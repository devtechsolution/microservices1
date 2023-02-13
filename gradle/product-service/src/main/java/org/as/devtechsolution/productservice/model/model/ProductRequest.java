package org.as.devtechsolution.productservice.model.model;

import lombok.Data;

/**
 * @author Aditya Srivastva on 09-02-2023
 */

@Data
public class ProductRequest {
    private String name;
    private long price;

    private long quantity;
}

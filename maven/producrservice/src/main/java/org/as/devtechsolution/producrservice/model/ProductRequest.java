package org.as.devtechsolution.producrservice.model;

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

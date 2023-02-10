package org.as.devtechsolution.producrservice.exception;

import lombok.Data;

/**
 * @author Aditya Srivastva on 09-02-2023
 */
@Data
public class ProductServiceCustomException  extends RuntimeException{
    private String errorCode;

    public ProductServiceCustomException(final String message, final String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}

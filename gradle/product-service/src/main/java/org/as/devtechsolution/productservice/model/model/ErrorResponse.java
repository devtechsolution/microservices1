package org.as.devtechsolution.productservice.model.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Aditya Srivastva on 09-02-2023
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

    private String errorMessage;
    private String errorCode;
}

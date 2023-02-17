package org.as.devtechsolution.orderservice.external.decoder;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.log4j.Log4j2;
import org.as.devtechsolution.orderservice.exception.CustomException;
import org.as.devtechsolution.orderservice.external.response.ErrorResponse;

import java.io.IOException;

/**
 * @author Aditya Srivastva on 16-02-2023
 */

@Log4j2
public class CustomDecoder implements ErrorDecoder {
    @Override
    public Exception decode(final String s, final Response response) {
        ObjectMapper objectMapper= new ObjectMapper();
        log.info("::{}", response.request().url());
        log.info("::{}", response.request().headers());

        try {
            ErrorResponse errorRespons= objectMapper.readValue(response.body().asInputStream(), ErrorResponse.class);
            return  new CustomException(errorRespons.getErrorMessage(), errorRespons.getErrorCode(), response.status());
        } catch (IOException e) {
            throw new CustomException("Internal Server Error", "INTERNAL_SERVER_ERROR", 500);
        }
    }
}

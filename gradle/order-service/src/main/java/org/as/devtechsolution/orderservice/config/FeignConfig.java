package org.as.devtechsolution.orderservice.config;

import feign.codec.ErrorDecoder;
import org.as.devtechsolution.orderservice.external.decoder.CustomDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Aditya Srivastva on 17-02-2023
 */
@Configuration
public class FeignConfig {

    @Bean
    ErrorDecoder errorDecoder(){
        return new CustomDecoder();
    }
}

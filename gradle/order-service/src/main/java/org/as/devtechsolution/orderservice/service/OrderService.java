package org.as.devtechsolution.orderservice.service;

import org.as.devtechsolution.orderservice.domain.OrderRequest;

public interface OrderService {
    long placeOrder(OrderRequest orderRequest);
}

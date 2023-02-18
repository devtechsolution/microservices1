package org.as.devtechsolution.orderservice.service;

import lombok.extern.log4j.Log4j2;
import org.as.devtechsolution.orderservice.domain.OrderRequest;
import org.as.devtechsolution.orderservice.entity.Order;
import org.as.devtechsolution.orderservice.external.client.ProductService;
import org.as.devtechsolution.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductService productService;


    @Override
    public long placeOrder(OrderRequest orderRequest) {

        //Order Entity -> Save the data with Status Order Created
        //Product Service - Block Products (Reduce the Quantity)
        //Payment Service -> Payments -> Success-> COMPLETE, Else
        //CANCELLED

        log.info("Placing Order Request: {}", orderRequest);
        productService.reduceQuantity(orderRequest.getProductId(),orderRequest.getQuantity());

        log.info("Creating Order with Status CREATED");
        Order order = Order.builder()
                .amount(orderRequest.getTotalAmount())
                .orderStatus("CREATED")
                .productId(orderRequest.getProductId())
                .orderDate(Instant.now())
                .quantity(orderRequest.getQuantity())
                .build();

        order = orderRepository.save(order);

        log.info("Calling Payment Service to complete the payment");
        orderRepository.save(order);

        log.info("Order Places successfully with Order Id: {}", order.getId());
        return order.getId();
    }


}
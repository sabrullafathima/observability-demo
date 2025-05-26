package com.sabrullasdevlabs.observability.service;

import com.sabrullasdevlabs.observability.model.Order;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);
    private final Counter orderSuccessCounter;

    public OrderService(MeterRegistry meterRegistry) {
        this.orderSuccessCounter = meterRegistry.counter("orders.success");
    }

    public Order placeOrder(String productName, double amount) {
        logger.info("Placing order for product: {}, amount: {}", productName, amount);
        String orderId = UUID.randomUUID().toString();

        if (amount < 0) {
            logger.error("Invalid order amount: {}", amount);
            throw new IllegalArgumentException("Amount must be positive");
        }

        Order order = new Order(orderId, productName, amount);
        orderSuccessCounter.increment(); // Metric
        logger.info("Order placed successfully: {}", orderId);
        return order;
    }
}



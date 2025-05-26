package com.sabrullasdevlabs.observability.controller;
import com.sabrullasdevlabs.observability.model.Order;
import com.sabrullasdevlabs.observability.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OrderController {
    private final OrderService orderService;
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/place-order")
    public Order placeOrder(@RequestParam String product, @RequestParam double amount) {
        logger.info("Received request to place order");
        return orderService.placeOrder(product, amount);
    }
}


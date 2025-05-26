package com.sabrullasdevlabs.observability.model;

//import lombok.Getter;
//
//@Getter
public class Order {
    private String orderId;
    private String productName;
    private double amount;

    public Order(String orderId, String productName, double amount) {
        this.orderId = orderId;
        this.productName = productName;
        this.amount = amount;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getProductName() {
        return productName;
    }

    public double getAmount() {
        return amount;
    }
}

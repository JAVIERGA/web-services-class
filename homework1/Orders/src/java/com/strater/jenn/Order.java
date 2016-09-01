package com.strater.jenn;

public class Order {
    private String orderNumber;
    private String customerName;
    private String productName;
    private int amount;
    private boolean paid = false;
    
    public Order(String orderNumber, String customerName, String productName, int amount) {
        this.orderNumber = orderNumber;
        this.customerName = customerName;
        this.productName = productName;
        this.amount = amount;
    }
    
    public String getOrderNumber() {
        return orderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getProductName() {
        return productName;
    }

    public int getAmount() {
        return amount;
    }

    public boolean isPaid() {
        return paid;
    }
    
    public void setPaid(boolean isPaid) {
        this.paid = isPaid;
    }
}

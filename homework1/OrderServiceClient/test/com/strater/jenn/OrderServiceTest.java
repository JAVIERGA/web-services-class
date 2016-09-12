package com.strater.jenn;

import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;


public class OrderServiceTest {
    
    @After
    public void runAfterTestMethod() {
        clearOrders();
    }
    
    public void setupTestData() {
        orderProduct("1", "Jenn", 10, "pencils");
    }
    
    @Test
    public void testOrderingProducts() {
        String result = orderProduct("1", "Jenn", 10, "pencils");
        assertEquals("1", result);
    }
    
    @Test
    public void testGetOrderInfoBeforePaying() {
        setupTestData();
        String result = getOrderInfo("1");
        assertEquals("Order number: 1: Customer Jenn has ordered 10 pencils. Not yet paid", result);
    }
    
    @Test
    public void testPayOrder() {
        setupTestData();
        String result = payOrder("1", "123abc");
        assertEquals("Order: 1 is now paid", result);
    }
    
    @Test
    public void testGetOrderInfoAfterPaying() {
        setupTestData();
        payOrder("1","123abc");
        String result = getOrderInfo("1");
        assertEquals("Order number: 1: Customer Jenn has ordered 10 pencils. Is paid", result);
    }
    
    @Test
    public void testGetNonexistantOrderInfo() {
        getOrderInfo("404");
    }
        
    private static String orderProduct(java.lang.String orderNumber, java.lang.String customerName, java.lang.Integer amount, java.lang.String product) {
        com.strater.jenn.OrderService_Service service = new com.strater.jenn.OrderService_Service();
        com.strater.jenn.OrderService port = service.getOrderServicePort();
        return port.orderProduct(orderNumber, customerName, amount, product);
    }

    private static String payOrder(java.lang.String orderNumber, java.lang.String creditCardNumber) {
        com.strater.jenn.OrderService_Service service = new com.strater.jenn.OrderService_Service();
        com.strater.jenn.OrderService port = service.getOrderServicePort();
        return port.payOrder(orderNumber, creditCardNumber);
    }

    private static String getOrderInfo(java.lang.String orderNumber) {
        com.strater.jenn.OrderService_Service service = new com.strater.jenn.OrderService_Service();
        com.strater.jenn.OrderService port = service.getOrderServicePort();
        return port.getOrderInfo(orderNumber);
    }

    private static void clearOrders() {
        com.strater.jenn.OrderService_Service service = new com.strater.jenn.OrderService_Service();
        com.strater.jenn.OrderService port = service.getOrderServicePort();
        port.clearOrders();
    }
}

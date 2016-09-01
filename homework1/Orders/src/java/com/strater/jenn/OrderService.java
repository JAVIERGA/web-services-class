package com.strater.jenn;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.util.HashMap;

@WebService(serviceName = "OrderService")
public class OrderService {
    
    HashMap<String, Order> orders = new HashMap<String, Order>();

    @WebMethod(operationName = "orderProduct")
    public String orderProduct(
            @WebParam(name = "orderNumber") String orderNumber,
            @WebParam(name = "customerName") String customerName,
            @WebParam(name = "amount") Integer amount,
            @WebParam(name = "product") String product) {
        Order newOrder = new Order(orderNumber, customerName, product, amount);
        orders.put(orderNumber, newOrder);
        return orderNumber;
    }
    
    @WebMethod(operationName = "payOrder")
    public String payOrder( @WebParam(name = "orderNumber") String orderNumber,
            @WebParam(name = "creditCardNumber") String creditCardNumber) {
        Order order = orders.get(orderNumber);
        order.setPaid(true);
        return "Order: " + orderNumber + " is now paid";
    }
    
    @WebMethod(operationName = "getOrderInfo")
    public String getOrderInfo(
            @WebParam(name = "orderNumber") String orderNumber) {
        Order order = orders.get(orderNumber);
        return "Order number: " + orderNumber + ": Customer " + 
                order.getCustomerName() + " has ordered " + order.getAmount() + 
                " " + order.getProductName() + ". " + paidText(order.isPaid());
    }
    
    private String paidText(Boolean paid) {
      String paidText = "Not yet paid";
        if(paid) {
            paidText = "Is paid";
        }
        return paidText;
    }
    
    // for testing purposed
    public void clearOrders() {
        orders = new HashMap<String,Order>();
    }
}

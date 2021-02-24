package org.reallume.model.cart;

import org.reallume.model.order.Order;

import java.util.ArrayList;
import java.util.List;

public class CommonCart implements Cart{

    List<Order> orders;

    public CommonCart(){
        orders = new ArrayList<>();
    }

    @Override
    public void addOrder(Order order) {
        orders.add(order);
    }

    @Override
    public void removeOrderById(Long id) {
        orders.removeIf(pizza -> pizza.getId().equals(id));
    }

    @Override
    public void removeAll() {
        orders.clear();
    }

    @Override
    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public Double getOverallCost() {
        Double overall = 0D;
        for (Order order:orders) {
            overall += order.getProduct().getPrice() * order.getQuantity();
        }
        return overall;
    }
}
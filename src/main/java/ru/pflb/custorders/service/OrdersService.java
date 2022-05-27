package ru.pflb.custorders.service;

public interface OrdersService {
    Long addOrder(long customerId, String value, String comment);
    Long deleteOrder(long orderId);
}

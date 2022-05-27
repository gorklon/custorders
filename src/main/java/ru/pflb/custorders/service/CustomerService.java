package ru.pflb.custorders.service;

public interface CustomerService {
    Long addCustomer(String firstName, String lastName);
    String getAllOrdersByCustomerId(long customerId);
}

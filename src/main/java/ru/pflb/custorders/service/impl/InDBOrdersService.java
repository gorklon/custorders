package ru.pflb.custorders.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pflb.custorders.dto.Customer;
import ru.pflb.custorders.dto.Orders;
import ru.pflb.custorders.repository.CustomerRepository;
import ru.pflb.custorders.repository.OrdersRepository;
import ru.pflb.custorders.service.OrdersService;

@Component
public class InDBOrdersService implements OrdersService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    OrdersRepository ordersRepository;

    @Override
    public Long addOrder(long customerId, String value, String comment) {
        Customer customer = customerRepository.findById(customerId);
        if (customer != null) {
            Orders order = new Orders(value, comment, customer);
            ordersRepository.save(order);
            return order.getId();
        }
        else {
            return -1L;
        }
    }

    @Override
    public Long deleteOrder(long orderId) {
        Orders orders = ordersRepository.findById(orderId);
        if (orders != null) {
            ordersRepository.deleteById(orderId);
            return 1L;
        }
        else {
            return -2L;
        }
    }
}

package ru.pflb.custorders.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pflb.custorders.dto.Customer;
import ru.pflb.custorders.dto.Orders;
import ru.pflb.custorders.repository.CustomerRepository;
import ru.pflb.custorders.repository.OrdersRepository;
import ru.pflb.custorders.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

@Component
public class InDBCustomerService implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    OrdersRepository ordersRepository;

    @Override
    public Long addCustomer(String firstName, String lastName) {
        Customer customer = customerRepository.save(new Customer(firstName, lastName));
        return customer.getId();
    }

    @Override
    public String getAllOrdersByCustomerId(long customerId) {
        String str = "";
        Customer customer = customerRepository.findById(customerId);
        if (customer != null) {
            List<Orders> list = new ArrayList<>();
            ordersRepository.findByCustomerId(customerId).forEach(e -> list.add(e));
            for (Orders s : list) {
                str += s + ",";
            }
        }
        else {
            str = "-2";
        }
        return str;
    }

}

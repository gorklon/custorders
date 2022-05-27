package ru.pflb.custorders.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.pflb.custorders.repository.CustomerRepository;
import ru.pflb.custorders.repository.OrdersRepository;
import ru.pflb.custorders.service.CustomerService;

@RestController
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    OrdersRepository ordersRepository;

    @GetMapping(path = "/customer/add/{firstName}/{lastName}")
    public Long addCustomer(@PathVariable String firstName, @PathVariable String lastName) {
        return customerService.addCustomer(firstName, lastName);
    }

    @GetMapping("/customer/{customerId}/orders")
    public String getAllOrdersByCustomerId(@PathVariable long customerId) {
        return customerService.getAllOrdersByCustomerId(customerId);
    }
}
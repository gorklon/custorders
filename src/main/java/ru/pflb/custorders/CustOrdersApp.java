package ru.pflb.custorders;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.pflb.custorders.dto.Customer;
import ru.pflb.custorders.dto.Orders;
import ru.pflb.custorders.repository.CustomerRepository;
import ru.pflb.custorders.repository.OrdersRepository;

@SpringBootApplication
public class CustOrdersApp {

    private static final Logger log = LoggerFactory.getLogger(CustOrdersApp.class);

    public static void main(String[] args) {
        SpringApplication.run(CustOrdersApp.class, args);
    }

    @Bean
    public CommandLineRunner demo(CustomerRepository customerRepository, OrdersRepository orderRepository) {
        return (args) -> {
            // save a few customers
            Customer customer1 = new Customer("Jack", "Bauer");
            customerRepository.save(customer1);
            Orders order1 = new Orders("value1", "comment1", customer1);
            Orders order2 = new Orders("value2", "comment2", customer1);
            Orders order3 = new Orders("value2", "comment2", customer1);
            orderRepository.save(order3);
            orderRepository.save(order2);
            orderRepository.save(order1);

            customerRepository.save(new Customer("Chloe", "O'Brian"));
            customerRepository.save(new Customer("Kim", "Bauer"));
            customerRepository.save(new Customer("David", "Palmer"));
            customerRepository.save(new Customer("Michelle", "Dessler"));
        };
    }
}

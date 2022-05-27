package ru.pflb.custorders.http;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.pflb.custorders.service.OrdersService;

@RestController
public class OrdersController {
    private final OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping(path = "/order/add/{customerId}/{value}/{comment}")
    public Long addOrder(@PathVariable long customerId, @PathVariable String value, @PathVariable String comment) {
        return ordersService.addOrder(customerId, value, comment);
    }

    @GetMapping(path = "/order/delete/{orderId}")
    public Long deleteOrder(@PathVariable long orderId) {
        return ordersService.deleteOrder(orderId);
    }

}

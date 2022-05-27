package ru.pflb.custorders.repository;

import org.springframework.data.repository.CrudRepository;
import ru.pflb.custorders.dto.Orders;

import java.util.List;

public interface OrdersRepository extends CrudRepository<Orders, Long> {
    List<Orders> findByCustomerId(Long id);
    Orders findById(long id);
}

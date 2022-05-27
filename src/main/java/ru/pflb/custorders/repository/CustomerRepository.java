package ru.pflb.custorders.repository;

import org.springframework.data.repository.CrudRepository;
import ru.pflb.custorders.dto.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Customer findById(long id);
}

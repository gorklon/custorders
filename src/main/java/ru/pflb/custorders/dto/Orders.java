package ru.pflb.custorders.dto;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String value;
    private String comment;
    private Timestamp createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    protected Orders() {}

    public Orders(String value, String comment, Customer customer) {
        this.value = value;
        this.comment = comment;
        this.createdAt = new Timestamp(System.currentTimeMillis());
        setCustomer(customer);
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ": value=" + value + ", comment=" + comment + ", createdAt=" + createdAt + ", customerId=" + customer + "]";
    }
}

package com.smartcon.test.repository;

import com.smartcon.test.entity.Customer;
import com.smartcon.test.entity.DomainObject;

import java.util.List;

public interface CustomerRepo<V extends DomainObject> {
    void create(V object);
    void delete(V object);
    List<Customer> getCustomers();
}

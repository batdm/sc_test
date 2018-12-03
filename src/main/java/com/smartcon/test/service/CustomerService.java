package com.smartcon.test.service;

import com.smartcon.test.entity.Customer;

import java.util.List;

public interface CustomerService {
    public boolean create (Customer problem);

    public List<Customer> getCustomers();
}

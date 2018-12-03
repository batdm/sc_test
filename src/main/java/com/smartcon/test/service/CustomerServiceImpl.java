package com.smartcon.test.service;

import com.smartcon.test.entity.Customer;
import com.smartcon.test.repository.CustomerRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    @Qualifier("customerRepo")
    private CustomerRepo customerRepo;

    @Override
    public boolean create(Customer problem) {
        try {
            customerRepo.create(new Customer(problem.getId(), problem.getName(), problem.getAddress()));
            return true;
        } catch (Exception e) {
            LOG.error("ERROR SAVING DATA: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public List<Customer> getCustomers() {
        return customerRepo.getCustomers();
    }
}

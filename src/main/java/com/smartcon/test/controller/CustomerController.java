package com.smartcon.test.controller;

import com.smartcon.test.entity.Customer;
import com.smartcon.test.exception.RestException;
import com.smartcon.test.service.CustomerService;
import com.smartcon.test.utils.Ajax;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

public class CustomerController extends ExceptionHandlerController {
    private static final Logger LOG = Logger.getLogger(CustomerController.class);

    @Autowired
    @Qualifier("customerService")
    private CustomerService customerService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> create(@RequestParam("data") Customer customer) throws RestException {
        try {
            if (customer == null) {
                return Ajax.emptyResponse();
            }
            customerService.create(customer);
            return Ajax.emptyResponse();
        } catch (Exception e) {
            throw new RestException(e);
        }
    }

    @RequestMapping(value = "/getCustomers", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> getCustomers() throws RestException {
        try {
            List<Customer> result = customerService.getCustomers();
            return Ajax.successResponse(result);
        } catch (Exception e) {
            throw new RestException(e);
        }
    }
}

package com.smartcon.test.repository;

import com.smartcon.test.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Repository("customerRepo")
public class CustomerRepoImpl implements CustomerRepo<Customer> {

    @Autowired
    protected JdbcOperations jdbcOperations;

    @Override
    public void create(Customer object) {

        jdbcOperations.update("INSERT INTO customer(\n" +
                "            name, address)\n" +
                "    VALUES (?, ?);", object.getName(), object.getAddress());
    }

    @Override
    public void delete(Customer object) {
        jdbcOperations.update("DELETE FROM customer\n" +
                " WHERE id = '" + object.getId() + "';");
    }

    @Override
    public List<Customer> getCustomers() {
        List<Customer> result = new ArrayList<>();
        SqlRowSet rowSet = jdbcOperations.queryForRowSet("SELECT id, name, address FROM customer ORDER BY id;");
        while (rowSet.next()) {
            Customer customer = new Customer(rowSet.getInt("id"), rowSet.getString("name"), rowSet.getString("address"));
            result.add(customer);
        }
        return result;
    }
}

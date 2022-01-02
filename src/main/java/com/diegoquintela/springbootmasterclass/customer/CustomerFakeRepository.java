package com.diegoquintela.springbootmasterclass.customer;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

//@Repository wont need this because of customer configuration (see CcustomerRepository)
@Component(value = "fake") //makes it available as a bean. values if fake because its a fake repository
public class CustomerFakeRepository implements CustomerRepo {

    @Override
    public List<Customer> getCustomer() {
        return Arrays.asList(
                new Customer(1L, "James Bond", "password123"),
                new Customer(2L, "Esther Lara", "123password")
        );
    }
}


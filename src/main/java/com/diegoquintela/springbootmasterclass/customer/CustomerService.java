package com.diegoquintela.springbootmasterclass.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // for dependency injection. creates a bean which we can inject in other places
public class CustomerService { //CustomerService is a singleton, thus, we can inject in many classes and get the same instances
   //reference to the DAO layer
    private final CustomerRepo customerRepo;

    @Autowired
    public CustomerService(CustomerRepo customerRepo) { //@Qualifier("fake")[\\\\\\\\\\\\\\\\\\\ injects the fake repo, with the fake value
        this.customerRepo = customerRepo;
    }

    List<Customer> getCustomer() {
       return customerRepo.getCustomer();
   }
}

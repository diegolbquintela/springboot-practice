package com.diegoquintela.springbootmasterclass.customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    // the controller shouldn't be responsible for handling business logic/validation
    // instead, it should be handling requests with the client, passing communicating with the service layer
    // @GetMapping
    // Customer getCustomer() {
    //    return new Customer(1L, "james bond");
    // }

    // we need to instantiate the CustomerService
    ////step 1
    private final CustomerService customerService;

    ////step 2: constructor (use dependency injection)
    //inject a customerService inside the constructor instead
    @Autowired //we want to autowire/inject customerService in this constructor
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //the issue of using new keyword with the constructor is that we would have to instantiate
    // everytime we wanted to have this instance of customerService in other classes. thus, causing
    // code repetition
//    public CustomerController() {
//        customerService = new CustomerService();
//    }

    ////step 3: the requests
    @GetMapping
    List<Customer> getCustomer() {
        return customerService.getCustomer();
    }
}


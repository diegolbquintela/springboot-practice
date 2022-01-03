package com.diegoquintela.springbootmasterclass.customer;


import com.diegoquintela.springbootmasterclass.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(path = "api/v2/customers")
@RestController
public class CustomerControllerV2 {

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
    public CustomerControllerV2(CustomerService customerService) {
        this.customerService = customerService;
    }

    //the issue of using new keyword with the constructor is that we would have to instantiate
    // everytime we wanted to have this instance of customerService in other classes. thus, causing
    // code repetition
//    public CustomerController() {
//        customerService = new CustomerService();
//    }

    ////step 3: the requests
    //request all customers
    @GetMapping
    List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    //request customer by id
    @GetMapping(path = "{customerId}")
    Customer getCustomer(@PathVariable("customerId") Long id) {
        return customerService.getCustomer(id);
    }

    //for testing exceptions
    @GetMapping(path = "{customerId}/exception")
    Customer getCustomerException(@PathVariable("customerId") Long id) {
        throw new ApiRequestException("ApiRequestException for customer " + id);
    }

    @PostMapping
    void createNewCustomer(@Valid @RequestBody Customer customer) { //@RequestBody takes the Json payload and map it into customer
        System.out.println("POST REQUEST...");
        System.out.println(customer);
    }

    @PutMapping
    void updateCustomer(@RequestBody Customer customer) {
        System.out.println("UPDATE REQUEST... " + customer);
    }

    @DeleteMapping(path = "{customerId}")
    void deleteCustomer(@PathVariable("customerId") Long id) {
        System.out.println("DELETE REQUEST FOR ID... " + id);

    }
}


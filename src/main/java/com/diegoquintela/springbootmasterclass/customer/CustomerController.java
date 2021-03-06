package com.diegoquintela.springbootmasterclass.customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RequestMapping(path="api/v1/customer")
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
    @GetMapping(value = "all")
    List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @PostMapping
    void createNewCustomer(@RequestBody Customer customer) { //@RequestBody takes the Json payload and map it into customer
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


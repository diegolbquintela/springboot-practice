package com.diegoquintela.springbootmasterclass.customer;

import com.diegoquintela.springbootmasterclass.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service // for dependency injection. creates a bean which we can inject in other places
public class CustomerService { //CustomerService is a singleton, thus, we can inject in many classes and get the same instances
//   //reference to the DAO layer
//    private final CustomerRepo customerRepo;

    //logging sl4j
    private final static Logger LOGGER = LoggerFactory.getLogger(CustomerService.class); //log CustomerService class

    //now that we used Jpa to connect to H2, we don't need to inject CustomerRepo
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) { //@Qualifier("fake")[\\\\\\\\\\\\\\\\\\\ injects the fake repo, with the fake value
        this.customerRepository = customerRepository;
    }

    List<Customer> getCustomers() {
        LOGGER.info("getCustomer was called");
       return customerRepository.findAll(); // findAll comes from Jpa
   }

//   Customer getCustomer(Long id) {
//        return getCustomers()
//                .stream()
//                .filter(customer -> customer.getId().equals(id))
//                .findFirst()
//                .orElseThrow(() -> new NotFoundException("customer with id " + id + " not found"));
//    }

    Customer getCustomer(Long id) {
        return customerRepository
                .findById(id)
                .orElseThrow(
                        () -> new NotFoundException(
                                "customer with id " + id + " not found"
                        )
                );
    }
}

package com.diegoquintela.springbootmasterclass.customer;

import java.util.Collections;
import java.util.List;

//@Repository we can remove because we are instantiating them within the customer configuration, otherwise
//@Primary //marks as primary implementation, but won't be require because everything is running within CustomerConfiguration
public class CustomerRepository implements CustomerRepo {
    @Override // will be used to connect to a real DB
    public List<Customer> getCustomer() {
        // TODO connect to a real db
        return Collections.singletonList(
                new Customer(1L, "TODO. implement real db", "todo")

        );
    }
}

package me.soshin.springdatademo;

import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;


@RepositoryEventHandler(Customer.class)
public class CustomerEventHandler {

    @HandleBeforeCreate
    public void handleCustomerBeforeCreate(Customer customer) {
        System.out.println(String.format("I could do something with %s", customer));
        customer.name += "%";
    }
}

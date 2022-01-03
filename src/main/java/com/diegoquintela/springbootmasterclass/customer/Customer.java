package com.diegoquintela.springbootmasterclass.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table //@Table and @Entitiy allows us to map the class Customer into our table in our db
public class Customer {

    @Id //for Jpa at CustomerRepository Interface
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    @Email() //pass regex to validate
    private String email;

    @NotBlank
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // for requests, so we can access password without reading data from client
    private String password;

    public Customer(Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Customer() {
    }

    @JsonProperty("customerId") //changing the format on requests via jackson library
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;

    }

    public String getEmail() {
        return email;
    }

    @JsonIgnore //jackson library: annotation for hidding this from client on requests
    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

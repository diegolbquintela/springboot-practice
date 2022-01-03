package com.diegoquintela.springbootmasterclass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableFeignClients
public class SpringBootMasterclassApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMasterclassApplication.class, args);
    }

}

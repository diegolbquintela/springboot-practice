package com.diegoquintela.springbootmasterclass.jsonplaceholder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JSONPlaceHolderConfiguration {

    //inject client
    @Bean("jsonplaceholder")
    CommandLineRunner runner(JSONPlaceHolderClient jsonPlaceHolderClient) {
        return args -> {
            System.out.println("https://jsonplaceholder.typicode.com/");
            System.out.println(jsonPlaceHolderClient.getPosts().size());

            System.out.println();

            System.out.println("https://jsonplaceholder.typicode.com/1");
            System.out.println(jsonPlaceHolderClient.getPost(1));

            // returns
            //https://jsonplaceholder.typicode.com/
            //  100

            //  https://jsonplaceholder.typicode.com/1
            //  Post{userId=1, id=1, title='sunt aut facere repellat provident occaecati excepturi optio reprehenderit', body='quia et suscipit
            //  suscipit recusandae consequuntur expedita et cum
            //  reprehenderit molestiae ut ut quas totam
            //  nostrum rerum est autem sunt rem eveniet architecto'}
        };
    }
}

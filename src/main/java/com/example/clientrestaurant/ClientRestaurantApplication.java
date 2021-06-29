package com.example.clientrestaurant;

import com.example.clientrestaurant.controller.ClientController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
//@ComponentScan(basePackages={"com.example.clientrestaurant.controller"})
public class ClientRestaurantApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientRestaurantApplication.class, args);
    }

}

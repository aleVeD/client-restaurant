package com.example.clientrestaurant;

import com.example.clientrestaurant.controller.ClientController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
//@ComponentScan(basePackages={"com.example.clientrestaurant.controller"})
public class ClientRestaurantApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientRestaurantApplication.class, args);
    }

}

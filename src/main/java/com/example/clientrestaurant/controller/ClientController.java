package com.example.clientrestaurant.controller;

import com.example.clientrestaurant.model.Client;
import com.example.clientrestaurant.model.Menu;

import com.example.clientrestaurant.services.ClientService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    ClientService clientService;

    //@Autowired
   // private RestTemplate restTemplate;
/*
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }
    @GetMapping("/")
    public ResponseEntity<List<Client>> getAllClients(){
        List<Client> clients = clientService.findAll();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }
    */


    @PostMapping("/")
    public ResponseEntity<Client> saveClient(Client c){
        Client client =clientService.save(c);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }
    /*
    @HystrixCommand(fallbackMethod = "fallbackMethod2")
    @GetMapping("menu/")
    public Menu getAllFoods(){
        Menu foods = restTemplate.getForObject("http://RECIPE/menu/", Menu.class);
        return foods;
    }
    private Menu fallbackMethhod2(){
        return new Menu(1364L, "sushi");
    }
    */

}

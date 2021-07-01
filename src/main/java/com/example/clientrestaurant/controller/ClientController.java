package com.example.clientrestaurant.controller;

import clientrestaurant.client.MenuClient;
import com.example.clientrestaurant.dto.MenuDto;
import com.example.clientrestaurant.model.Client;
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

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    ClientService clientService;
    @Autowired
    private MenuClient client;

    public ClientController(ClientService clientService, MenuClient client) {
        this.clientService = clientService;
        this.client = client;
    }

    @HystrixCommand(fallbackMethod = "fallbackMethhod2")
    @GetMapping("menu/")
    public MenuDto getAllFoods(){
        MenuDto foods = client.getAllMenu();
        return foods;
    }
    private List<MenuDto> fallbackMethhod2(){
        MenuDto menu1 = MenuDto.builder().id(1364L).name("sushi").build();
        MenuDto menu2 = MenuDto.builder().id(757L).name("Arroz").build();
        List<MenuDto> menu = new ArrayList<>();
        menu.add(menu1);
        menu.add(menu2);
        return menu;
    }

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

    @PostMapping("/")
    public ResponseEntity<Client> saveClient(Client c){
        Client client =clientService.save(c);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }
}

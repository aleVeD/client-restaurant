package com.example.clientrestaurant.services;


import com.example.clientrestaurant.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    List<Client> findAll();
    <S extends Client> S save(S s);
    Optional<Client> findById(Long aLong);
}

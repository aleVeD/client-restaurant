package com.example.clientrestaurant.services;

import com.example.clientrestaurant.exceptions.NotFoundClientException;
import com.example.clientrestaurant.model.Client;
import com.example.clientrestaurant.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService{
    @Autowired
    private ClientRepository clientRepository;
    @Override
    public List<Client> findAll() {
        List<Client> clients = clientRepository.findAll();
        if (clients.isEmpty()) {
            throw new NotFoundClientException("No se encuentran clientes");
        }else{
            return clientRepository.findAll();
        }

    }



    @Override
    public <S extends Client> S save(S s) {
        Optional<Client> client = clientRepository.findById(s.getId());
        if (client != null ) {
           return clientRepository.save(s);
        }else{
            return null;
        }
    }


    @Override
    public Optional<Client> findById(Long aLong) {
        Optional<Client> client = null;
        if(aLong != null) {
            client = clientRepository.findById(aLong);
        }
        return client;
    }

}

package com.example.clientrestaurant.services;

import com.example.clientrestaurant.exceptions.NotFoundClientException;
import com.example.clientrestaurant.model.Client;
import com.example.clientrestaurant.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public List<Client> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Client> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Client> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Client client) {

    }

    @Override
    public void deleteAll(Iterable<? extends Client> iterable) {

    }

    @Override
    public void deleteAll() {

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
    public <S extends Client> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Client> findById(Long aLong) {
        Optional<Client> client = null;
        if(aLong != null) {
            client = clientRepository.findById(aLong);
        }
        return client;
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Client> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Client> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Client getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Client> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Client> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Client> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Client> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Client> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Client> boolean exists(Example<S> example) {
        return false;
    }
}

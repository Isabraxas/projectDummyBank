package com.viridian.dummybank.service;

import com.viridian.dummybank.model.Cliente;
import com.viridian.dummybank.repository.ClienteRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcelo on 20-02-18
 */
@Service
public class ClienteServiceImpl implements ClienteService {

    // logger
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(ClienteServiceImpl.class);
    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> findAllClientes() {
        log.info("Mostrando a todos los clientes");
        List<Cliente> clientes = new ArrayList<>();
        clienteRepository.findAll().forEach(clientes::add);
        return clientes;
    }

    @Override
    public Cliente findOneById(Long id) {
        log.info("Mostrando al cliente Id: "+ id);
        Cliente cliente = clienteRepository.findOne(id);
        if(cliente == null){
            log.error("Cliente ID: "+ id +" no encontrado");
            // todo error not found
        }
        return cliente;
    }

    @Override
    public void saveOrUpdateCliente(Cliente cliente) {
        log.info("Adicionando/Actualizando Cliente");
        clienteRepository.save(cliente);
    }

    @Override
    public void deleteCliente(Long id) {
        log.info("Eliminando Cliente Id: " + id);
        clienteRepository.delete(id);
    }
}

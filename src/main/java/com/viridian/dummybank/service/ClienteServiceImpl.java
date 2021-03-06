package com.viridian.dummybank.service;

import com.viridian.dummybank.model.Cliente;
import com.viridian.dummybank.repository.ClienteRepository;
import com.viridian.dummybank.error.*;
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
        List<Cliente> clientes = new ArrayList<>();
        clienteRepository.findAll().forEach(clientes::add);
        return clientes;
    }

    @Override
    public Cliente findOneById(Long id) {
        Cliente cliente = clienteRepository.findOne(id);
        if(cliente == null){
            log.error("cliente: "+id +" no encontradp en BD");
            // throw ERROR
            /*// ERROR REDIRECCIONANDO A PAGINA DE ERROR*/
            String errorMsg = "Cliente ID: "+ id +" no encontrado";
            /*
            log.error(errorMsg);
            log.info("cargando mensaje error");
            throw new NoEncontradoException(errorMsg);
            */
            // ERROR REDIRECCIONANDO UNA CLASE ERROR
            throw new NoEncontradoRestException(errorMsg, new ErrorNoEncontrado(id,"001","no se encontro al Cliente en la BD","Hemos encontrado un error intentelo mas tarde"));
        }
        return cliente;
    }

    @Override
    public void saveOrUpdateCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public void deleteCliente(Long id) {
        clienteRepository.delete(id);
    }
}

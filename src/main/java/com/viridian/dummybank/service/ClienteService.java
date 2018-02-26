package com.viridian.dummybank.service;

import com.viridian.dummybank.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by marcelo on 20-02-18
 */
public interface ClienteService {

    List<Cliente> findAllClientes();

    Cliente findOneById(Long id);

    void saveOrUpdateCliente(Cliente cliente);

    void deleteCliente(Long id);
}

package com.viridian.dummybank.rest.repository;

import com.viridian.dummybank.rest.model.ClienteRestModel;

import java.util.List;

public interface ClienteMapper  {

    List<ClienteRestModel> findAllClientes();

    ClienteRestModel findClienteById(Long id);
}

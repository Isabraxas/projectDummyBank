package com.viridian.dummybank.rest.repository;

import com.viridian.dummybank.rest.model.ClienteRestModel;
import com.viridian.dummybank.rest.model.ProductoBancarioClientePJ;
import com.viridian.dummybank.rest.model.ProductoBancarioClientePN;

import java.util.List;

public interface ClienteMapper  {

    List<ClienteRestModel> findAllClientes();

    ClienteRestModel findClienteById(Long id);

    // Join Cliente con Cuentas
    ClienteRestModel findClienteWithCuentas(Long idCliente);
    // Join tabla cliente , persona y cuenta
    ProductoBancarioClientePJ findClienteWithDataAndCuentas(Long idCliente);
}

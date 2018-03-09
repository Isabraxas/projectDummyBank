package com.viridian.dummybank.rest.service;

import com.viridian.dummybank.rest.model.ProductoBancarioCliente;
import com.viridian.dummybank.rest.model.ProductoBancarioClientePJ;

/**
 * Created by marcelo on 08-03-18
 */
public interface ClienteRestService {

    ProductoBancarioCliente getClienteByClienteId(Long id);

    ProductoBancarioClientePJ getClienteJuridicoByClienteId(Long id);
}

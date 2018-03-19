package com.viridian.dummybank.jooq.service;

import com.viridian.dummybank.rest.model.ProductoBancarioClientePJ;
import com.viridian.dummybank.rest.model.ProductoBancarioClientePN;

/**
 * Created by marcelo on 19-03-18
 */
public interface ClienteJooqService {

    ProductoBancarioClientePN getClienteNaturalbyClienteId(Long idCliente);

    ProductoBancarioClientePJ getClienteJuridicobyClienteId(Long idCliente);
}

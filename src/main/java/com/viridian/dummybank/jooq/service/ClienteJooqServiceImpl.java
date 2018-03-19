package com.viridian.dummybank.jooq.service;

import com.viridian.dummybank.jooq.repository.ClienteJooqRepository;
import com.viridian.dummybank.rest.model.ProductoBancarioClientePJ;
import com.viridian.dummybank.rest.model.ProductoBancarioClientePN;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by marcelo on 19-03-18
 */
@Service
public class ClienteJooqServiceImpl implements ClienteJooqService {

    // logger
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(ClienteJooqServiceImpl.class);

    // repositorio
    private final ClienteJooqRepository clienteJooqRepository;

    @Autowired
    public ClienteJooqServiceImpl(ClienteJooqRepository clienteJooqRepository) {
        this.clienteJooqRepository = clienteJooqRepository;
    }

    @Override
    public ProductoBancarioClientePN getClienteNaturalbyClienteId(Long idCliente) {
        return clienteJooqRepository.getClienteNatById(idCliente);
    }

    @Override
    public ProductoBancarioClientePJ getClienteJuridicobyClienteId(Long idCliente) {
        return clienteJooqRepository.getClienteJurById(idCliente);
    }
}

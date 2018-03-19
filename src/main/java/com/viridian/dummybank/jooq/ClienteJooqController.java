package com.viridian.dummybank.jooq;

import com.viridian.dummybank.error.NoEncontradoRestException;
import com.viridian.dummybank.rest.model.ProductoBancarioClienteError;
import com.viridian.dummybank.rest.model.ProductoBancarioClientePJ;
import com.viridian.dummybank.rest.model.ProductoBancarioClientePN;
import com.viridian.dummybank.jooq.service.ClienteJooqService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


/**
 * Created by marcelo on 19-03-18
 */
@RestController
public class ClienteJooqController {
    // logger
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(ClienteJooqController.class);

    // servicios
    private final ClienteJooqService clienteJooqService;

    @Autowired
    public ClienteJooqController(ClienteJooqService clienteJooqService) {
        this.clienteJooqService = clienteJooqService;
    }

    @GetMapping("jooq/cliente/N/rest/show/{id}")
    public ProductoBancarioClientePN getClientePerN(@PathVariable String id){
        return clienteJooqService.getClienteNaturalbyClienteId(Long.valueOf(id));
    }

    @GetMapping("jooq/cliente/J/rest/show/{id}")
    public ProductoBancarioClientePJ getClientePerJ(@PathVariable String id){
        return clienteJooqService.getClienteJuridicobyClienteId(Long.valueOf(id));
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoEncontradoRestException.class)
    public ProductoBancarioClienteError handleNotFound(NoEncontradoRestException exception){
        ProductoBancarioClienteError error = new ProductoBancarioClienteError();
        error.setIdCliente(exception.getErrorNoEncontrado().getId());
        error.setEstado("error");
        error.setError(exception.getErrorNoEncontrado());
        return error;
    }
}

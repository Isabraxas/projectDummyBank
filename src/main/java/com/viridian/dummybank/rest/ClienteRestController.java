package com.viridian.dummybank.rest;

import com.viridian.dummybank.controller.ClienteController;
import com.viridian.dummybank.dao.CuentaRepository;
import com.viridian.dummybank.error.NoEncontradoException;
import com.viridian.dummybank.error.NoEncontradoRestException;
import com.viridian.dummybank.model.Cliente;
import com.viridian.dummybank.model.Cuenta;
import com.viridian.dummybank.model.persona.Persona;
import com.viridian.dummybank.rest.model.ProductoBancarioCliente;
import com.viridian.dummybank.rest.model.ProductoBancarioClienteError;
import com.viridian.dummybank.rest.request.ClienteRequest;
import com.viridian.dummybank.rest.service.ClienteRestService;
import com.viridian.dummybank.service.ClienteService;
import com.viridian.dummybank.service.persona.PersonaJuridicaService;
import com.viridian.dummybank.service.persona.PersonaNaturalService;
import com.viridian.dummybank.service.persona.PersonaService;
import com.viridian.dummybank.utils.ClienteUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by marcelo on 07-03-18
 */
@RestController
public class ClienteRestController {

    // logger
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(ClienteController.class);

    // servicios
    private final ClienteRestService clienteRestService;


    @Autowired
    public ClienteRestController(ClienteRestService clienteRestService) {
        this.clienteRestService = clienteRestService;
    }

    /**
     * Mostrar la informacion de un cliente - person natural en formato json
     */
    //@PostMapping("cliente/rest/show")
    //public ProductoBancarioCliente getCliente(@RequestBody ClienteRequest clienteRequest){
    //@CrossOrigin
    @GetMapping(value = "cliente/rest/show/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductoBancarioCliente getCliente(@PathVariable String id){
       return clienteRestService.getClienteByClienteId(Long.valueOf(id));
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

package com.viridian.dummybank.rest;

import com.viridian.dummybank.controller.ClienteController;
import com.viridian.dummybank.dao.CuentaRepository;
import com.viridian.dummybank.error.ErrorNoEncontrado;
import com.viridian.dummybank.error.NoEncontradoException;
import com.viridian.dummybank.error.NoEncontradoRestException;
import com.viridian.dummybank.model.Cliente;
import com.viridian.dummybank.model.Cuenta;
import com.viridian.dummybank.model.persona.Persona;
import com.viridian.dummybank.rest.model.ClienteRestModel;
import com.viridian.dummybank.rest.model.ProductoBancarioClientePN;
import com.viridian.dummybank.rest.model.ProductoBancarioClienteError;
import com.viridian.dummybank.rest.model.ProductoBancarioClientePJ;
import com.viridian.dummybank.rest.repository.ClienteMapper;
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

import java.util.List;

/**
 * Created by marcelo on 07-03-18
 */
@RestController
@RequestMapping("/api")
public class ClienteRestController {

    // loggerger
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(ClienteController.class);

    // servicios
    private final ClienteRestService clienteRestService;
    private final ClienteMapper clienteMapper;

    @Autowired
    public ClienteRestController(ClienteRestService clienteRestService, ClienteMapper clienteMapper) {
        this.clienteRestService = clienteRestService;
        this.clienteMapper = clienteMapper;
    }

    @GetMapping("/clientes")
    public List<ClienteRestModel> getClientes(){
        return clienteMapper.findAllClientes();
    }

    @GetMapping("/clientes/{id}")
    public ClienteRestModel getClientes(@PathVariable Long id){
        return clienteMapper.findClienteById(id);
    }

    @GetMapping("/clientes/{id}/cuentas")
    public ClienteRestModel getClienteWithCuentas(@PathVariable Long id){
        return clienteMapper.findClienteWithCuentas(id);
    }

    @GetMapping("/clientes/{id}/productos")
    public ProductoBancarioClientePJ getClienteWithProductos(@PathVariable Long id){
        ProductoBancarioClientePJ productoBancarioClientePJ = clienteMapper.findClienteWithDataAndCuentas(id);
        if(productoBancarioClientePJ == null){
            logger.info("El cliente no fue encotrado");
            String errorMsg = "Cliente ID: "+ id +" no encontrado";
            throw new NoEncontradoRestException(errorMsg, new ErrorNoEncontrado(id,"001","no se encontro al Cliente en la BD","Hemos encontrado un error intentelo mas tarde"));
        }
        logger.info("El cliente fue encotrado");
        productoBancarioClientePJ.setEstado("successful");
        return productoBancarioClientePJ;
    }

    /**
     * Mostrar la informacion de un cliente - person natural en formato json
     */
    //@PostMapping("cliente/rest/show")
    //public ProductoBancarioCliente getCliente(@RequestBody ClienteRequest clienteRequest){
    //@CrossOrigin
    @GetMapping(value = "cliente/N/rest/show/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductoBancarioClientePN getCliente(@PathVariable String id){
       return clienteRestService.getClienteByClienteId(Long.valueOf(id));
    }

    /**
     * Mostrar la informacion de un cliente - persona juridica en formato json
     */
    //@PostMapping("cliente/rest/show")
    //public ProductoBancarioCliente getCliente(@RequestBody ClienteRequest clienteRequest){
    //@CrossOrigin
    @GetMapping(value = "cliente/J/rest/show/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductoBancarioClientePJ getClientePerJ(@PathVariable String id){
        return clienteRestService.getClienteJuridicoByClienteId(Long.valueOf(id));
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

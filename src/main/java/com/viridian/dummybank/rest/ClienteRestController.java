package com.viridian.dummybank.rest;

import com.viridian.dummybank.controller.ClienteController;
import com.viridian.dummybank.dao.CuentaRepository;
import com.viridian.dummybank.error.NoEncontradoException;
import com.viridian.dummybank.error.NoEncontradoRestException;
import com.viridian.dummybank.model.Cliente;
import com.viridian.dummybank.model.Cuenta;
import com.viridian.dummybank.model.persona.Persona;
import com.viridian.dummybank.rest.model.ProductoBancarioCliente;
import com.viridian.dummybank.service.ClienteService;
import com.viridian.dummybank.service.persona.PersonaJuridicaService;
import com.viridian.dummybank.service.persona.PersonaNaturalService;
import com.viridian.dummybank.service.persona.PersonaService;
import com.viridian.dummybank.utils.ClienteUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by marcelo on 07-03-18
 */
@RestController
public class ClienteRestController {

    // logger
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(ClienteController.class);

    // servicios
    private final ClienteService clienteService;
    private final PersonaJuridicaService personaJuridicaService;
    private final PersonaNaturalService personaNaturalService;
    private final PersonaService personaService;

    // repositorios
    private  final CuentaRepository cuentaRepository;

    @Autowired
    public ClienteRestController(ClienteService clienteService, PersonaJuridicaService personaJuridicaService, PersonaNaturalService personaNaturalService, PersonaService personaService, CuentaRepository cuentaRepository) {
        this.clienteService = clienteService;
        this.personaJuridicaService = personaJuridicaService;
        this.personaNaturalService = personaNaturalService;
        this.personaService = personaService;
        this.cuentaRepository = cuentaRepository;
    }

    /**
     * Mostrara una cuenta en especifico, si es Persona Natural, o Juridica
     */
    @GetMapping("cliente/rest/show/{id}")
    public ProductoBancarioCliente getCliente(@PathVariable String id, Model model){
        ProductoBancarioCliente obj = new ProductoBancarioCliente();
        log.info("request informacion Cliente id: ");
        log.info("buscando al cliente en BD");
        Cliente cliente = clienteService.findOneById(Long.valueOf(id));
        log.info("cliente encontrado");
        obj.setIdCliente(cliente.getId());
        obj.setCuentas(cliente.getCuentas());
        log.info("buscando informacion de Persona Asociada");
        Persona persona = personaNaturalService.findOneById(cliente.getId()).getPersona();
        log.info("persona encontrada");

        obj.setEstado("successful");

        obj.setIdPersona (persona.getId());
        obj.setApellidoPaterno (persona.getApellidoPaterno());
        obj.setApellidoMaterno (persona.getApellidoMaterno());
        obj.setApellidoCasado (persona.getApellidoCasado());
        obj.setNombres (persona.getNombres());
        obj.setDocumentoIdentidad (persona.getDocumentoIdentidad());
        obj.setNumeroDocumento (persona.getNumeroDocumento());
        obj.setFechaNacimiento (persona.getFechaNacimiento());
        obj.setLugarNacimiento (persona.getLugarNacimiento());
        obj.setNacionalidad (persona.getNacionalidad());
        obj.setDomicilio (persona.getDomicilio());
        obj.setDomicilioTrabajo (persona.getDomicilioTrabajo());
        obj.setTelefono (persona.getTelefono());
        obj.setEmail (persona.getEmail());
        obj.setEstadoCivil (persona.getEstadoCivil());
        obj.setProfesion (persona.getProfesion());
        obj.setCaracterLegal (persona.getCaracterLegal());
        obj.setNombrePadre (persona.getNombrePadre());
        obj.setNombreMadre (persona.getNombreMadre());
        obj.setNombreConyuge (persona.getNombreConyuge());
        log.info("retornando informacion");
        return obj;
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

package com.viridian.dummybank.rest.service;

import com.viridian.dummybank.dao.CuentaRepository;
import com.viridian.dummybank.error.ErrorNoEncontrado;
import com.viridian.dummybank.error.NoEncontradoRestException;
import com.viridian.dummybank.model.Cliente;
import com.viridian.dummybank.model.persona.Persona;
import com.viridian.dummybank.model.persona.PersonaJuridica;
import com.viridian.dummybank.model.persona.PersonaNatural;
import com.viridian.dummybank.rest.model.*;
import com.viridian.dummybank.rest.repository.ClienteMapper;
import com.viridian.dummybank.rest.repository.PersonaJuridicaMapper;
import com.viridian.dummybank.rest.repository.PersonaMapper;
import com.viridian.dummybank.rest.repository.PersonaNaturalMapper;
import com.viridian.dummybank.service.ClienteService;
import com.viridian.dummybank.service.CuentaService;
import com.viridian.dummybank.service.persona.PersonaJuridicaService;
import com.viridian.dummybank.service.persona.PersonaNaturalService;
import com.viridian.dummybank.service.persona.PersonaService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

/**
 * Created by marcelo on 08-03-18
 */
@Service
public class ClienteRestServiceImpl implements ClienteRestService{

    // logger
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(ClienteRestServiceImpl.class);

    // servicios
    private final ClienteService clienteService;
    private final PersonaJuridicaService personaJuridicaService;
    private final PersonaNaturalService personaNaturalService;
    private final CuentaRestService cuentaRestService;



    // repositorios
    private  final CuentaRepository cuentaRepository;
    private  final PersonaMapper personaRepository;
    private  final ClienteMapper clienteRepository;
    private  final PersonaJuridicaMapper personaJuridicaRepository;
    private  final PersonaNaturalMapper personaNaturalRepository;

    @Autowired
    public ClienteRestServiceImpl(ClienteService clienteService, PersonaJuridicaService personaJuridicaService, PersonaNaturalService personaNaturalService, CuentaRestService cuentaRestService, CuentaRepository cuentaRepository, PersonaMapper personaRepository, ClienteMapper clienteRepository, PersonaJuridicaMapper personaJuridicaRepository, PersonaNaturalMapper personaNaturalRepository) {
        this.clienteService = clienteService;
        this.personaJuridicaService = personaJuridicaService;
        this.personaNaturalService = personaNaturalService;
        this.cuentaRestService = cuentaRestService;
        this.cuentaRepository = cuentaRepository;
        this.personaRepository = personaRepository;
        this.clienteRepository = clienteRepository;
        this.personaJuridicaRepository = personaJuridicaRepository;
        this.personaNaturalRepository = personaNaturalRepository;
    }

    @Override
    public ProductoBancarioClientePN getClienteByClienteId(Long id) {
        ProductoBancarioClientePN obj = new ProductoBancarioClientePN();
        log.info("request informacion Cliente id: ");
        log.info("buscando al cliente en BD");
        //Cliente cliente = clienteService.findOneById(clienteRequest.getIdCliente());
        Cliente cliente = clienteService.findOneById(id);
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

    @Override
    public ProductoBancarioClientePJ getClienteJuridicoByClienteId (Long id) {
        ProductoBancarioClientePJ obj = new ProductoBancarioClientePJ();

        log.info("request informacion Cliente id: ");
        log.info("buscando al cliente en BD");
        //Cliente cliente = clienteService.findOneById(clienteRequest.getIdCliente());
        Cliente cliente = clienteService.findOneById(id);
        log.info("cliente encontrado");
        obj.setIdCliente(cliente.getId());
        //obj.setCuentas(cliente.getCuentas());
        log.info("buscando informacion de Persona Asociada");
        PersonaJuridica personaJuridica = personaJuridicaService.findOneById(cliente.getId());
        Persona persona = personaJuridica.getRepresentanteLegal();

        log.info("persona encontrada");

        obj.setNombreRazon(personaJuridica.getNombreRazon());
        obj.setNit(personaJuridica.getNit());
        obj.setRegistroFundaempresa(personaJuridica.getRegistroFundaempresa());

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

    @Override
    public ProductoBancarioClientePJ getClienteWithDataAndCuentas(Long id) {
        ProductoBancarioClientePJ obj = new ProductoBancarioClientePJ();

        log.info("request informacion Cliente id: ");
        log.info("buscando al cliente en BD");
        //Cliente cliente = clienteService.findOneById(clienteRequest.getIdCliente());
        ClienteRestModel cliente = this.getClienteById(id);
        log.info("cliente encontrado");
        obj.setIdCliente(cliente.getIdCliente());
        obj.setCuentas(cliente.getCuentas());
        log.info("buscando informacion de Persona Asociada");
        PersonaRestModel persona = new PersonaRestModel();
        if(cliente.getTipo().equals("J")) {
            PersonaJuridicaRestModel personaJuridica = personaJuridicaRepository.findPersonaJuridicaById(cliente.getIdCliente());
            persona = personaRepository.findPersonaById(personaJuridica.getRepresentanteLegal());

            obj.setNombreRazon(personaJuridica.getNombreRazon());
            obj.setNit(personaJuridica.getNit());
            obj.setRegistroFundaempresa(personaJuridica.getRegistroFundaempresa());
        }else {
            PersonaNaturalRestModel personaNatural = this.getPersonaNaturalById(cliente.getIdCliente());
            persona = personaNatural.getPersona();
            //En el caso de querer hacer la busqueda sin relaciones
            // persona = personaRepository.findPersonaById(personaNatural.getPersonaId());
        }

        log.info("persona encontrada");

        obj.setEstado("successful");

        obj.setIdPersona (persona.getIdPersona());
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

    public ClienteRestModel getClienteById(Long id){
        ClienteRestModel cliente = clienteRepository.findClienteWithCuentas(id);
        if(cliente == null){
            log.error("cliente: "+id +" no encontrada en BD");
            String errorMsg = "Cliente ID: "+ id +" no encontrado";
            // ERROR REDIRECCIONANDO UNA CLASE ERROR
            throw new NoEncontradoRestException(errorMsg, new ErrorNoEncontrado(id,"001","no se encontro al Cliente en la BD","Hemos encontrado un error intentelo mas tarde"));
        }

        return cliente;
    }

    public PersonaNaturalRestModel getPersonaNaturalById(Long id){
        PersonaNaturalRestModel personaNatural = personaNaturalRepository.findPersonaNaturalById(id);
        if(personaNatural == null){
            log.error("Persona: "+id +" no encontrada en BD");
            String errorMsg = "Persona ID: "+ id +" no encontrada";
            // ERROR REDIRECCIONANDO UNA CLASE ERROR
            throw new NoEncontradoRestException(errorMsg, new ErrorNoEncontrado(id,"001","no se encontro a la lod datos de la Persona relacionada en la BD","Hemos encontrado un error intentelo mas tarde"));
        }

        return personaNatural;
    }

}

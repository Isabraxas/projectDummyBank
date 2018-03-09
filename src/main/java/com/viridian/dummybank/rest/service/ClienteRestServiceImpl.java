package com.viridian.dummybank.rest.service;

import com.viridian.dummybank.dao.CuentaRepository;
import com.viridian.dummybank.model.Cliente;
import com.viridian.dummybank.model.persona.Persona;
import com.viridian.dummybank.model.persona.PersonaJuridica;
import com.viridian.dummybank.rest.model.ProductoBancarioCliente;
import com.viridian.dummybank.rest.model.ProductoBancarioClientePJ;
import com.viridian.dummybank.service.ClienteService;
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
    private final PersonaService personaService;

    // repositorios
    private  final CuentaRepository cuentaRepository;

    @Autowired
    public ClienteRestServiceImpl(ClienteService clienteService, PersonaJuridicaService personaJuridicaService, PersonaNaturalService personaNaturalService, PersonaService personaService, CuentaRepository cuentaRepository) {
        this.clienteService = clienteService;
        this.personaJuridicaService = personaJuridicaService;
        this.personaNaturalService = personaNaturalService;
        this.personaService = personaService;
        this.cuentaRepository = cuentaRepository;
    }

    @Override
    public ProductoBancarioCliente getClienteByClienteId(Long id) {
        ProductoBancarioCliente obj = new ProductoBancarioCliente();
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
    public ProductoBancarioClientePJ getClienteJuridicoByClienteId(Long id) {
        ProductoBancarioClientePJ obj = new ProductoBancarioClientePJ();

        log.info("request informacion Cliente id: ");
        log.info("buscando al cliente en BD");
        //Cliente cliente = clienteService.findOneById(clienteRequest.getIdCliente());
        Cliente cliente = clienteService.findOneById(id);
        log.info("cliente encontrado");
        obj.setIdCliente(cliente.getId());
        obj.setCuentas(cliente.getCuentas());
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
}

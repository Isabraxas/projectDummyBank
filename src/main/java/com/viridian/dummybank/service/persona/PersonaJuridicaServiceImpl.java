package com.viridian.dummybank.service.persona;

import com.viridian.dummybank.model.persona.PersonaJuridica;
import com.viridian.dummybank.repository.persona.PersonaJuridicaRepository;
import com.viridian.dummybank.error.*;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcelo on 22-02-18
 */
@Service
public class PersonaJuridicaServiceImpl implements PersonaJuridicaService {

    // logger
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(PersonaJuridicaServiceImpl.class);
    private final PersonaJuridicaRepository personaJuridicaRepository;

    @Autowired
    public PersonaJuridicaServiceImpl(PersonaJuridicaRepository personaJuridicaRepository) {
        this.personaJuridicaRepository = personaJuridicaRepository;
    }

    @Override
    public List<PersonaJuridica> findAllPersonaJuridica() {
        log.info("Mostrando a todos los Clientes, personas juridicas");
        List<PersonaJuridica> personas = new ArrayList<>();
        personaJuridicaRepository.findAll().forEach(personas::add);
        return personas;
    }

    @Override
    public PersonaJuridica findOneById(Long id) {
        log.info("Mostrando al cliente, persona juridica Id: "+ id);
        PersonaJuridica persona = personaJuridicaRepository.findOne(id);
        if(persona == null){
            String errorMsg = "Persona Juridica Id: " + id + " no encontrada.";
            log.error(errorMsg);
            throw new NoEncontradoException(errorMsg);
        }
        return persona;
    }

    @Override
    public void saveOrUpdatePersonaJuridica(PersonaJuridica cliente) {
        log.info("Adicionando/Actualizando persona juridica");
        personaJuridicaRepository.save(cliente);
    }

    @Override
    public void deletePersonaJuridica(Long id) {
        log.info("Eliminando Persona Juridica Id: "+id);
        personaJuridicaRepository.delete(id);
    }
}

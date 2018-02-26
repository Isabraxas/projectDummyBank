package com.viridian.dummybank.service.persona;

import com.viridian.dummybank.model.persona.Persona;
import com.viridian.dummybank.repository.persona.PersonaRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcelo on 22-02-18
 */
@Service
public class PersonaServiceImpl implements PersonaService {

    // logger
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(PersonaJuridicaServiceImpl.class);

    private final PersonaRepository personaRepository;

    @Autowired
    public PersonaServiceImpl(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    public List<Persona> getAllPersonas() {
        log.info("Mostrando a todas las Personas");
        List<Persona> personas = new ArrayList<>();
        personaRepository.findAll().forEach(personas::add);
        return personas;
    }

    @Override
    public Persona findPersonaById(Long id) {
        log.info("Mostrando a Persona Id: " + id);
        Persona persona = personaRepository.findOne(id);
        if(persona == null){
            log.error("Persona Id: "+ id + " no encontrada");
            // todo error not found
        }
        return persona;
    }

    @Override
    public void saveOrUpdatePersona(Persona persona) {
        log.info("Adicionando/Actualizando Persona");
        personaRepository.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        log.info("Eliminando Persona Id: "+ id);
        personaRepository.delete(id);
    }
}

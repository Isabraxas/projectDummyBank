package com.viridian.dummybank.service.persona;

import com.viridian.dummybank.model.persona.PersonaNatural;
import com.viridian.dummybank.repository.persona.PersonaNaturalRepository;
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
public class PersonaNaturalServiceImpl implements PersonaNaturalService {

    // logger
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(PersonaNaturalServiceImpl.class);
    private final PersonaNaturalRepository personaNaturalRepository;

    @Autowired
    public PersonaNaturalServiceImpl(PersonaNaturalRepository personaNaturalRepository) {
        this.personaNaturalRepository = personaNaturalRepository;
    }

    @Override
    public List<PersonaNatural> findAllPersonasNaturales() {
        log.info("Mostrando a clientes, Personas Naturales");
        List<PersonaNatural> personas = new ArrayList<>();
        personaNaturalRepository.findAll().forEach(personas::add);
        return personas;
    }

    @Override
    public PersonaNatural findOneById(Long id) {
        log.info("Mostrando al cliente, persona natural id: " + id);
        PersonaNatural personaNatural = personaNaturalRepository.findOne(id);
        if(personaNatural == null){
            String errorMsg = "PersonaNatural Id: " + id + " no encontrada.";
            log.error(errorMsg);
            throw new NoEncontradoException(errorMsg);
        }
        return personaNatural;
    }

    @Override
    public void saveOrUpdatePersonaNatural(PersonaNatural personaNatural) {
        log.info("Adicionando/Actualizando PersonaNatural");
        personaNaturalRepository.save(personaNatural);
    }

    @Override
    public void deletePersonaNatural(Long id) {
        log.info("Eliminando Cliente Id: " + id);
        personaNaturalRepository.delete(id);
    }
}

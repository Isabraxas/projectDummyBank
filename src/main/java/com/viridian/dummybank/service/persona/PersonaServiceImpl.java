package com.viridian.dummybank.service.persona;

import com.viridian.dummybank.model.persona.Persona;
import com.viridian.dummybank.repository.persona.PersonaRepository;
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
        List<Persona> personas = new ArrayList<>();
        personaRepository.findAll().forEach(personas::add);
        return personas;
    }

    @Override
    public Persona findPersonaById(Long id) {
        Persona persona = personaRepository.findOne(id);
        if(persona == null){
            // error
            String errorMsg ="Persona Id: "+ id + " no encontrada";
            log.error(errorMsg);
            /*ERROR REDIRECCIONANDO A PAGINA DE ERROR*/
            //throw new NoEncontradoException(errorMsg);
            //log.error("cliente: "+id +" no encontradp en BD");

            /*ERROR REDIRECCIONANDO UNA CLASE ERROR*/
            throw new NoEncontradoRestException(errorMsg, new ErrorNoEncontrado(id,"001","no se encontro al Cliente en la BD","Hemos encontrado un error intentelo mas tarde"));
        }
        return persona;
    }

    @Override
    public void saveOrUpdatePersona(Persona persona) {
        personaRepository.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        personaRepository.delete(id);
    }
}

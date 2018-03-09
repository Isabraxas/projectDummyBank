package com.viridian.dummybank.rest;

import com.viridian.dummybank.error.EntidadError;
import com.viridian.dummybank.error.NoEncontradoRestException;
import com.viridian.dummybank.model.persona.Persona;
import com.viridian.dummybank.rest.model.PersonaError;
import com.viridian.dummybank.service.persona.PersonaService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by marcelo on 09-03-18
 */
@RestController
public class PersonaRestController {

    // logger
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(PersonaRestController.class);

    // servicios
    private final PersonaService personaService;


    @Autowired
    public PersonaRestController(PersonaService personaService) {
        this.personaService = personaService;
    }


    @GetMapping("/persona/rest/{idPersona}")
    public Persona getPersona(@PathVariable String idPersona){
        return personaService.findPersonaById(Long.valueOf(idPersona));
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoEncontradoRestException.class)
    public PersonaError handleNotFound(NoEncontradoRestException exception){
        PersonaError error = new PersonaError();
        error.setId(exception.getErrorNoEncontrado().getId());
        error.setEstado("error");
        error.setError(exception.getErrorNoEncontrado());
        return error;
    }
}

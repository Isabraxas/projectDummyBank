package com.viridian.dummybank.controller.persona;

import com.viridian.dummybank.model.persona.Persona;
import com.viridian.dummybank.service.persona.PersonaJooqService;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcelo on 16-03-18
 */
@RestController
public class PersonaJooqController {
    // logger
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(PersonaJooqController.class);

    private final PersonaJooqService personaJooqService;

    public PersonaJooqController(PersonaJooqService personaJooqService) {
        this.personaJooqService = personaJooqService;
    }

    @GetMapping("/jooq/persona/all")
    public List<Persona> getAllPersona(){
        log.info("Mostrando personas");
        return personaJooqService.getAllPersonas();
    }
}

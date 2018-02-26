package com.viridian.dummybank.controller.persona;

import com.viridian.dummybank.model.persona.Persona;
import com.viridian.dummybank.service.persona.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by marcelo on 22-02-18
 */
@Controller
public class PersonaController {

    // servicios
    private final PersonaService personaService;

    @Autowired
    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping("persona/all")
    public String getAllPersonas(Model model){
        model.addAttribute("personas", personaService.getAllPersonas());
        return "persona/persona-all";
    }

    @GetMapping("persona/show/{id}")
    public String getPersona(@PathVariable String id, Model model){
        model.addAttribute("persona", personaService.findPersonaById(Long.valueOf(id)));
        return "persona/persona-show";
    }

    @GetMapping("persona/new")
    public String addNewPersona(Model model){
        model.addAttribute("persona", new Persona());
        return "persona/persona-form";
    }

    @PostMapping("persona/save")
    public String saveOrUpdatePersona(Persona persona){
        personaService.saveOrUpdatePersona(persona);
        return "redirect:/persona/all";
    }

    @GetMapping("persona/update/{id}")
    public String updatePersona(@PathVariable String id, Model model){
        model.addAttribute("persona", personaService.findPersonaById(Long.valueOf(id)));
        return "persona-form";
    }
    @GetMapping("persona/delete/{id}")
    public String deletePersona(@PathVariable String id){
        personaService.deletePersona(Long.valueOf(id));
        return "redirect:/persona/all";
    }
}

package com.viridian.dummybank.controller;

import com.viridian.dummybank.model.Cliente;
import com.viridian.dummybank.model.persona.PersonaNatural;
import com.viridian.dummybank.service.ClienteService;
import com.viridian.dummybank.service.persona.PersonaJuridicaService;
import com.viridian.dummybank.service.persona.PersonaNaturalService;
import com.viridian.dummybank.utils.ClienteUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by marcelo on 20-02-18
 */
@Controller
public class ClienteController {

    // servicios
    private final ClienteService clienteService;
    private final PersonaJuridicaService personaJuridicaService;
    private final PersonaNaturalService personaNaturalService;

    @Autowired
    public ClienteController(ClienteService clienteService, PersonaJuridicaService personaJuridicaService, PersonaNaturalService personaNaturalService) {
        this.clienteService = clienteService;
        this.personaJuridicaService = personaJuridicaService;
        this.personaNaturalService = personaNaturalService;
    }

    @GetMapping("cliente/all")
    public String getAllCuentas(Model model){
        model.addAttribute("clientes",clienteService.findAllClientes());
        return "cliente-all";
    }

    @GetMapping("cliente/show/{id}")
    public String getCliente(@PathVariable String id, Model model){
        model.addAttribute("cliente",clienteService.findOneById(Long.valueOf(id)));
        return "cliente-show";
    }

    @GetMapping("cliente/show/{id}/{tipo}")
    public String getClienteTipo(@PathVariable String id, @PathVariable String tipo, Model model){
        // determinar el tipo de cliente que es
        if(tipo.equals(ClienteUtils.PERSONA_JURIDICA)){         // si es persona juridica
            // buscar a esa PersonaJuridica
            model.addAttribute("personaJ",personaJuridicaService.findOneById(Long.valueOf(id)));
            return "cliente-show-juridica";
        } else if(tipo.equals(ClienteUtils.PERSONA_NATURAL)){   // si es persona natural
            // buscar a esa PersonaNatural
            model.addAttribute("personaN", personaNaturalService.findOneById(Long.valueOf(id)));
            return "cliente-show-natural";
        }

        return "cliente-show";
    }

    @GetMapping("cliente/new")
    public String addNewClient(Model model){
        model.addAttribute("cliente", new Cliente());
        return "cliente-form";
    }

    @PostMapping("cliente/save")
    public String saveCliente(Cliente cliente){
        clienteService.saveOrUpdateCliente(cliente);
        return "redirect:/cliente/all";
    }

    @GetMapping("cliente/update/{id}")
    public String updateCliente(Model model,@PathVariable String id){
        model.addAttribute("cliente", clienteService.findOneById(Long.valueOf(id)));
        return "cliente-form";
    }

    @GetMapping("cliente/delete/{id}")
    public String deleteCliente(@PathVariable String id){
        clienteService.deleteCliente(Long.valueOf(id));
        return "redirect:/cliente/all";
    }
}

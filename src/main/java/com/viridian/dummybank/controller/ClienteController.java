package com.viridian.dummybank.controller;

import com.viridian.dummybank.model.Cliente;
import com.viridian.dummybank.model.ClienteAndPersonaJuridica;
import com.viridian.dummybank.model.ClienteAndPersonaNatural;
import com.viridian.dummybank.model.persona.Persona;
import com.viridian.dummybank.model.persona.PersonaJuridica;
import com.viridian.dummybank.model.persona.PersonaNatural;
import com.viridian.dummybank.service.ClienteService;
import com.viridian.dummybank.service.persona.PersonaJuridicaService;
import com.viridian.dummybank.service.persona.PersonaNaturalService;
import com.viridian.dummybank.service.persona.PersonaService;
import com.viridian.dummybank.utils.ClienteUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    private final PersonaService personaService;

    @Autowired
    public ClienteController(ClienteService clienteService,
                             PersonaJuridicaService personaJuridicaService,
                             PersonaNaturalService personaNaturalService,
                             PersonaService personaService) {
        this.clienteService = clienteService;
        this.personaJuridicaService = personaJuridicaService;
        this.personaNaturalService = personaNaturalService;

        this.personaService = personaService;
    }

    /**
     * Solo mostrara las cuentas de clientes
     */
    @GetMapping("cliente/all")
    public String getAllCuentas(Model model){
        model.addAttribute("clientes",clienteService.findAllClientes());
        return "cliente-all";
    }

    /**
     * Mostrara una cuenta en especifico, si es Persona Natural, o Juridica
     */
    @GetMapping("cliente/show/{id}")
    public String getCliente(@PathVariable String id, Model model){
        Cliente cliente = clienteService.findOneById(Long.valueOf(id));
        // determinar que clase de cliente es; natural o juridica
        if(cliente.getTipo().equals(ClienteUtils.PERSONA_NATURAL)){
            // buscar a esa PersonaNatural
            model.addAttribute("personaN", personaNaturalService.findOneById(Long.valueOf(id)));
            return "cliente-show-natural";
        }else if(cliente.getTipo().equals(ClienteUtils.PERSONA_JURIDICA)){
            // buscar a esa PersonaJuridica
            model.addAttribute("personaJ",personaJuridicaService.findOneById(Long.valueOf(id)));
            return "cliente-show-juridica";
        }
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

    @GetMapping("cliente/new/{tipo}")
    public String addNewClientEspecifico(@PathVariable String tipo,Model model){
        Cliente cliente = new Cliente();
        // determinar que clase de cliente es
        if(tipo.equals(ClienteUtils.PERSONA_NATURAL)){
            // nuevo cliente, con persona natural
            ClienteAndPersonaNatural clienteAndPersonaNatural  = new ClienteAndPersonaNatural();
            clienteAndPersonaNatural.setTipo(ClienteUtils.PERSONA_NATURAL);
            model.addAttribute("clienteAndPerson",clienteAndPersonaNatural);
            return "cliente-form-natural";
        }else if(tipo.equals(ClienteUtils.PERSONA_JURIDICA)){
            // nuevo cliente, con persona juridica
            ClienteAndPersonaJuridica clienteAndPersonaJuridica = new ClienteAndPersonaJuridica();
            clienteAndPersonaJuridica.setTipo(ClienteUtils.PERSONA_JURIDICA);
            model.addAttribute("clienteAndPerson", clienteAndPersonaJuridica);
            return "cliente-form-juridica";
        }
        return "cliente-form";
    }

    @PostMapping("cliente/save")
    public String saveCliente(Cliente cliente){
        clienteService.saveOrUpdateCliente(cliente);
        return "redirect:/cliente/all";
    }

    @PostMapping("cliente/savePerN")
    public String saveClientePerN(ClienteAndPersonaNatural clienteAndPersonaNatural){
        Cliente cliente = clienteAndPersonaNatural.getCliente();
        Persona persona = clienteAndPersonaNatural.getPersona();

        clienteService.saveOrUpdateCliente(cliente);
        personaService.saveOrUpdatePersona(persona);

        personaNaturalService.saveOrUpdatePersonaNatural(new PersonaNatural(cliente.getId(),persona));
        //clienteService.saveOrUpdateCliente(cliente);
        return "redirect:/cliente/all";
    }

    @PostMapping("cliente/savePerJ")
    public String saveClientePerJ(ClienteAndPersonaJuridica clienteAndPersonaJuridica){
        Cliente cliente = clienteAndPersonaJuridica.getCliente();
        Persona persona = clienteAndPersonaJuridica.getPersona();
        //PersonaJuridica personaJuridica = clienteAndPersonaJuridica.getPersonaJuridica();

        clienteService.saveOrUpdateCliente(cliente);
        personaService.saveOrUpdatePersona(persona);
        personaJuridicaService.saveOrUpdatePersonaJuridica(new PersonaJuridica(cliente.getId(),
                                                                                clienteAndPersonaJuridica.getNombre_razon(),
                                                                                clienteAndPersonaJuridica.getNit(),
                                                                                clienteAndPersonaJuridica.getRegistro_fundaempresa(),
                                                                                persona));
        //clienteService.saveOrUpdateCliente(cliente);
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

package com.viridian.dummybank.controller;

import com.viridian.dummybank.dao.CuentaRepository;
import com.viridian.dummybank.model.Cliente;
import com.viridian.dummybank.model.ClienteAndPersonaJuridica;
import com.viridian.dummybank.model.ClienteAndPersonaNatural;
import com.viridian.dummybank.model.Cuenta;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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

    // repositorios
    // todo convertir a servicio

    private  final CuentaRepository cuentaRepository;

    @Autowired
    public ClienteController(ClienteService clienteService,
                             PersonaJuridicaService personaJuridicaService,
                             PersonaNaturalService personaNaturalService,
                             PersonaService personaService,
                             CuentaRepository cuentaRepository) {

        this.clienteService = clienteService;
        this.personaJuridicaService = personaJuridicaService;
        this.personaNaturalService = personaNaturalService;

        this.personaService = personaService;
        this.cuentaRepository = cuentaRepository;
    }

    /**
     * Solo mostrara las cuentas de clientes
     */
    @GetMapping("cliente/all")
    public String getAllCuentas(Model model){
        model.addAttribute("clientes",clienteService.findAllClientes());
        return "cliente/cliente-all";
    }

    /**
     * Mostrara una cuenta en especifico, si es Persona Natural, o Juridica
     */
    @GetMapping("cliente/show/{id}")
    public String getCliente(@PathVariable String id, Model model){
        Cliente cliente = clienteService.findOneById(Long.valueOf(id));

        // buscar las cuentas asociadas al cliente y añadirlas
        List<Cuenta> cuentas = cuentaRepository.findAllByClienteId(Long.valueOf(id));
        model.addAttribute("cuentas", cuentas);


        // determinar que clase de cliente es; natural o juridica
        if(cliente.getTipo().equals(ClienteUtils.PERSONA_NATURAL)){
            // buscar a esa PersonaNatural y añadirla
            model.addAttribute("personaN", personaNaturalService.findOneById(Long.valueOf(id)));

            return "cliente/cliente-show-natural";
        }else if(cliente.getTipo().equals(ClienteUtils.PERSONA_JURIDICA)){
            // buscar a esa PersonaJuridica y añadirla
            model.addAttribute("personaJ",personaJuridicaService.findOneById(Long.valueOf(id)));

            return "cliente/cliente-show-juridica";
        }
        model.addAttribute("cliente",clienteService.findOneById(Long.valueOf(id)));
        return "cliente/cliente-show";
    }

    /**
     * Mostrara una cuenta en especifico, especificando el tipo de cuenta antes.
     */
    @GetMapping("cliente/show/{id}/{tipo}")
    public String getClienteTipo(@PathVariable String id, @PathVariable String tipo, Model model){
        // determinar el tipo de cliente que es
        if(tipo.equals(ClienteUtils.PERSONA_JURIDICA)){         // si es persona juridica
            // buscar a esa PersonaJuridica
            model.addAttribute("personaJ",personaJuridicaService.findOneById(Long.valueOf(id)));
            return "cliente/cliente-show-juridica";
        } else if(tipo.equals(ClienteUtils.PERSONA_NATURAL)){   // si es persona natural
            // buscar a esa PersonaNatural
            model.addAttribute("personaN", personaNaturalService.findOneById(Long.valueOf(id)));
            return "cliente/cliente-show-natural";
        }

        return "cliente/cliente-show";
    }

    /**
     * Crear nuevo cliente. pero solo nuevo cliente, sin su respectiva Persona
     */
    @GetMapping("cliente/new")
    public String addNewClient(Model model){
        model.addAttribute("cliente", new Cliente());
        return "cliente/cliente-form";
    }

    /**
     *  Crear nuevo cliente, especificando el tipo. Creara a su respectiva Persona Natural o Juridica
     */
    @GetMapping("cliente/new/{tipo}")
    public String addNewClientEspecifico(@PathVariable String tipo,Model model){
        Cliente cliente = new Cliente();
        // determinar que clase de cliente es
        if(tipo.equals(ClienteUtils.PERSONA_NATURAL)){
            // nuevo cliente, con persona natural
            ClienteAndPersonaNatural clienteAndPersonaNatural  = new ClienteAndPersonaNatural();
            clienteAndPersonaNatural.setTipo(ClienteUtils.PERSONA_NATURAL);
            model.addAttribute("clienteAndPerson",clienteAndPersonaNatural);
            return "cliente/cliente-form-natural";
        }else if(tipo.equals(ClienteUtils.PERSONA_JURIDICA)){
            // nuevo cliente, con persona juridica
            ClienteAndPersonaJuridica clienteAndPersonaJuridica = new ClienteAndPersonaJuridica();
            clienteAndPersonaJuridica.setTipo(ClienteUtils.PERSONA_JURIDICA);
            model.addAttribute("clienteAndPerson", clienteAndPersonaJuridica);
            return "cliente/cliente-form-juridica";
        }
        return "cliente/cliente-form";
    }

    /**
     * Guarda/Actualiza el cliente en la base de datos dependiendo si existe o no
     */
    @PostMapping("cliente/save")
    public String saveCliente(Cliente cliente){
        clienteService.saveOrUpdateCliente(cliente);
        return "redirect:/cliente/all";
    }

    /**
     * Guarda/Actualiza el cliente con su Persona Natural en la base de datos dependiendo si existe o no
     */
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

    /**
     * Guarda/Actualiza el cliente con su Persona Juridica en la base de datos dependiendo si existe o no
     */
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

    /**
     * Actualizar Cliente, sin especificar el tipo, se determinara primero que clase de cliente es
     */
    @GetMapping("cliente/update/{id}")
    public String updateCliente(Model model,@PathVariable String id){
        // buscar al cliente, y obtener su tipo
        Cliente cliente = clienteService.findOneById(Long.valueOf(id));
        String tipo = cliente.getTipo();
        // cargar el respectivo formulario de acuerdo al tipo
        if(tipo.equals(ClienteUtils.PERSONA_NATURAL)){
            // cliente es persona natural
            PersonaNatural persona = personaNaturalService.findOneById(Long.valueOf(id));
            ClienteAndPersonaNatural clienteAndPersonaNatural = new ClienteAndPersonaNatural(cliente, persona);

            model.addAttribute("clienteAndPerson", clienteAndPersonaNatural);
            return "cliente/cliente-form-natural";
        }else if(tipo.equals(ClienteUtils.PERSONA_JURIDICA)){
            // cliente es persona juridica
            PersonaJuridica persona = personaJuridicaService.findOneById(Long.valueOf(id));
            ClienteAndPersonaJuridica clienteAndPersonaJuridica = new ClienteAndPersonaJuridica(cliente,persona);

            model.addAttribute("clienteAndPerson", clienteAndPersonaJuridica);
            return "cliente/cliente-form-juridica";
        }
        // extremo caso (mal formato)
        model.addAttribute("cliente", clienteService.findOneById(Long.valueOf(id)));
        return "cliente/cliente-form";
    }

    /**
     * Actualizar Cliente, especificando el tipo anteriormente
     */
    @GetMapping("cliente/update/{id}/{tipo}")
    public String updateClienteEspecifico(Model model,@PathVariable String id, @PathVariable String tipo){
        // buscar al cliente que se actualizara
        Cliente cliente = clienteService.findOneById(Long.valueOf(id));
        // usar el tipo proveido para determinar el tipo de cliente
        if(tipo.equals(ClienteUtils.PERSONA_JURIDICA)){
            // cliente es persona juridica
            //Cliente cliente = clienteService.findOneById(Long.valueOf(id));
            PersonaJuridica persona = personaJuridicaService.findOneById(Long.valueOf(id));
            ClienteAndPersonaJuridica clienteAndPersonaJuridica = new ClienteAndPersonaJuridica(cliente,persona);

            model.addAttribute("clienteAndPerson", clienteAndPersonaJuridica);
            return "cliente/cliente-form-juridica";
        } else if(tipo.equals(ClienteUtils.PERSONA_NATURAL)){
            // cliente es persona natural
            //Cliente cliente = clienteService.findOneById(Long.valueOf(id));
            PersonaNatural persona = personaNaturalService.findOneById(Long.valueOf(id));
            ClienteAndPersonaNatural clienteAndPersonaNatural = new ClienteAndPersonaNatural(cliente, persona);

            model.addAttribute("clienteAndPerson", clienteAndPersonaNatural);
            return "cliente/cliente-form-natural";
        }else
        // caso extremo
        model.addAttribute("cliente", clienteService.findOneById(Long.valueOf(id)));
        return "cliente/cliente-form";
    }

    /**
     * Borra al cliente de la base de datos, junto a la Persona (Natural o Especifica)
     */
    @GetMapping("cliente/delete/{id}")
    public String deleteCliente(@PathVariable String id){
        String tipo = clienteService.findOneById(Long.valueOf(id)).getTipo();
        if(tipo.equals(ClienteUtils.PERSONA_NATURAL)){
            personaNaturalService.deletePersonaNatural(Long.valueOf(id));
        }else if(tipo.equals(ClienteUtils.PERSONA_JURIDICA)){
            personaJuridicaService.deletePersonaJuridica(Long.valueOf(id));
        }
        clienteService.deleteCliente(Long.valueOf(id));
        return "redirect:/cliente/all";
    }
}

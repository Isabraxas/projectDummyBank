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
import com.viridian.dummybank.service.CuentaService;
import com.viridian.dummybank.service.persona.PersonaJuridicaService;
import com.viridian.dummybank.service.persona.PersonaNaturalService;
import com.viridian.dummybank.service.persona.PersonaService;
import com.viridian.dummybank.utils.ClienteUtils;
import org.slf4j.Logger;
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

    // logger
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(ClienteController.class);

    // servicios
    private final ClienteService clienteService;
    private final PersonaJuridicaService personaJuridicaService;
    private final PersonaNaturalService personaNaturalService;
    private final PersonaService personaService;

    // repositorios
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
        log.info("Obteniendo todos los clientes");
        model.addAttribute("clientes",clienteService.findAllClientes());
        log.info("Clientes obtenidos");
        return "cliente/cliente-all";
    }

    /**
     * Mostrara una cuenta en especifico, si es Persona Natural, o Juridica
     */
    @GetMapping("cliente/show/{id}")
    public String getCliente(@PathVariable String id, Model model){
        log.info("Buscando al Cliente id: " + id);
        Cliente cliente = clienteService.findOneById(Long.valueOf(id));
        log.info("Accediendo a sus cuentas");
        // buscar las cuentas asociadas al cliente y añadirlas
        List<Cuenta> cuentas = cuentaRepository.findAllByClienteId(Long.valueOf(id));
        model.addAttribute("cuentas", cuentas);

        log.info("Cargando informacion del cliente (tipo)");
        // determinar que clase de cliente es; natural o juridica
        if(cliente.getTipo().equals(ClienteUtils.PERSONA_NATURAL)){
            log.info("Tipo: Persona Natural, cargando datos");
            // buscar a esa PersonaNatural y añadirla
            model.addAttribute("personaN", personaNaturalService.findOneById(Long.valueOf(id)));
            log.info("Informacion Cargada, deplegando vista.");
            return "cliente/cliente-show-natural";
        }else if(cliente.getTipo().equals(ClienteUtils.PERSONA_JURIDICA)){
            log.info("Tipo: Person Juridica, cargando datos");
            // buscar a esa PersonaJuridica y añadirla
            model.addAttribute("personaJ",personaJuridicaService.findOneById(Long.valueOf(id)));
            log.info("Informacion Cargada, deplegando vista");
            return "cliente/cliente-show-juridica";
        }
        model.addAttribute("cliente",clienteService.findOneById(Long.valueOf(id)));
        return "cliente/cliente-show";
    }

    /**
     * Mostrara una cuenta en especifico, especificando el tipo de cuenta antes. NO USAR
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
     * Crear nuevo cliente. pero solo nuevo cliente, sin su respectiva Persona - NO USAR
     */
    @GetMapping("cliente/new")
    public String addNewClient(Model model){
        log.info("Cargando formulario, para nuevo Cliente");
        model.addAttribute("cliente", new Cliente());
        return "cliente/cliente-form";
    }

    /**
     *  Crear nuevo cliente, especificando el tipo. Creara a su respectiva Persona Natural o Juridica
     */
    @GetMapping("cliente/new/{tipo}")
    public String addNewClientEspecifico(@PathVariable String tipo,Model model){
        log.info("Cargando Formulario, determinando tipo de Cliente");
        Cliente cliente = new Cliente();
        // determinar que clase de cliente es
        if(tipo.equals(ClienteUtils.PERSONA_NATURAL)){
            log.info("Tipo: Persona Natural, cargando formulario");
            // nuevo cliente, con persona natural
            ClienteAndPersonaNatural clienteAndPersonaNatural  = new ClienteAndPersonaNatural();
            clienteAndPersonaNatural.setTipo(ClienteUtils.PERSONA_NATURAL);
            model.addAttribute("clienteAndPerson",clienteAndPersonaNatural);
            return "cliente/cliente-form-natural";
        }else if(tipo.equals(ClienteUtils.PERSONA_JURIDICA)){
            log.info("Tipo: Person Juridica, cargando formulario");
            // nuevo cliente, con persona juridica
            ClienteAndPersonaJuridica clienteAndPersonaJuridica = new ClienteAndPersonaJuridica();
            clienteAndPersonaJuridica.setTipo(ClienteUtils.PERSONA_JURIDICA);
            model.addAttribute("clienteAndPerson", clienteAndPersonaJuridica);
            return "cliente/cliente-form-juridica";
        }
        return "cliente/cliente-form";
    }

    /**
     * Guarda/Actualiza el cliente en la base de datos dependiendo si existe o no - NO USAR
     */
    @PostMapping("cliente/save")
    public String saveCliente(Cliente cliente){
        log.info("Guardando Cliente");
        clienteService.saveOrUpdateCliente(cliente);
        return "redirect:/cliente/all";
    }

    /**
     * Guarda/Actualiza el cliente con su Persona Natural en la base de datos dependiendo si existe o no
     */
    @PostMapping("cliente/savePerN")
    public String saveClientePerN(ClienteAndPersonaNatural clienteAndPersonaNatural){
        log.info("Guardando / Actualizando al Cliente - Persona Natural");
        Cliente cliente = clienteAndPersonaNatural.getCliente();
        Persona persona = clienteAndPersonaNatural.getPersona();

        clienteService.saveOrUpdateCliente(cliente);
        personaService.saveOrUpdatePersona(persona);

        personaNaturalService.saveOrUpdatePersonaNatural(new PersonaNatural(cliente.getId(),persona));
        //clienteService.saveOrUpdateCliente(cliente);
        log.info("Guardado / Actualizado Completo");
        return "redirect:/cliente/all";
    }

    /**
     * Guarda/Actualiza el cliente con su Persona Juridica en la base de datos dependiendo si existe o no
     */
    @PostMapping("cliente/savePerJ")
    public String saveClientePerJ(ClienteAndPersonaJuridica clienteAndPersonaJuridica){
        log.info("Guardando / Actualizando al Cliente - Persona Juridica");
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
        log.info("Guardado / Actualizado Completo");
        return "redirect:/cliente/all";
    }

    /**
     * Actualizar Cliente, sin especificar el tipo, se determinara primero que clase de cliente es
     */
    @GetMapping("cliente/update/{id}")
    public String updateCliente(Model model,@PathVariable String id){
        log.info("Actualizando Cliente id: "+ id);
        log.info("Determinando tipo de cliente");
        // buscar al cliente, y obtener su tipo
        Cliente cliente = clienteService.findOneById(Long.valueOf(id));
        String tipo = cliente.getTipo();
        // cargar el respectivo formulario de acuerdo al tipo
        if(tipo.equals(ClienteUtils.PERSONA_NATURAL)){
            log.info("Tipo: Persona Natural");
            log.info("Cargando Datos");
            // cliente es persona natural
            PersonaNatural persona = personaNaturalService.findOneById(Long.valueOf(id));
            ClienteAndPersonaNatural clienteAndPersonaNatural = new ClienteAndPersonaNatural(cliente, persona);

            model.addAttribute("clienteAndPerson", clienteAndPersonaNatural);
            return "cliente/cliente-form-natural";
        }else if(tipo.equals(ClienteUtils.PERSONA_JURIDICA)){
            log.info("Tipo: Persona Juridica");
            log.info("Cargando Datos");
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
     * Actualizar Cliente, especificando el tipo anteriormente - NO RECOMENDADO
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
        log.info("Borrando Cliente id: " + id);
        String tipo = clienteService.findOneById(Long.valueOf(id)).getTipo(); // si no encuentra al cliente, dara error de no encontrada
        if(tipo.equals(ClienteUtils.PERSONA_NATURAL)){
            log.info("Tipo: Persona Natural");
            personaNaturalService.deletePersonaNatural(Long.valueOf(id));
        }else if(tipo.equals(ClienteUtils.PERSONA_JURIDICA)){
            log.info("Tipo: Persona Juridica");
            personaJuridicaService.deletePersonaJuridica(Long.valueOf(id));
        }
        clienteService.deleteCliente(Long.valueOf(id));
        log.info("Borrado Completo");
        return "redirect:/cliente/all";
    }
}

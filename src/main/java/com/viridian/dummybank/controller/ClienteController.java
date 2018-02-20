package com.viridian.dummybank.controller;

import com.viridian.dummybank.model.Cliente;
import com.viridian.dummybank.service.ClienteService;
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

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
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

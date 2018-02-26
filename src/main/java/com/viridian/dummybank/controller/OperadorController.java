package com.viridian.dummybank.controller;

import com.viridian.dummybank.model.Operador;
import com.viridian.dummybank.service.OperadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/operador")
public class OperadorController {
    @Autowired
    protected OperadorService operadorService;

    @GetMapping(value = "/getAll")
    public  String getAll(Model model){
        model.addAttribute("operadores", this.operadorService.getAll());
        return "operador/operador-all";
    }

    @GetMapping(value = "/getOperador/{id}")
    public String getOperador(Model model, @PathVariable Long id){
        model.addAttribute("operador",this.operadorService.getOperadorById(id));
        return "operador/operador-show";
    }

    @GetMapping("/new")
    public String newOperador(Model model){
        model.addAttribute("operador", new Operador());
        model.addAttribute("accion", "actualizar");
        return "operador/operador-form";
    }
    @PostMapping("/save")
    public String saveOperador(Operador operador){
        operadorService.save(operador);
        return "redirect:/operador/getAll";
    }
    @GetMapping("/update/{id}")
    public String updateOperador(@PathVariable Long id, Model model){
        Operador operador = operadorService.getOperadorById(id);
        model.addAttribute("operador", operador);
        model.addAttribute("accion", "actualizar");
        return "operador/operador-form";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        this.operadorService.delete(id);
        return "redirect:/operador/getAll";
    }
    
    /*
    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public List<Operador> getAll(){
        return this.operadorService.getAll();
    }

    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    public void saveOrUpdate(@RequestBody Operador operador){
        this.operadorService.save(operador);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public List<Operador> delete(@PathVariable Long id){
        this.operadorService.delete(id);
        return this.operadorService.getAll();
    }

    @RequestMapping(value = "/getOperador/{id}", method = RequestMethod.GET)
    public Operador getOperador(@PathVariable Long id){
        return this.operadorService.getOperadorById(id);
    }*/

}

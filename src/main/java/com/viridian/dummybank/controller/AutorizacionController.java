package com.viridian.dummybank.controller;

import com.viridian.dummybank.model.Autorizacion;
import com.viridian.dummybank.service.AutorizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/autorizacion")
public class AutorizacionController {

    @Autowired
    protected AutorizacionService autorizacionService;

    @GetMapping(value = "/getAll")
    public  String getAll(Model model){
        model.addAttribute("autorizaciones", this.autorizacionService.getAll());
        return "autorizacion/autorizacion-all";
    }

    @GetMapping(value = "/getAutorizacion/{id}")
    public String getAutorizacion(Model model, @PathVariable Long id){
        model.addAttribute("autorizacion",this.autorizacionService.getAutorizacionById(id));
        return "autorizacion/autorizacion-show";
    }

    @GetMapping("/new")
    public String newAutorizacion(Model model){
        model.addAttribute("autorizacion", new Autorizacion());
        return "autorizacion/autorizacion-form";
    }
    @PostMapping("/save")
    public String saveAutorizacion(Autorizacion autorizacion){
        autorizacionService.save(autorizacion);
        return "redirect:/autorizacion/getAll";
    }
    @GetMapping("/update/{id}")
    public String updateAutorizacion(@PathVariable Long id, Model model){
        Autorizacion autorizacion = autorizacionService.getAutorizacionById(id);
        model.addAttribute("autorizacion", autorizacion);
        return "autorizacion/autorizacion-form";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        this.autorizacionService.delete(id);
        return "redirect:/autorizacion/getAll";
    }
    
    /*
    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public List<Autorizacion> getAll(){
        return this.autorizacionService.getAll();
    }

    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    public void saveOrUpdate(@RequestBody Autorizacion autorizacion){
        this.autorizacionService.save(autorizacion);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public List<Autorizacion> delete(@PathVariable Long id){
        this.autorizacionService.delete(id);
        return this.autorizacionService.getAll();
    }

    @RequestMapping(value = "/getAutorizacion/{id}", method = RequestMethod.GET)
    public Autorizacion getAutorizacion(@PathVariable Long id){
        return this.autorizacionService.getAutorizacionById(id);
    }
    */
}

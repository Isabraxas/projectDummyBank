package com.viridian.dummybank.controller;

import com.viridian.dummybank.model.Estatus;
import com.viridian.dummybank.service.EstatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping(value = "/estatus")
public class EstatusController {
    @Autowired
    protected EstatusService estatusService;

    @GetMapping(value = "/getAll")
    public  String getAll(Model model){
        model.addAttribute("estatuss", this.estatusService.getAll());
        return "estatus/estatus-all";
    }

    @GetMapping(value = "/getEstatus/{id}")
    public String getEstatus(Model model, @PathVariable Long id){
        model.addAttribute("estatus",this.estatusService.getEstatusById(id));
        return "estatus/estatus-show";
    }

    @GetMapping("/new")
    public String newEstatus(Model model){
        model.addAttribute("estatus", new Estatus());
        model.addAttribute("accion", "guardar");
        return "estatus/estatus-form";
    }
    @PostMapping("/save")
    public String saveEstatus(Estatus estatus){
        estatusService.save(estatus);
        return "redirect:/estatus/getAll";
    }
    @GetMapping("/update/{id}")
    public String updateEstatus(@PathVariable Long id, Model model){
        Estatus estatus = estatusService.getEstatusById(id);
        model.addAttribute("estatus", estatus);
        model.addAttribute("accion", "actualizar");
        return "estatus/estatus-form";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        this.estatusService.delete(id);
        return "redirect:/estatus/getAll";
    }
    
    /*
    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public List<Estatus> getAll(){
        return this.estatusService.getAll();
    }

    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    public void saveOrUpdate(@RequestBody Estatus estatus){
        this.estatusService.save(estatus);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public List<Estatus> delete(@PathVariable Long id){
        this.estatusService.delete(id);
        return this.estatusService.getAll();
    }

    @RequestMapping(value = "/getEstatus/{id}", method = RequestMethod.GET)
    public Estatus getEstatus(@PathVariable Long id){
        return this.estatusService.getEstatusById(id);
    }
    */
}

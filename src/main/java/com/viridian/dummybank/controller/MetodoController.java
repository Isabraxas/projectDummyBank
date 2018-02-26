package com.viridian.dummybank.controller;

import com.viridian.dummybank.model.Metodo;
import com.viridian.dummybank.service.MetodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/metodo")
public class MetodoController {
    @Autowired
    protected MetodoService metodoService;

    @GetMapping(value = "/getAll")
    public  String getAll(Model model){
        model.addAttribute("metodos", this.metodoService.getAll());
        return "metodo/metodo-all";
    }

    @GetMapping(value = "/getMetodo/{id}")
    public String getMetodo(Model model, @PathVariable Long id){
        model.addAttribute("metodo",this.metodoService.getMetodoById(id));
        return "metodo/metodo-show";
    }

    @GetMapping("/new")
    public String newMetodo(Model model){
        model.addAttribute("metodo", new Metodo());
        model.addAttribute("accion", "guardar");
        return "metodo/metodo-form";
    }
    @PostMapping("/save")
    public String saveMetodo(Metodo metodo){
        metodoService.save(metodo);
        return "redirect:/metodo/getAll";
    }
    @GetMapping("/update/{id}")
    public String updateMetodo(@PathVariable Long id, Model model){
        Metodo metodo = metodoService.getMetodoById(id);
        model.addAttribute("metodo", metodo);
        model.addAttribute("accion", "actualizar");
        return "metodo/metodo-form";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        this.metodoService.delete(id);
        return "redirect:/metodo/getAll";
    }
    
    /*
    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public List<Metodo> getAll(){
        return this.metodoService.getAll();
    }

    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    public void saveOrUpdate(@RequestBody Metodo metodo){
        this.metodoService.save(metodo);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public List<Metodo> delete(@PathVariable Long id){
        this.metodoService.delete(id);
        return this.metodoService.getAll();
    }

    @RequestMapping(value = "/getMetodo/{id}", method = RequestMethod.GET)
    public Metodo getMetodo(@PathVariable Long id){
        return this.metodoService.getMetodoById(id);
    }
    */
}

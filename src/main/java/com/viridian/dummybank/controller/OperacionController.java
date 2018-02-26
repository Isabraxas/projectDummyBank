package com.viridian.dummybank.controller;

import com.viridian.dummybank.model.Operacion;
import com.viridian.dummybank.service.OperacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/operacion")
public class OperacionController {
    
    @Autowired
    protected OperacionService operacionService;

    @GetMapping(value = "/getAll")
    public  String getAll(Model model){
        model.addAttribute("operaciones", this.operacionService.getAll());
        return "operacion/operacion-all";
    }

    @GetMapping(value = "/getOperacion/{id}")
    public String getOperacion(Model model, @PathVariable Long id){
        model.addAttribute("operacion",this.operacionService.getOperacionById(id));
        return "operacion/operacion-show";
    }

    @GetMapping("/new")
    public String newOperacion(Model model){
        model.addAttribute("operacion", new Operacion());
        model.addAttribute("accion", "guardar");
        return "operacion/operacion-form";
    }
    @PostMapping("/save")
    public String saveOperacion(Operacion operacion){
        operacionService.save(operacion);
        return "redirect:/operacion/getAll";
    }
    @GetMapping("/update/{id}")
    public String updateOperacion(@PathVariable Long id, Model model){
        Operacion operacion = operacionService.getOperacionById(id);
        model.addAttribute("operacion", operacion);
        model.addAttribute("accion", "actualizar");
        return "operacion/operacion-form";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        this.operacionService.delete(id);
        return "redirect:/operacion/getAll";
    }
   
    /*
    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public List<Operacion> getAll(){
        return this.operacionService.getAll();
    }

    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    public void saveOrUpdate(@RequestBody Operacion operacion){
        this.operacionService.save(operacion);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public List<Operacion> delete(@PathVariable Long id){
        this.operacionService.delete(id);
        return this.operacionService.getAll();
    }

    @RequestMapping(value = "/getOperacion/{id}", method = RequestMethod.GET)
    public Operacion getOperacion(@PathVariable Long id){
        return this.operacionService.getOperacionById(id);
    }
    */
}

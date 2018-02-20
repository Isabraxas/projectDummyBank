package com.viridian.dummybank.controller;

import com.viridian.dummybank.model.Metodo;
import com.viridian.dummybank.service.MetodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/metodo")
public class MetodoController {
    @Autowired
    protected MetodoService metodoService;

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
    
}

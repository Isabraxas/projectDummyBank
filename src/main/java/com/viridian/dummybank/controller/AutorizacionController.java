package com.viridian.dummybank.controller;

import com.viridian.dummybank.model.Autorizacion;
import com.viridian.dummybank.service.AutorizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/autorizacion")
public class AutorizacionController {

    @Autowired
    protected AutorizacionService autorizacionService;

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

}

package com.viridian.dummybank.controller;

import com.viridian.dummybank.model.Operador;
import com.viridian.dummybank.service.OperadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/operador")
public class OperadorController {
    @Autowired
    protected OperadorService operadorService;

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
    }

}

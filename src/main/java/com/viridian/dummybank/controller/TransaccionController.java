package com.viridian.dummybank.controller;

import com.viridian.dummybank.model.Transaccion;
import com.viridian.dummybank.service.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/transaccion")
public class TransaccionController {
    @Autowired
    protected TransaccionService transaccionService;

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public List<Transaccion> getAll(){
        return this.transaccionService.getAll();
    }

    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    public void saveOrUpdate(@RequestBody Transaccion transaccion){
        this.transaccionService.save(transaccion);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public List<Transaccion> delete(@PathVariable Long id){
        this.transaccionService.delete(id);
        return this.transaccionService.getAll();
    }

    @RequestMapping(value = "/getTransaccion/{id}", method = RequestMethod.GET)
    public Transaccion getTransaccion(@PathVariable Long id){
        return this.transaccionService.getTransaccionById(id);
    }

}

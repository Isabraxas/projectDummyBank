package com.viridian.dummybank.controller;

import com.viridian.dummybank.model.Transaccion;
import com.viridian.dummybank.service.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/transaccion")
public class TransaccionController {
    @Autowired
    protected TransaccionService transaccionService;
    /*
    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public List<Transaccion> getAll(){
        return this.transaccionService.getAll();
    }
    */

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public  String getAll(Model model){
        model.addAttribute("transacciones", this.transaccionService.getAll());
        return "transaccion-all";
    }
    
    /*
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    public void saveOrUpdate(@RequestBody Transaccion transaccion){
        this.transaccionService.save(transaccion);
    }
    */

    @RequestMapping(value = "/update/{id}",method = RequestMethod.GET)
    public String update(@PathVariable Long id, Model model){
        model.addAttribute("transaccion", transaccionService.getTransaccionById(id));
        return "transaccion-form";
    }

    @PostMapping("/save")
    public String saveTransaccion(Transaccion transaccion){
        transaccionService.save(transaccion);
        return "redirect:/transaccion/getAll";
    }


    
    /*
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public List<Transaccion> delete(@PathVariable Long id){
        this.transaccionService.delete(id);
        return this.transaccionService.getAll();
    }*/

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Long id){
        this.transaccionService.delete(id);
        return "redirect:/transaccion/getAll";
    }
    /*
    @RequestMapping(value = "/getTransaccion/{id}", method = RequestMethod.GET)
    public Transaccion getTransaccion(@PathVariable Long id){
        return this.transaccionService.getTransaccionById(id);
    }
    */

    @RequestMapping(value = "/getTransaccion/{id}", method = RequestMethod.GET)
    public String getTransaccion(Model model, @PathVariable Long id){        
         model.addAttribute("transaccion",this.transaccionService.getTransaccionById(id));
         return "transaccion-show";
    }

    @RequestMapping(value = "/getTransaccionBetween/{fechaA}/{fechaB}", method = RequestMethod.GET)
    public List<Transaccion> getTransaccionBetween(@PathVariable String fechaA, @PathVariable String fechaB){
        //String fechaA ="11-10-2007";
        //String fechaB ="11-10-2012";
        return this.transaccionService.getTransaccionGreaterTo(fechaA,fechaB);
    }

    @RequestMapping(value = "/getTransaccionByCuenta/{numeroCuenta}", method = RequestMethod.GET)
    public List<Transaccion> getTransaccionByCuenta(@PathVariable Long numeroCuenta){

        return this.transaccionService.getTransaccionByCuenta(numeroCuenta);
    }

    @RequestMapping(value = "/getTransaccionByCuentaAndPeriod/{numeroCuenta}/{fechaA}/{fechaB}", method = RequestMethod.GET)
    public List<Transaccion> getTransaccionByCuentaAndPeriod(@PathVariable Long numeroCuenta,@PathVariable String fechaA, @PathVariable String fechaB){

        return this.transaccionService.getTransaccionByCuentaAndPeriod(numeroCuenta,fechaA,fechaB);
    }

    @RequestMapping(value = "/getTransaccionByCuentaAndMoneda/{numeroCuenta}/{moneda}", method = RequestMethod.GET)
    public List<Transaccion> getTransaccionByCuentaAndMoneda(@PathVariable Long numeroCuenta,@PathVariable String moneda ){

        return this.transaccionService.getTransaccionByCuentaAndMoneda(numeroCuenta, moneda);
    }
}
package com.viridian.dummybank.controller;

import com.viridian.dummybank.dao.CuentaRepository;
import com.viridian.dummybank.model.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/cuenta")
public class CuentaController {

    @Autowired
    protected CuentaRepository cuentaRepository;

    @GetMapping(value = "/getAll")
    public  String getAll(Model model){
        model.addAttribute("cuentas", this.cuentaRepository.findAll());
        return "cuenta/cuenta-all";
    }

    @GetMapping(value = "/getCuenta/{id}")
    public String getCuenta(Model model, @PathVariable Long id){
        model.addAttribute("cuenta",this.cuentaRepository.findOne(id));
        return "cuenta/cuenta-show";
    }

    @GetMapping("/new")
    public String newCuenta(Model model){
        model.addAttribute("cuenta", new Cuenta());
        model.addAttribute("accion", "guardar");
        return "cuenta/cuenta-form";
    }
    @PostMapping("/save")
    public String saveCuenta(Cuenta cuenta){
        this.cuentaRepository.save(cuenta);
        return "redirect:/cuenta/getAll";
    }
    @GetMapping("/update/{id}")
    public String updateCuenta(@PathVariable Long id, Model model){
        Cuenta cuenta = this.cuentaRepository.findOne(id);
        model.addAttribute("accion", "actualizar");
        model.addAttribute("cuenta", cuenta);
        return "cuenta/cuenta-form";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        this.cuentaRepository.findOne(id);
        return "redirect:/cuenta/getAll";
    }


    public @ResponseBody List<Cuenta> getAllREST(){
        return this.cuentaRepository.findAll();
    }
}

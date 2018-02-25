package com.viridian.dummybank.controller;

import com.viridian.dummybank.dao.CuentaRepository;
import com.viridian.dummybank.model.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CuentaController {

    @Autowired
    protected CuentaRepository cuentaRepository;

    @GetMapping(value = "/getAll")
    public  String getAll(Model model){
        model.addAttribute("cuentas", this.cuentaRepository.findAll());

        return "cuenta/cuenta-form";
    }


    public @ResponseBody List<Cuenta> getAllREST(){
        return this.cuentaRepository.findAll();
    }
}

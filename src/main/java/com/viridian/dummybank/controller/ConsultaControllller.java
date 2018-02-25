package com.viridian.dummybank.controller;

import com.viridian.dummybank.dao.CuentaRepository;
import com.viridian.dummybank.dao.TransaccionRepository;
import com.viridian.dummybank.model.Cuenta;
import com.viridian.dummybank.util.Movimiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/consulta")
public class ConsultaControllller {

    @Autowired
    protected CuentaController cuentaController;

    @Autowired
    protected CuentaRepository cuentaRepository;
    @Autowired
    protected TransaccionController transaccionController;

    @Autowired
    protected TransaccionRepository transaccionRepository;

    @RequestMapping(value = "/getCuentas")
    public  String getCuentas(Model model){
        model.addAttribute("cuentas", this.cuentaController.getAllREST());
        model.addAttribute("cuenta", new Cuenta());
        return "consulta/consulta-form";
    }

    @RequestMapping(value = "/movimientos", method = RequestMethod.POST)
    public String getMovimientos(Cuenta cuenta, Model model){
        Long numeroCuenta = cuenta.getNumeroCuenta();
        model.addAttribute("numeroCuenta", numeroCuenta);
        model.addAttribute("movimiento", new Movimiento());
        return "consulta/consulta-form2";
    }

    @RequestMapping(value = "/listaMovimientos", method = RequestMethod.POST)
    public String getListaMovimientos(Model model, Movimiento movimiento){
        model.addAttribute("transacciones", this.transaccionRepository.finByNumeroCuentaAndCurrentMonth(movimiento.getNumeroCuenta()));
        //model.addAttribute("transacciones", this.transaccionRepository.finByNumeroCuentaAndLastMonth(movimiento.getNumeroCuenta()));
        //model.addAttribute("transacciones", this.transaccionRepository.finByNumeroCuentaAndLastMonths(movimiento.getNumeroCuenta(),3));
        //model.addAttribute("transacciones", this.transaccionRepository.finTopNumberByNumeroCuenta(movimiento.getNumeroCuenta(),5));
        //model.addAttribute("transacciones",  this.transaccionController.getTransaccionByCuentaAndPeriod(movimiento.getNumeroCuenta(),movimiento.getFechaInicioDesde().toString(),movimiento.getFechaInicioHasta().toString()));
        return "consulta/consulta-form3";
    }
}

package com.viridian.dummybank.controller;

import com.viridian.dummybank.dao.CuentaRepository;
import com.viridian.dummybank.dao.TransaccionRepository;
import com.viridian.dummybank.model.Cuenta;
import com.viridian.dummybank.model.Transaccion;
import com.viridian.dummybank.util.Movimiento;
import com.viridian.dummybank.util.MovimientoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

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
    public String get(Model model){

        model.addAttribute("cuentas", this.cuentaController.getAllREST());
        model.addAttribute("cuenta", new Cuenta());
        model.addAttribute("movimientoForm", new MovimientoForm());

        List<Transaccion> transaccionList = new ArrayList<Transaccion>();
        model.addAttribute("transacciones", transaccionList);

        return "consulta/consulta-form";
    }
    @RequestMapping(value = "/lista", method = RequestMethod.POST)
    public String getLista(Model model, MovimientoForm movimiento){

        if(movimiento.getOpcion() == 1) {
            model.addAttribute("transacciones", this.transaccionRepository.finByNumeroCuentaAndCurrentMonth(movimiento.getNumeroCuenta()));
        }else if(movimiento.getOpcion() == 2) {
            model.addAttribute("transacciones", this.transaccionRepository.finByNumeroCuentaAndLastMonth(movimiento.getNumeroCuenta()));
        }else if (movimiento.getOpcion() > 2){
            model.addAttribute("transacciones", this.transaccionRepository.finByNumeroCuentaAndLastMonths(movimiento.getNumeroCuenta(),movimiento.getOpcion()));
        }else{
            model.addAttribute("transacciones",  this.transaccionController.getTransaccionByCuentaAndPeriod(movimiento.getNumeroCuenta(),movimiento.getFechaInicioDesde().toString(),movimiento.getFechaInicioHasta().toString()));
        }
        if (movimiento.getLimite() != 0) {
            model.addAttribute("transacciones", this.transaccionRepository.finTopNumberByNumeroCuenta(movimiento.getNumeroCuenta(),movimiento.getLimite()));
        }

        model.addAttribute("cuentas", this.cuentaController.getAllREST());

        return "consulta/consulta-form";
    }
}

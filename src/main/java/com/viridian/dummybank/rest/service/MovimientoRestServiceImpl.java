package com.viridian.dummybank.rest.service;

import com.viridian.dummybank.model.Transaccion;
import com.viridian.dummybank.service.TransaccionService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoRestServiceImpl implements MovimientoRestService{
    //Logger
    private final Logger log= org.slf4j.LoggerFactory.getLogger(MovimientoRestServiceImpl.class);

    //Service
    private final TransaccionService transaccionService;

    @Autowired
    public MovimientoRestServiceImpl(TransaccionService transaccionService) {
        this.transaccionService = transaccionService;
    }


    @Override
    public List<Transaccion> getMovimientoByCuenta(Long numeroCuenta) {
        List<Transaccion> transaccionList = this.transaccionService.getTransaccionByCuenta(numeroCuenta);
        return transaccionList;
    }
}

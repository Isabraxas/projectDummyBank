package com.viridian.dummybank.rest.service;

import com.viridian.dummybank.dao.TransaccionRepository;
import com.viridian.dummybank.model.Cliente;
import com.viridian.dummybank.model.Cuenta;
import com.viridian.dummybank.model.Transaccion;
import com.viridian.dummybank.rest.model.MovimientoCliente;
import com.viridian.dummybank.rest.request.MovimientoRequest;
import com.viridian.dummybank.service.ClienteService;
import com.viridian.dummybank.service.CuentaService;
import com.viridian.dummybank.service.TransaccionService;
import com.viridian.dummybank.util.Movimiento;
import com.viridian.dummybank.util.Util;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class MovimientoRestServiceImpl implements MovimientoRestService{
    //Logger
    private final Logger log= org.slf4j.LoggerFactory.getLogger(MovimientoRestServiceImpl.class);

    //Service
    private final TransaccionService transaccionService;
    private final ClienteService clienteService;
    private final CuentaService cuentaService;

    //Repository
    private final TransaccionRepository transaccionRepository;

    @Autowired
    public MovimientoRestServiceImpl(TransaccionService transaccionService, ClienteService clienteService, CuentaService cuentaService, TransaccionRepository transaccionRepository) {
        this.transaccionService = transaccionService;
        this.clienteService = clienteService;
        this.cuentaService = cuentaService;
        this.transaccionRepository = transaccionRepository;
    }



    @Override
    public List<MovimientoCliente> getMovimientoByCuenta(Long numeroCuenta) {
        List<Transaccion> transaccionList = this.transaccionService.getTransaccionByCuenta(numeroCuenta);
        List<MovimientoCliente> movimientoClienteList = new ArrayList<MovimientoCliente>();


        //Iterator<Transaccion> it = transaccionList.iterator();

        for (Transaccion transaccion : transaccionList) {

            MovimientoCliente movimientoCliente = new MovimientoCliente();
            movimientoCliente.setIdTransaccion(transaccion.getIdTransaccion());
            movimientoCliente.setNumeroCuenta(transaccion.getNumeroCuenta());
            if(transaccion.getCliente() != null ) {
                movimientoCliente.setCliente_id(transaccion.getCliente().getId());
            }
            movimientoCliente.setFechaInicio(Util.convertStringToTimestamp(transaccion.getFechaInicio()));
            movimientoCliente.setNumeroOrden(transaccion.getNumeroOrden());
            movimientoCliente.setOperacion(transaccion.getOperacion());
            movimientoCliente.setMonto(transaccion.getMonto());
            movimientoCliente.setMoneda(transaccion.getMoneda());
            movimientoCliente.setSaldo(transaccion.getSaldo());
            movimientoCliente.setBeneficiario(transaccion.getBeneficiario());

            movimientoClienteList.add(movimientoCliente);
        }

        return movimientoClienteList;
    }

    @Override
    public List<MovimientoCliente> getMovimientoByRangoFecha(Long numeroCuenta, String fechaDesde, String fechaHasta) {
        List<Transaccion> transaccionList = this.transaccionService.getTransaccionByCuentaAndPeriod(numeroCuenta,fechaDesde,fechaHasta);
        List<MovimientoCliente> movimientoClienteList = new ArrayList<MovimientoCliente>();

        for (Transaccion transaccion : transaccionList) {

            MovimientoCliente movimientoCliente = new MovimientoCliente();
            movimientoCliente.setIdTransaccion(transaccion.getIdTransaccion());
            movimientoCliente.setNumeroCuenta(transaccion.getNumeroCuenta());
            if(transaccion.getCliente() != null ) {
                movimientoCliente.setCliente_id(transaccion.getCliente().getId());
            }
            movimientoCliente.setFechaInicio(Util.convertStringToTimestamp(transaccion.getFechaInicio()));
            movimientoCliente.setNumeroOrden(transaccion.getNumeroOrden());
            movimientoCliente.setOperacion(transaccion.getOperacion());
            movimientoCliente.setMonto(transaccion.getMonto());
            movimientoCliente.setMoneda(transaccion.getMoneda());
            movimientoCliente.setSaldo(transaccion.getSaldo());
            movimientoCliente.setBeneficiario(transaccion.getBeneficiario());

            movimientoClienteList.add(movimientoCliente);
        }

        return movimientoClienteList;
    }

    @Override
    public List<MovimientoCliente> getMovimientoByCuentaAndUltimos(Long numeroCuenta, int numeroMovimientos) {
        List<Transaccion> transaccionList = this.transaccionRepository.finTopNumberByNumeroCuenta(numeroCuenta, numeroMovimientos);
        List<MovimientoCliente> movimientoClienteList = this.convertTransaccionListToMovimientoClienteList(transaccionList);

        return movimientoClienteList;
    }

    @Override
    public List<MovimientoCliente> getMovimientos(MovimientoRequest movimientoRequest) {

        log.info("Buncando al cliente");
        Cliente cliente = clienteService.findOneById(movimientoRequest.getIdCliente());
        log.info("Cliente encontrado");
        log.info("Buscando cuenta");
        Cuenta cuenta= cuentaService.getCuentaByNumber(movimientoRequest.getNumeroCuenta());
        log.info("Cuenta encontrada");

        List<Transaccion> transaccionList =new ArrayList<Transaccion>();
        if (movimientoRequest.getNumeroMovimientos() > 0) {
            transaccionList = this.transaccionRepository.finTopNumberByNumeroCuenta(movimientoRequest.getNumeroCuenta(), movimientoRequest.getNumeroMovimientos());
        }else if (!movimientoRequest.getFechaDesde().isEmpty()  && !movimientoRequest.getFechaHasta().isEmpty() ){
            transaccionList = this.transaccionService.getTransaccionByCuentaAndPeriod(movimientoRequest.getNumeroCuenta(),movimientoRequest.getFechaDesde(),movimientoRequest.getFechaHasta());
        }

        List<MovimientoCliente> movimientoClienteList = this.convertTransaccionListToMovimientoClienteList(transaccionList);

        return movimientoClienteList;
    }


    private List<MovimientoCliente> convertTransaccionListToMovimientoClienteList(List<Transaccion> transaccionList){

        List<MovimientoCliente> movimientoClienteList = new ArrayList<MovimientoCliente>();

        for (Transaccion transaccion : transaccionList) {

            MovimientoCliente movimientoCliente = new MovimientoCliente();
            movimientoCliente.setIdTransaccion(transaccion.getIdTransaccion());
            movimientoCliente.setNumeroCuenta(transaccion.getNumeroCuenta());
            if(transaccion.getCliente() != null ) {
                movimientoCliente.setCliente_id(transaccion.getCliente().getId());
            }
            movimientoCliente.setFechaInicio(Util.convertStringToTimestamp(transaccion.getFechaInicio()));
            movimientoCliente.setNumeroOrden(transaccion.getNumeroOrden());
            movimientoCliente.setOperacion(transaccion.getOperacion());
            movimientoCliente.setMonto(transaccion.getMonto());
            movimientoCliente.setMoneda(transaccion.getMoneda());
            movimientoCliente.setSaldo(transaccion.getSaldo());
            movimientoCliente.setBeneficiario(transaccion.getBeneficiario());

            movimientoClienteList.add(movimientoCliente);
        }
        return movimientoClienteList;
    }

}

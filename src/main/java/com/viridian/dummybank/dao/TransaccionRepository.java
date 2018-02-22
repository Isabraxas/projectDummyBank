package com.viridian.dummybank.dao;

import com.viridian.dummybank.model.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

public interface TransaccionRepository extends JpaRepository<Transaccion, Long>{
    List<Transaccion> findByFechaInicioGreaterThanEqual(Timestamp fechaInicio);
    List<Transaccion> findByFechaInicioBetween(Timestamp fechaInicioA ,Timestamp fechaInicioB);
    List<Transaccion> findByNumeroCuentaEquals(Long numeroCuenta);
    List<Transaccion> findByNumeroCuentaEqualsAndMonedaEquals(Long numeroCuenta, String moneda);
    List<Transaccion> findByNumeroCuentaEqualsAndFechaInicioBetween(Long numeroCuenta,Timestamp fechaInicioA ,Timestamp fechaInicioB);
}

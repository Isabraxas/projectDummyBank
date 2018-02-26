package com.viridian.dummybank.dao;

import com.viridian.dummybank.model.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;

public interface TransaccionRepository extends JpaRepository<Transaccion, Long>{
    List<Transaccion> findByFechaInicioGreaterThanEqual(Timestamp fechaInicio);
    List<Transaccion> findByFechaInicioBetween(Timestamp fechaInicioA ,Timestamp fechaInicioB);
    List<Transaccion> findByNumeroCuentaEquals(Long numeroCuenta);
    List<Transaccion> findByNumeroCuentaEqualsAndMonedaEquals(Long numeroCuenta, String moneda);
    List<Transaccion> findByNumeroCuentaEqualsAndFechaInicioBetween(Long numeroCuenta,Timestamp fechaInicioA ,Timestamp fechaInicioB);

    @Query(value = "SELECT * FROM transaccion WHERE numero_cuenta = ?1 ORDER BY fecha_inicio DESC limit ?2", nativeQuery = true)
    List<Transaccion> finTopNumberByNumeroCuenta(Long numeroCuenta, int top);


    @Query(value = "SELECT * FROM transaccion\n" +
            "    WHERE numero_cuenta = ?1\n" +
            "    AND fecha_inicio BETWEEN DATE_SUB(NOW(), INTERVAL ?2 MONTH) AND NOW()\n" +
            "    ORDER BY fecha_inicio DESC", nativeQuery = true)
    List<Transaccion> finByNumeroCuentaAndLastMonths(Long numeroCuenta, int months);

    @Query(value = "SELECT * FROM transaccion\n" +
            "    WHERE numero_cuenta = ?1\n" +
            "AND MONTH(fecha_inicio) = MONTH(DATE_ADD(CURDATE(),INTERVAL -1 MONTH)) \n" +
            "AND YEAR(fecha_inicio)= YEAR(curdate())\n" +
            "ORDER BY fecha_inicio DESC", nativeQuery = true)
    List<Transaccion> finByNumeroCuentaAndLastMonth(Long numeroCuenta);

    @Query(value = "SELECT * FROM transaccion\n" +
            "    WHERE numero_cuenta = ?1\n" +
            "AND MONTH(fecha_inicio) = MONTH(CURDATE()) \n" +
            "AND YEAR(fecha_inicio)= YEAR(curdate())\n" +
            "ORDER BY fecha_inicio DESC", nativeQuery = true)
    List<Transaccion> finByNumeroCuentaAndCurrentMonth(Long numeroCuenta);
}

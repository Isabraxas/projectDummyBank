package com.viridian.dummybank.dao;

import com.viridian.dummybank.model.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

public interface TransaccionRepository extends JpaRepository<Transaccion, Long>{
    List<Transaccion> findByFechaInicioGreaterThanEqual(Timestamp fechaInicio);
    List<Transaccion> findByFechaInicioBetween(Timestamp fechaInicioA ,Timestamp fechaInicioB);
    List<Transaccion> findByNumeroCuentaEquals(Long numeroCuenta);
    List<Transaccion> findByNumeroCuentaEqualsAndMonedaEquals(Long numeroCuenta, String moneda);
    List<Transaccion> findByNumeroCuentaEqualsAndFechaInicioBetween(Long numeroCuenta,Timestamp fechaInicioA ,Timestamp fechaInicioB);

    @Query(value = "SELECT * FROM Transaccion WHERE numero_cuenta = ?1 ORDER BY fecha_inicio DESC limit ?2", nativeQuery = true)
    List<Transaccion> finTopNumberByNumeroCuenta(Long numeroCuenta, int top);


    @Query(value = "SELECT * FROM Transaccion\n" +
            "    WHERE numero_cuenta = ?1\n" +
            "    AND fecha_inicio BETWEEN DATE_SUB(NOW(), INTERVAL ?2 MONTH) AND NOW()\n" +
            "    ORDER BY fecha_inicio DESC", nativeQuery = true)
    List<Transaccion> finByNumeroCuentaAndLastMonths(Long numeroCuenta, int months);

    @Query(value = "SELECT * FROM Transaccion\n" +
            "    WHERE numero_cuenta = ?1\n" +
            "AND MONTH(fecha_inicio) = MONTH(DATE_ADD(CURDATE(),INTERVAL -1 MONTH)) \n" +
            "AND YEAR(fecha_inicio)= YEAR(curdate())\n" +
            "ORDER BY fecha_inicio DESC", nativeQuery = true)
    List<Transaccion> finByNumeroCuentaAndLastMonth(Long numeroCuenta);

    @Query(value = "SELECT * FROM Transaccion\n" +
            "    WHERE numero_cuenta = ?1\n" +
            "AND MONTH(fecha_inicio) = MONTH(CURDATE()) \n" +
            "AND YEAR(fecha_inicio)= YEAR(curdate())\n" +
            "ORDER BY fecha_inicio DESC", nativeQuery = true)
    List<Transaccion> finByNumeroCuentaAndCurrentMonth(Long numeroCuenta);

    @Transactional
    @Modifying
    @Query(value = "UPDATE cuenta c " +
            "    INNER JOIN Transaccion t " +
            "    ON t.numero_cuenta = c.numero_cuenta " +
            "    SET c.saldo =if( t.operacion_id = 2, c.saldo + t.monto, c.saldo - t.monto )  ," +
            "        t.saldo =if( operacion_id = 2, c.saldo + t.monto, c.saldo - t.monto ) ," +
            "        t.estatus_id = ?2 ," +
            "        t.fecha_aprobacion = now() " +
            "WHERE t.id_transaccion = ?1 ; ", nativeQuery = true)
    void updateSaldoAndEstatusByIdTransaccion(Long idTransaccion , Long estatusId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE cuenta c " +
            "    INNER JOIN Transaccion t " +
            "    ON t.numero_cuenta = c.numero_cuenta " +
            "    SET c.saldo =if( t.operacion_id = 2, c.saldo - t.monto, c.saldo + t.monto )  ," +
            "        t.saldo =if( t.operacion_id = 2, c.saldo - t.monto, c.saldo + t.monto ) ," +
            "        t.estatus_id = ?2 ," +
            "        t.fecha_aprobacion = now() " +
            "WHERE t.id_transaccion = ?1 ; ", nativeQuery = true)
    void updateRestablecerSaldo(Long idTransaccion , Long estatusId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Transaccion t " +
            "    SET t.estatus_id = 5 ," +
            "        t.fecha_ejecucion = now() " +
            "WHERE t.id_transaccion = ?1 ; ", nativeQuery = true)
    void updateEstatus(Long idTransaccion);



}

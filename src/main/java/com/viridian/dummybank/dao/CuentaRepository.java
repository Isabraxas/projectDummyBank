package com.viridian.dummybank.dao;

import com.viridian.dummybank.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {

    List<Cuenta> findByNumeroCuenta( Long numeroCuenta);
}

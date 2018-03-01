package com.viridian.dummybank.dao;

import com.viridian.dummybank.model.Beneficiario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Long>{

    // añadido por marcelo
    Beneficiario getBeneficiarioByNumeroCuenta(Long numeroCuenta);
}

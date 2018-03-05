package com.viridian.dummybank.dao;

import com.viridian.dummybank.model.Beneficiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Long>{
    Beneficiario findByNumeroCuenta(Long numeroCuenta);
    Beneficiario findBeneficiarioByNumeroCuenta(Long numeroCuenta);

    // añadido por marcelo
    Beneficiario getBeneficiarioByNumeroCuenta(Long numeroCuenta);

    @Query(value = "select b.* from Beneficiario b\n" +
            "    left join\n" +
            "    Cliente_Beneficiario cb \n" +
            "    on cb.beneficiario_id = b.id_beneficiario\n" +
            "\tleft join\n" +
            "    Cliente c\n" +
            "    on c.id_cliente = cb.cliente_id\n" +
            "    where c.id_cliente = ?1 and b.numero_cuenta = ?2 ", nativeQuery = true)
    Beneficiario findBeneficiarioByClienteIdAndNumeroCuenta(Long id_cliente, Long numeroCuenta);
}

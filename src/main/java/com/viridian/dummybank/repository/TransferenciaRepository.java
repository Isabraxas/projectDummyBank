package com.viridian.dummybank.repository;

import com.viridian.dummybank.model.Beneficiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by marcelo on 28-02-18
 */
public interface TransferenciaRepository extends JpaRepository<Beneficiario, Long> {


    @Query(value = "select B.numero_cuenta \n" +
            "from \n" +
            "\tBeneficiario B, \n" +
            "    (\tselect beneficiario_id \n" +
            "\t\tfrom Cliente_Beneficiario \n" +
            "        where cliente_id= ?1 \n" +
            "\t) X\n" +
            "where B.id_beneficiario = X.beneficiario_id" , nativeQuery = true)
    List<Long> getCuentas(Long clienteId);
}

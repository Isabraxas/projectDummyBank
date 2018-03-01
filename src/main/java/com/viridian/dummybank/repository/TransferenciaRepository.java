package com.viridian.dummybank.repository;

import com.viridian.dummybank.model.Beneficiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by marcelo on 28-02-18
 */
@Repository
public interface TransferenciaRepository extends JpaRepository<Beneficiario, Long> {


    /*@Query(value = "select B.numero_cuenta \n" +
            "from \n" +
            "\tBeneficiario B, \n" +
            "    (\tselect beneficiario_id \n" +
            "\t\tfrom Cliente_Beneficiario \n" +
            "        where cliente_id= ?1 \n" +
            "\t) X\n" +
            "where B.id_beneficiario = X.beneficiario_id" , nativeQuery = true)*/
    @Query(value = "select B.numero_cuenta \n" +
            "from Beneficiario B \n" +
            "LEFT OUTER JOIN Cliente_Beneficiario CB ON B.id_beneficiario = CB.beneficiario_id\n" +
            "where CB.cliente_id = ?1",nativeQuery = true)
    List<Long> getCuentas(Long clienteId);

    @Query(value =
            "select B.* " +
            "from Beneficiario as B left outer join Cliente_Beneficiario as CB on B.id_beneficiario = CB.beneficiario_id " +
            "where CB.cliente_id = ?1 " +
                    "and " +
            "exists " +
                    "(select C.* " +
                    "from cuenta as C " +
                    "where C.numero_cuenta = B.numer_cuenta)",nativeQuery = true)
    List<Beneficiario> getThirdBeneficiariosFromThisBankAndByClienteId(Long id);


    @Query(value=
            "select B.* \n" +
            "from Beneficiario as B\n" +
            "left outer join Cliente_Beneficiario as CB on B.id_beneficiario = CB.beneficiario_id\n" +
            "where CB.cliente_id = ?1 " +
                    "and " +
            "not exists " +
                    "(select C.* " +
                    "from cuenta as C " +
                    "where C.numero_cuenta = B.numero_cuenta)",nativeQuery = true)
    List<Beneficiario> getBeneficiariosFromOtherBanksAndByClienteId(Long id);
}

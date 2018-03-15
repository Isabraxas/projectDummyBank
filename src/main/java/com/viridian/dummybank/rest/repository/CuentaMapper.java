package com.viridian.dummybank.rest.repository;


import com.viridian.dummybank.rest.model.CuentaRestModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CuentaMapper {

    @Select("SELECT * FROM cuenta")
    List<CuentaRestModel> findAllCuentas();

    @Select("Select * From cuenta where id_cuenta=#{id} ")
    CuentaRestModel findCuentaById(Long id);

    @Update("Update cuenta set id_cuenta=#{id_cuenta}, numero_cuenta=#{numero_cuenta}, tipo=#{tipo}," +
            " saldo=#{saldo}, cliente_id=#{cliente_id}, moneda=#{moneda} " +
            "where id_cuenta=#{id_cuenta}")
    int updateCuenta(CuentaRestModel cuenta);

    @Insert("Insert into cuenta values(null, #{numero_cuenta}, #{tipo}, #{saldo}, #{cliente_id},#{moneda})")
    void insertCuenta(CuentaRestModel cuenta);

    @Delete("Delete from cuenta where id_cuenta=#{id_cuenta} ")
    void deleteCuenta(CuentaRestModel cuenta);
}

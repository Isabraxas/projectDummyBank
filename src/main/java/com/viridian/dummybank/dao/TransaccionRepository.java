package com.viridian.dummybank.dao;

import com.viridian.dummybank.model.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaccionRepository extends JpaRepository<Transaccion, Long>{

}

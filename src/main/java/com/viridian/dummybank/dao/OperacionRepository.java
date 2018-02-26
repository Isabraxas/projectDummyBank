package com.viridian.dummybank.dao;

import com.viridian.dummybank.model.Operacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperacionRepository extends JpaRepository<Operacion, Long>{

}

package com.viridian.dummybank.repository;

import com.viridian.dummybank.model.Cliente;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by marcelo on 20-02-18
 */
public interface ClienteRepository extends CrudRepository<Cliente,Long> {
}

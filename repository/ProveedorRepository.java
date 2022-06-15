package com.josspepf.doniadulzura.repository;

import com.josspepf.doniadulzura.models.Proveedor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface ProveedorRepository extends CrudRepository<Proveedor, Integer> {

    @Query(value = "select * from proveedor where nombre like %:name%", nativeQuery = true)
    Collection<Proveedor> getProveedorByName (@Param("name") String nombre);

}

package com.josspepf.doniadulzura.repository;

import com.josspepf.doniadulzura.models.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface ProductoRepository extends CrudRepository <Producto, Integer> {

    @Query(value = "select * from producto where nombre like %:name%", nativeQuery = true)
    Collection<Producto> getProductoByName (@Param("name") String nombre);
}

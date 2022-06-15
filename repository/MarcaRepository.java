package com.josspepf.doniadulzura.repository;


import com.josspepf.doniadulzura.models.Marca;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface MarcaRepository extends CrudRepository<Marca, Integer> {


    // collection de marca que consume un metodo, una query nativa que trae todas las marcas con un
    // caracter especifico

    @Query (value = "select * from marca where nombre like %a%", nativeQuery = true)
     Collection<Marca> getMarcaByName (String nombre);

    // consulta con parametro

    @Query (value = "select * from marca where nombre like %:name%", nativeQuery = true)
    Collection<Marca> getMarcaByNameParametro (@Param("name") String nombre);



    }






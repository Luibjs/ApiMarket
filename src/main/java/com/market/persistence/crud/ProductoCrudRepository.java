package com.market.persistence.crud;

import com.market.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductoCrudRepository extends CrudRepository<Producto,Integer> {

    //query metodos
    //buscando una categoria por id, debe tener el mismo nombre que tiene en la clase Producto el parametro idCategoria
     List<Producto> findByIdCategoriaOrderByNombreAsc (int idCategoria);

     //-lessThan- significa es menor que
    // AND estado -- para poner otra condicion
     /* consultara los productos que son menores de la cantidad que pase por parametro
     y que a su vez este activos*/
     List<Producto> findByCantidadStrockLessThanAndEstado(int cantidadStrock,boolean estado);


}

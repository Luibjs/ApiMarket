package com.market.persistence.crud;

import com.market.persistence.entity.Categoria;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoriaCrudRepository extends CrudRepository<Categoria,Integer> {

    List<Categoria> findByEstadoEquals(boolean estado);
}

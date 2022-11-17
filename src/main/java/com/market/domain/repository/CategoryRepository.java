package com.market.domain.repository;

import com.market.domain.Category;
import com.market.persistence.entity.Categoria;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface CategoryRepository {

    List<Category> getAll();

    Category getById( int id);

    List<Category> findByEstadoEquals(boolean estado);

    Category save(Category category);

    void delete(int categoriaId);
}

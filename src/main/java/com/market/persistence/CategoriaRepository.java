package com.market.persistence;

import com.market.domain.Category;
import com.market.domain.repository.CategoryRepository;
import com.market.persistence.crud.CategoriaCrudRepository;
import com.market.persistence.entity.Categoria;
import com.market.persistence.entity.Producto;
import com.market.persistence.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoriaRepository implements CategoryRepository {

    @Autowired
    CategoriaCrudRepository categoriaCrudRepository;

    @Autowired
    private CategoryMapper mapper;


    @Override
    public List<Category> getAll() {
        List<Categoria> categorias = (List<Categoria>) categoriaCrudRepository.findAll();
        return mapper.toCategories(categorias);
    }

    @Override
    public Category getById( int id) {
        Categoria categoria = categoriaCrudRepository.findById(id).get();
        return mapper.toCategory(categoria);
    }

    @Override
    public List<Category> findByEstadoEquals(boolean estado) {
        List<Categoria> categoriasEstado = categoriaCrudRepository.findByEstadoEquals(true);
        return mapper.toCategories(categoriasEstado);
    }

    @Override
    public Category save(Category category) {
        Categoria categoria = mapper.toCategoria(category);
        categoriaCrudRepository.save(categoria);
        return mapper.toCategory(categoria);
    }

    @Override
    public void delete(int categoryId) {
        categoriaCrudRepository.deleteById(categoryId);
    }
}

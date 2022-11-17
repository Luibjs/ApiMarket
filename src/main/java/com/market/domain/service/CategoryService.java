package com.market.domain.service;

import com.market.domain.Category;
import com.market.domain.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.getAll();
    }

    public List<Category> findByEstadoEquals(boolean estado){
        return categoryRepository.findByEstadoEquals(estado);
    }

    public Category save(Category category){
        return categoryRepository.save(category);
    }

    public void delete(int categoriaId){
        categoryRepository.delete(categoriaId);
    }

    public Category getById( int id){
        return categoryRepository.getById(id);
    }
}

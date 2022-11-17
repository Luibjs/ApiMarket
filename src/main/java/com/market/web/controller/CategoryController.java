package com.market.web.controller;

import com.market.domain.Category;
import com.market.domain.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getAll(){
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable("id") int id){
        return categoryService.getById(id);
    }

    @GetMapping("/active")
    public List<Category> findByEstadoEquals(boolean estado){
        return categoryService.findByEstadoEquals(true);
    }

    @PostMapping("/save")
    public Category save(@RequestBody Category category){
        return categoryService.save(category);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int categoriaId){
        categoryService.delete(categoriaId);
    }


}

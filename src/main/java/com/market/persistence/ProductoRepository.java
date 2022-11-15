package com.market.persistence;

import com.market.persistence.crud.ProductoCrudRepository;
import com.market.persistence.entity.Producto;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

//aca se crea los metodos que van a implementar  las query o consultas de ProductoCrudRepository .

@Repository
public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }

    //retorna una lista y recibe un entero como parametro
    public List<Producto> getByCategoria (int id){
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(id);
    }

    //los productos que son menores de la cantidad que pase por parametro
    // y que a su vez este activos
    public Optional<List<Producto>> getEscasos(int cantidad){
        return  productoCrudRepository.findByCantidadStrockLessThanAndEstado(cantidad,true);
    }

    public Optional<Producto> getProducto(int id){
        return productoCrudRepository.findById(id);
    }

    public Producto save(Producto producto){
        return  productoCrudRepository.save(producto);
    }

    public void delete(int id){
        productoCrudRepository.deleteById(id);
    }
}

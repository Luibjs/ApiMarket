package com.market.persistence;

import com.market.domain.Product;
import com.market.domain.repository.ProductRepository;
import com.market.persistence.crud.ProductoCrudRepository;
import com.market.persistence.entity.Producto;
import com.market.persistence.mapper.ProductMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

//aca se crea los metodos que van a implementar  las query o consultas de ProductoCrudRepository .

@Repository
public class ProductoRepository implements ProductRepository {
    private ProductoCrudRepository productoCrudRepository;
    private ProductMapper mapper;

    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos =productoCrudRepository.findByCantidadStrockLessThanAndEstado(quantity,true);
        //como no tenemos un mapeador que convierta una lista de opcionales
        //se hace lo siguente , para que se retorne los prductos mapeados
        //la funcion mapea los productos a prods y estos a su ves se mapean an products y los retorna
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return Optional.empty();
    }

    @Override
    public Product save(Product product) {
        return null;
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

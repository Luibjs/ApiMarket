package com.market.domain.service;
import com.market.domain.Product;
import com.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    //se puede usar ya que productoRepository lo implementa y este si pertenece a spring
    //heredando asi la pertenecia a spring a esta interface
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional<List<Product>> getByCategoy(int categoryId){
        return productRepository.getByCategory(categoryId);
    }

    public Optional<Product> getProduct(int productId){
        return productRepository.getProduct(productId);
    }

    //por el momento no se usa productos escasos o ScarseProducts
    public Product save(Product product){
        return productRepository.save(product);
    }

    //modificando el metodo para que retorne un boolean y haci saber si se pudo
    //eliminar o no

    public boolean delete(int productId){
        //se verifica si existe el producto con ayuda de getProduct
        //y el isPresent que retorna tru si esta y si no un false
        if (getProduct(productId).isPresent()) {
            productRepository.delete(productId);
            return true;
        }else {
            return false;
        }
    }
}

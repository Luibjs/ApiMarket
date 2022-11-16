package com.market.persistence.mapper;

import com.market.domain.Product;
import com.market.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "idProducto",target = "productId"),
            @Mapping(source = "nombre",target = "name"),
            @Mapping(source = "idCategoria",target = "categoryId"),
            @Mapping(source = "precioVenta",target = "price"),
            @Mapping(source = "cantidadStrock",target = "stock"),
            @Mapping(source = "estado", target = "active"),

            //mapeando una fk su pone el uses para que use el maper de esta clase

            @Mapping(source = "categoria", target = "category"),

    })
    Product toProduct (Producto producto);
    //mapenado a su vez una array con estos products
    List<Product> toProducts(List<Producto> productos);

    @InheritInverseConfiguration
    @Mapping(target = "codigoBarras",ignore = true)
    Producto toProducto (Product product);
    List<Producto> toProductos(List<Product> product);
}

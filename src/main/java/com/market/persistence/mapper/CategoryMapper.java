package com.market.persistence.mapper;

import com.market.domain.Category;
import com.market.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

//clase para diseñar los conversores o mappers

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    //importante que el nombre empiece por toAlOQuesevaAConvertir en este caso una Category
    //convierte una categoria en Category o en pocas palabras dto
    @Mappings({
            //source fuente o clase a convertir en este caso
            //target a donde quiero llevarla la clase en este caso a dto
            //se convierten todos los atributos que queramos convertir

            @Mapping(source = "idCategoria",target = "categoryId"),
            @Mapping(source = "descripcion",target = "category"),
            @Mapping(source = "estado",target = "active")

    })
    Category toCategory(Categoria categoria);

    //convercion viseversa de Category que es el dto a Categoria que es la entidad

    //esta anotacion nos evita realizar el mapeo a la inversa.
    //como en la entidad Categoria tenemos una lista de productos y no las quiero añadir al DTO
    //indico que este array no va a ir para que sea ignorado con MAPPING TARGET se indica el NOmbre que esta en la entidad.

    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);
}

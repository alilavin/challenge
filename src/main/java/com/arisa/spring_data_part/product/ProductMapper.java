package com.arisa.spring_data_part.product;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toEntity(ProductDTO productDTO);
    ProductDTO toDTO(Product product);

    List<Product> toEntities(List<ProductDTO> productDTOS);
    List<ProductDTO> toDTOS(List<Product> products);

}

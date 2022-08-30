package com.arisa.spring_data_part.category;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category toEntity(CategoryDTO categoryDTO);
    CategoryDTO toDTO(Category category);

    List<Category> toEntities(List<CategoryDTO> categoryDTOS);
    List<CategoryDTO> toDTOS(List<Category> categories);

}

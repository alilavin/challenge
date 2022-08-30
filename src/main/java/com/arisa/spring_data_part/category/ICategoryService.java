package com.arisa.spring_data_part.category;

import java.util.List;

public interface ICategoryService {

    Category findById(Long id);
    List<Category> findAll();
    void update(Category category);
    void delete(Category category);
    Category findByTitle(String title);
    Category save(Category category);
    Boolean existsByTitle(String title);

}

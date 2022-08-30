package com.arisa.spring_data_part.category;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category,Long> {
    Optional<Category> findCategoryByTitle(String title);
    Boolean existsByTitle(String title);
}

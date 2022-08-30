package com.arisa.spring_data_part.category;


import com.arisa.spring_data_part.exceptions.ConflictException;
import com.arisa.spring_data_part.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Setter @Getter
public class CategoryService implements ICategoryService {

    private final CategoryRepository categoryRepository;


    @Override
    public Category findById(Long id) {

        Optional<Category> optional=categoryRepository.findById(id);
        if (optional.isPresent())
            return optional.get();
        else
            throw new RuntimeException("This Category is not Existed");

    }


    @Override
    @Cacheable(value = "categoryCache")
    public List<Category> findAll() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = "categoryCache",allEntries = true)
    })
    public void update(Category category) {
        Category categoryToSave=findById(category.getId());
        categoryToSave.setTitle(category.getTitle());
        categoryRepository.save(categoryToSave);


    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = "categoryCache",allEntries = true)
    })
    public void delete(Category category) {
        findById(category.getId());
         categoryRepository.delete(category);
    }


    @Override
    public Category findByTitle(String title) {
        Optional<Category> optional=categoryRepository.findCategoryByTitle(title);
        if (optional.isPresent())
            return optional.get();
        else
            throw new NotFoundException("This Category is not Existed");
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = "categoryCache",allEntries = true)
    })
    public Category save(Category category) {
        if (existsByTitle(category.getTitle()))
            throw new ConflictException("This Category is Existed");
        return categoryRepository.save(category);
    }

    @Override
    public Boolean existsByTitle(String title) {
        return categoryRepository.existsByTitle(title);
    }
}

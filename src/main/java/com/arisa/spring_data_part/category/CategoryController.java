package com.arisa.spring_data_part.category;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/category")
@AllArgsConstructor
public class CategoryController {

    private final ICategoryService iCategoryService;
    private final CategoryMapper categoryMapper;




    @PostMapping(value = "/save")
    public ResponseEntity<CategoryDTO> save(@RequestBody CategoryDTO categoryDTO){
        Category category=categoryMapper.toEntity(categoryDTO);
        category=iCategoryService.save(category);

        categoryDTO=categoryMapper.toDTO(category);
        return new ResponseEntity(categoryDTO,HttpStatus.CREATED);
    }

    @GetMapping(value = "/find_all")
    public ResponseEntity<List<CategoryDTO>> getAll(){

        List<CategoryDTO> categoryDTOS=categoryMapper.toDTOS(iCategoryService.findAll());
        return ResponseEntity.ok(categoryDTOS);
    }

    @GetMapping(value = "/find_by_id")
    public ResponseEntity<CategoryDTO> findById(@RequestParam Long id){
        Category category = iCategoryService.findById(id);

        CategoryDTO categoryDTO=categoryMapper.toDTO(category);
        return ResponseEntity.ok(categoryDTO);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Void> delete(@RequestBody CategoryDTO categoryDTO){
        Category category=categoryMapper.toEntity(categoryDTO);
        iCategoryService.delete(category);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/find_by_title")
    public ResponseEntity<CategoryDTO> findByTitle(@RequestParam String title){

        Category category=iCategoryService.findByTitle(title);
        CategoryDTO categoryDTO=categoryMapper.toDTO(category);
        return ResponseEntity.ok(categoryDTO);

    }

    @PutMapping(value = "/update")
    public ResponseEntity<Void> update(@RequestBody CategoryDTO categoryDTO){
        Category category=categoryMapper.toEntity(categoryDTO);
        iCategoryService.update(category);
        return ResponseEntity.status(HttpStatus.OK).build();

    }
}

package com.arisa.spring_data_part.product;

import com.arisa.spring_data_part.category.Category;
import com.arisa.spring_data_part.category.CategoryDTO;
import com.arisa.spring_data_part.category.CategoryMapper;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/product")
public class ProductController {

    private final IProductService iProductService;
    private final ProductMapper productMapper;
    private final CategoryMapper categoryMapper;


    @PostMapping(value = "/save")
    public ResponseEntity<ProductDTO> save(@RequestBody ProductDTO productDTO){

        Product product=productMapper.toEntity(productDTO);
        product=iProductService.save(product);
        productDTO=productMapper.toDTO(product);
        return new ResponseEntity(productDTO,HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Void> delete(@RequestBody ProductDTO productDTO){
        Product product=productMapper.toEntity(productDTO);
        iProductService.delete(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Void> update(@RequestBody ProductDTO productDTO){
        Product product=productMapper.toEntity(productDTO);
        iProductService.update(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }



    @GetMapping(value = "/find_by_id")
    public ResponseEntity<ProductDTO> findById(@RequestParam Long id){
        Product product=iProductService.findById(id);
        ProductDTO productDTO=productMapper.toDTO(product);
        return ResponseEntity.ok(productDTO);

    }

    @GetMapping(value = "/find_by_name")
    public ResponseEntity<ProductDTO> findById(@RequestParam String name){
        Product product=iProductService.findProductByName(name);
        ProductDTO productDTO=productMapper.toDTO(product);
        return ResponseEntity.ok(productDTO);

    }






}

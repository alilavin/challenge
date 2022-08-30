package com.arisa.spring_data_part.product;

import com.arisa.spring_data_part.category.CategoryRepository;
import com.arisa.spring_data_part.exceptions.NotFoundException;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService implements IProductService{

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public Product findById(Long id) {
        Optional<Product> optional=productRepository.findById(id);
        if (optional.isPresent())
            return optional.get();
        else
            throw new NotFoundException("This Product is not Existed");
    }

    @Override
    public Product findProductByName(String name) {
        return productRepository.findProductByName(name);
    }



    @Override
    public void delete(Product product) {
        Product toDelete=findById(product.getId());
        productRepository.delete(toDelete);

    }

    @Override
    public void update(Product product) {
        Product toUpdate=findById(product.getId());
        toUpdate.setCategory(product.getCategory());
        toUpdate.setDescribe(product.getDescribe());
        toUpdate.setName(product.getName());
        productRepository.save(toUpdate);

    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }
}

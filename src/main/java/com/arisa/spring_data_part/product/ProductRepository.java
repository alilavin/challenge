package com.arisa.spring_data_part.product;

import com.arisa.spring_data_part.category.Category;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product,Long> {

    Product findProductByName(String name);


}

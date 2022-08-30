package com.arisa.spring_data_part.product;



public interface IProductService {
    Product findById(Long id);
    Product findProductByName(String name);
    void delete(Product product);
    void update(Product product);
    Product save(Product product);
}

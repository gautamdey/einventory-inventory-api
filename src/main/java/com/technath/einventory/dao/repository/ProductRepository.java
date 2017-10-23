package com.technath.einventory.dao.repository;

import com.technath.einventory.dao.model.Product;
import com.technath.einventory.dao.model.Supplier;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

    public Product findById(Long productId);

}

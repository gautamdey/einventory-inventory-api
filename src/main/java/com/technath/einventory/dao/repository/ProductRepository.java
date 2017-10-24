package com.technath.einventory.dao.repository;

import com.technath.einventory.dao.model.Product;
import com.technath.einventory.dao.model.Supplier;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

public interface ProductRepository extends CrudRepository<Product, Long> {

    public Product findById(BigInteger productId);

}

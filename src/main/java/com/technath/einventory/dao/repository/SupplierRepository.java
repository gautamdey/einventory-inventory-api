package com.technath.einventory.dao.repository;

import com.technath.einventory.dao.model.Supplier;
import org.springframework.data.repository.CrudRepository;

public interface SupplierRepository extends CrudRepository<Supplier, Long> {

    public Supplier findBySupplierId(Long supplierId);

}

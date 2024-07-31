package com.alexandersaul.PointOfSale.repository;

import com.alexandersaul.PointOfSale.entities.ProductSupplier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSupplierRepository extends CrudRepository<ProductSupplier , Long> {

}

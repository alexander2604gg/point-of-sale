package com.alexandersaul.PointOfSale.repository;

import com.alexandersaul.PointOfSale.entities.ProductSupplier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductSupplierRepository extends CrudRepository<ProductSupplier , Long> {

    List<ProductSupplier> getBySupplierId (long supplierId);

}

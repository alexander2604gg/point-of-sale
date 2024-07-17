package com.alexandersaul.PointOfSale.repository;

import com.alexandersaul.PointOfSale.entities.Supplier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends CrudRepository<Supplier , Long> {
}

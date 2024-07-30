package com.alexandersaul.PointOfSale.repository;

import com.alexandersaul.PointOfSale.entities.Inventory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends CrudRepository<Inventory,Long> {

    @Query(value = "SELECT i FROM Inventory i JOIN i.product p WHERE p.name = :productName")
    Inventory findByProductName (@Param("productName") String productName);
    @Query(value = "SELECT i FROM Inventory i JOIN i.product p WHERE p.id = :productId")
    Inventory findByProductId (@Param("productId") long productId);

}

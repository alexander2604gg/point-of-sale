package com.alexandersaul.PointOfSale.repository;

import com.alexandersaul.PointOfSale.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {

    Product findProductByName (String name);
    @Query(value = "SELECT i FROM Product i JOIN i.category c WHERE c.name = :categoryName")
    List<Product> findProductByCategoryName (String categoryName);
}

package com.alexandersaul.PointOfSale.repository;


import com.alexandersaul.PointOfSale.entities.Category;
import com.alexandersaul.PointOfSale.entities.Inventory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
}

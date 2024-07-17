package com.alexandersaul.PointOfSale.service;

import com.alexandersaul.PointOfSale.dto.CategoryDTO;
import com.alexandersaul.PointOfSale.entities.Category;
import java.util.List;

public interface CategoryService {

    List<CategoryDTO> getAll();
    CategoryDTO save(CategoryDTO category);
    CategoryDTO update(CategoryDTO category);
    void delete(Long id);

}

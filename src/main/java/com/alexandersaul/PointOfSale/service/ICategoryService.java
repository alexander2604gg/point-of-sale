package com.alexandersaul.PointOfSale.service;

import com.alexandersaul.PointOfSale.dto.CategoryDTO;

import java.util.List;

public interface ICategoryService {

    List<CategoryDTO> getAll();
    CategoryDTO save(CategoryDTO category);
    CategoryDTO update(CategoryDTO category);
    void delete(Long id);

}

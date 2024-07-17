package com.alexandersaul.PointOfSale.service.Impl;

import com.alexandersaul.PointOfSale.dto.CategoryDTO;
import com.alexandersaul.PointOfSale.entities.Category;
import com.alexandersaul.PointOfSale.mapper.CategoryMapper;
import com.alexandersaul.PointOfSale.repository.CategoryRepository;
import com.alexandersaul.PointOfSale.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ICategoryService implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private  CategoryMapper categoryMapper;

    @Override
    public List<CategoryDTO> getAll() {
        List <Category> categoryList = (List<Category>) categoryRepository.findAll();
        return categoryList.stream()
                .map(categoryMapper::categoryToCategoryDTO)
                .toList();
    }

    @Override
    public CategoryDTO save(CategoryDTO category) {
        return null;
    }

    @Override
    public CategoryDTO update(CategoryDTO category) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}

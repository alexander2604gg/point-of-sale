package com.alexandersaul.PointOfSale.controller;

import com.alexandersaul.PointOfSale.dto.CategoryDTO;
import com.alexandersaul.PointOfSale.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/resource")
    public ResponseEntity<List<CategoryDTO>> getAllCategories () {
        List<CategoryDTO> categoryDTOList = categoryService.getAll();
        return ResponseEntity.ok(categoryDTOList);
    }


}

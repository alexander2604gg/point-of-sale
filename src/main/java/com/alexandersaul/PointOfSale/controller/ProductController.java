package com.alexandersaul.PointOfSale.controller;

import com.alexandersaul.PointOfSale.dto.ProductDTO;
import com.alexandersaul.PointOfSale.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/resource")
    public ResponseEntity<List<ProductDTO>> getAllProducts (){
        List<ProductDTO> productDTOList = productService.getAll();
        return ResponseEntity.ok(productDTOList);
    }

}

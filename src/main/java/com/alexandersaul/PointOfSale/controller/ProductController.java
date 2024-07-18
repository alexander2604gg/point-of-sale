package com.alexandersaul.PointOfSale.controller;

import com.alexandersaul.PointOfSale.dto.ProductDTO;
import com.alexandersaul.PointOfSale.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

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

    @PostMapping("/resource")
    public ResponseEntity<ProductDTO> saveProduct (@RequestBody ProductDTO productDTO) {

        if(productDTO == null){
            return ResponseEntity.badRequest().build();
        }

        ProductDTO newProductDTO = productService.save(productDTO);

        if(newProductDTO != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(newProductDTO);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @DeleteMapping("resource/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        try {
            productService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


}

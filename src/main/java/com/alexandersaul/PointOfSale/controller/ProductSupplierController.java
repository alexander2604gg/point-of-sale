package com.alexandersaul.PointOfSale.controller;


import com.alexandersaul.PointOfSale.dto.ProductSupplierDTO;
import com.alexandersaul.PointOfSale.dto.SupplierWithProductsDTO;
import com.alexandersaul.PointOfSale.service.IProductSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product_supplier")
public class ProductSupplierController {

    @Autowired
    private IProductSupplierService productSupplierService;

    @PostMapping("/resource/assignProductToSupplier")
    @PreAuthorize("permitAll()")
    public ResponseEntity<ProductSupplierDTO> assignProductToSupplier (@RequestBody ProductSupplierDTO productSupplierDTO){

        if (productSupplierDTO==null){
            return ResponseEntity.badRequest().build();
        }
        ProductSupplierDTO savedproductSupplierDTO = productSupplierService.assignProductToSupplier(productSupplierDTO);

        if (savedproductSupplierDTO!=null){
            return ResponseEntity.ok(savedproductSupplierDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/resource")
    @PreAuthorize("permitAll()")
    ResponseEntity<List<SupplierWithProductsDTO>> getSupplierWithProducts (){
        List<SupplierWithProductsDTO> supplierWithProductsDTOList = productSupplierService.getSupplierWithProducts();
        return ResponseEntity.ok(supplierWithProductsDTOList);
    }


}

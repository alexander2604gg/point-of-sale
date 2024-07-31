package com.alexandersaul.PointOfSale.controller;


import com.alexandersaul.PointOfSale.dto.ProductSupplierDTO;
import com.alexandersaul.PointOfSale.service.IProductSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product_supplier")
public class ProductSupplierController {

    @Autowired
    private IProductSupplierService productSupplierService;

    @PostMapping("/assignProductToSupplier")
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


}

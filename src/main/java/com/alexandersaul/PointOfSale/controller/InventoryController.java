package com.alexandersaul.PointOfSale.controller;

import com.alexandersaul.PointOfSale.dto.InventoryDTO;
import com.alexandersaul.PointOfSale.service.IInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private IInventoryService inventoryService;

    @GetMapping("/resource/{productName}")
    public ResponseEntity<InventoryDTO> getInventoryByProductName (@PathVariable String productName) {
        InventoryDTO inventoryDTO =  inventoryService.findByProductName(productName);
        return ResponseEntity.ok(inventoryDTO);
    }

    @PostMapping ("resource")
    public ResponseEntity<InventoryDTO> save (@RequestBody InventoryDTO inventoryDTO) {

        if (inventoryDTO == null){
            return ResponseEntity.badRequest().build();
        }
        InventoryDTO newInventory = inventoryService.save(inventoryDTO);
        if (newInventory != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(newInventory);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}

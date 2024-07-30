package com.alexandersaul.PointOfSale.service.Impl;

import com.alexandersaul.PointOfSale.dto.InventoryDTO;
import com.alexandersaul.PointOfSale.entities.Inventory;
import com.alexandersaul.PointOfSale.entities.Product;
import com.alexandersaul.PointOfSale.mapper.InventoryMapper;
import com.alexandersaul.PointOfSale.repository.InventoryRepository;
import com.alexandersaul.PointOfSale.repository.ProductRepository;
import com.alexandersaul.PointOfSale.service.IInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService implements IInventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private InventoryMapper inventoryMapper;
    @Autowired
    private ProductRepository productRepository;


    @Override
    public InventoryDTO findByProductName(String productName) {
        Inventory inventory = inventoryRepository.findByProductName(productName);
        if (inventory != null){
            return inventoryMapper.inventoryToInventoryDTO(inventory);
        } else {
            return null;
        }
    }


    @Override
    public InventoryDTO save(InventoryDTO inventoryDTO) {

        Product product = productRepository.findById(inventoryDTO.getProductID())
                .orElseGet(() -> {
                    Product newProduct = new Product();
                    newProduct.setId(inventoryDTO.getProductID());
                    newProduct.setName(inventoryDTO.getProductName());
                    return productRepository.save(newProduct);
                });

        Inventory inventory = inventoryMapper.inventoryDTOToInventory(inventoryDTO);
        inventory.setProduct(product);
        inventory = inventoryRepository.save(inventory);

        return inventoryMapper.inventoryToInventoryDTO(inventory);
    }


}

package com.alexandersaul.PointOfSale.service;

import com.alexandersaul.PointOfSale.dto.InventoryDTO;

public interface IInventoryService {

    InventoryDTO findByProductName (String productName);
    InventoryDTO save (InventoryDTO inventoryDTO);
    InventoryDTO addStock (long productId , int stockAdded);

}

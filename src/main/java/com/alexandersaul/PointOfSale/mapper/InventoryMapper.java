package com.alexandersaul.PointOfSale.mapper;

import com.alexandersaul.PointOfSale.dto.InventoryDTO;
import com.alexandersaul.PointOfSale.entities.Inventory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InventoryMapper {

    @Mapping(target = "productID" , source = "product.id")
    @Mapping(target = "productName" , source = "product.name")
    InventoryDTO inventoryToInventoryDTO (Inventory inventory);
    @Mapping(target = "product", ignore = true)
    Inventory inventoryDTOToInventory (InventoryDTO inventoryDTO);

}

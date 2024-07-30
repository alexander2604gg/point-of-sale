package com.alexandersaul.PointOfSale.dto;

import com.alexandersaul.PointOfSale.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryDTO {

    private long id;
    private long productID;
    private String productName;
    private int stock;
    private LocalDateTime lastUpdated;

}

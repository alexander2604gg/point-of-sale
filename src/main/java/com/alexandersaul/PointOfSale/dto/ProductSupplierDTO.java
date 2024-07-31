package com.alexandersaul.PointOfSale.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductSupplierDTO {

    private long productId;
    private long supplierId;
    private BigDecimal price;

}

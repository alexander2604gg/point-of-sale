package com.alexandersaul.PointOfSale.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SupplierWithProductsDTO {

    private String supplierName;
    private List<ProductDTO> productList;
    private BigDecimal priceOfSupplier;

}

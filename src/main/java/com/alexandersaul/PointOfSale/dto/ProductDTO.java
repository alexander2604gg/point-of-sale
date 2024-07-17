package com.alexandersaul.PointOfSale.dto;

import com.alexandersaul.PointOfSale.entities.Category;
import com.alexandersaul.PointOfSale.entities.ProductSupplier;
import com.alexandersaul.PointOfSale.entities.Supplier;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {

    private Long id;
    private String name;
    private BigDecimal price;
    private Category category;

}

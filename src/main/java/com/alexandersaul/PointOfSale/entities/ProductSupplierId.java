package com.alexandersaul.PointOfSale.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductSupplierId implements Serializable {

    @Column(name = "product_id")
    private Long productId;
    @Column (name = "supplier_id")
    private Long supplierId;

}

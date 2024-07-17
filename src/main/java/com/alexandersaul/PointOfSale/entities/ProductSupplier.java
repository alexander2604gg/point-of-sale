package com.alexandersaul.PointOfSale.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "product_supplier")
public class ProductSupplier {

    @EmbeddedId
    private ProductSupplierId id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne
    @MapsId("supplierId")
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @Column (name = "supplyPrice")
    private BigDecimal supplyPrice;

}

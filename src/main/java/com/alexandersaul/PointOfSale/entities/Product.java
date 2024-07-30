package com.alexandersaul.PointOfSale.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Lazy;

import java.math.BigDecimal;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column (name = "name" , length = 50)
    private String name;
    @Column (name = "price")
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "categoryID" , nullable = false)
    private Category category;
    @OneToMany(mappedBy = "product")
    private Set<ProductSupplier> productSuppliers;
    @OneToOne (mappedBy = "product" , cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private Inventory inventory;
}


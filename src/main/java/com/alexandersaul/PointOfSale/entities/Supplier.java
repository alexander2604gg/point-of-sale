package com.alexandersaul.PointOfSale.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Supplier")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name" , length = 50)
    private String name;
    @Column (name = "email" , length = 50)
    private String email;
    @Column (name = "phone" , length = 9)
    private String phone;
    @Column (name = "address" , length = 50)
    private String address;
    @OneToMany(mappedBy = "supplier")
    private Set<ProductSupplier> productSuppliers;

}

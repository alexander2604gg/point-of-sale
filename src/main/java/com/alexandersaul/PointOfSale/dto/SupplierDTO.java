package com.alexandersaul.PointOfSale.dto;

import com.alexandersaul.PointOfSale.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SupplierDTO {

    private long id;
    private String name;
    private String email;
    private String phone;
    private String address;


}

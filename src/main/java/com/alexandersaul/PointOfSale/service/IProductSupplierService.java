package com.alexandersaul.PointOfSale.service;

import com.alexandersaul.PointOfSale.dto.ProductSupplierDTO;
import com.alexandersaul.PointOfSale.dto.SupplierWithProductsDTO;

import java.math.BigDecimal;
import java.util.List;

public interface IProductSupplierService {

    ProductSupplierDTO assignProductToSupplier (ProductSupplierDTO productSupplierDTO);
    List<SupplierWithProductsDTO> getSupplierWithProducts ();

}

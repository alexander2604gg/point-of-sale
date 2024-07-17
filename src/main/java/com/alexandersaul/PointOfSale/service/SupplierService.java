package com.alexandersaul.PointOfSale.service;

import com.alexandersaul.PointOfSale.dto.SupplierDTO;
import com.alexandersaul.PointOfSale.entities.Supplier;

import java.util.List;

public interface SupplierService {

    List<SupplierDTO> getAll();
    SupplierDTO save(SupplierDTO supplierDTO);
    SupplierDTO update(SupplierDTO supplierDTO);
    void delete(Long id);

}

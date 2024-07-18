package com.alexandersaul.PointOfSale.service;

import com.alexandersaul.PointOfSale.dto.SupplierDTO;

import java.util.List;

public interface ISupplierService {

    List<SupplierDTO> getAll();
    SupplierDTO save(SupplierDTO supplierDTO);
    SupplierDTO update(SupplierDTO supplierDTO);
    void delete(Long id);

}

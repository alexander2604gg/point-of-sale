package com.alexandersaul.PointOfSale.service.Impl;

import com.alexandersaul.PointOfSale.dto.SupplierDTO;
import com.alexandersaul.PointOfSale.entities.Supplier;
import com.alexandersaul.PointOfSale.service.SupplierService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ISupplierService implements SupplierService {


    @Override
    public List<SupplierDTO> getAll() {
        return List.of();
    }

    @Override
    public SupplierDTO save(SupplierDTO supplierDTO) {
        return null;
    }

    @Override
    public SupplierDTO update(SupplierDTO supplierDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}

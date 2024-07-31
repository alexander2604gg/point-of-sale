package com.alexandersaul.PointOfSale.mapper;

import com.alexandersaul.PointOfSale.dto.ProductSupplierDTO;
import com.alexandersaul.PointOfSale.entities.ProductSupplier;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductSupplierMapper {


    @Mapping(target ="productId" , source = "product.id")
    @Mapping(target = "supplierId" , source = "supplier.id")
    @Mapping(target = "price" , source = "supplyPrice")
    ProductSupplierDTO toDTO (ProductSupplier productSupplier);
    @Mapping(target = "id.productId", source ="productId")
    @Mapping(target = "id.supplierId", source = "supplierId")
    @Mapping(target ="product.id" , source = "productId")
    @Mapping(target = "supplier.id" , source = "supplierId")
    @Mapping(target = "supplyPrice" , source = "price")
    ProductSupplier toModel (ProductSupplierDTO productSupplierDTO);

}

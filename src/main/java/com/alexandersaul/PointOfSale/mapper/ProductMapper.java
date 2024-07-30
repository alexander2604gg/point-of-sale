package com.alexandersaul.PointOfSale.mapper;

import com.alexandersaul.PointOfSale.dto.ProductDTO;
import com.alexandersaul.PointOfSale.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target ="stock" , source = "inventory.stock")
    ProductDTO productToProductDTO (Product product);
    @Mapping(target ="inventory.stock" , source = "stock")
    @Mapping(target = "productSuppliers", ignore = true)
    Product productDTOToProduct (ProductDTO productDTO);

}

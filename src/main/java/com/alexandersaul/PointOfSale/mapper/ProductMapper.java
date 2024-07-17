package com.alexandersaul.PointOfSale.mapper;

import com.alexandersaul.PointOfSale.dto.ProductDTO;
import com.alexandersaul.PointOfSale.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "category" , source = "category")
    ProductDTO productToProductDTO (Product product);
    Product productDTOToProduct (ProductDTO productDTO);

}

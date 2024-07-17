package com.alexandersaul.PointOfSale.mapper;

import com.alexandersaul.PointOfSale.dto.CategoryDTO;
import com.alexandersaul.PointOfSale.entities.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    CategoryDTO categoryToCategoryDTO (Category category);

    Category categoryDTOToCategory (CategoryDTO categoryDTO);

}

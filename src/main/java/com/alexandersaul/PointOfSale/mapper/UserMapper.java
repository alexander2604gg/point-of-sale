package com.alexandersaul.PointOfSale.mapper;

import com.alexandersaul.PointOfSale.dto.ProductDTO;
import com.alexandersaul.PointOfSale.dto.UserDTO;
import com.alexandersaul.PointOfSale.entities.Product;
import com.alexandersaul.PointOfSale.entities.UserSec;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO userToUserDTO (UserSec userSec);
    UserSec userDTOToUser (UserDTO userDTO);
}

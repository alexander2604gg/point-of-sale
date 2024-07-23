package com.alexandersaul.PointOfSale.service;

import com.alexandersaul.PointOfSale.dto.UserDTO;
import com.alexandersaul.PointOfSale.entities.UserSec;
import org.apache.catalina.User;
import org.mapstruct.control.MappingControl;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    List<UserDTO> findAllUsers();
    UserDTO findById (long id);
    UserDTO save (UserDTO userDTO);
    UserDTO update (UserDTO userSec , long id);
    void delete (long id);
    public String encriptPassword(String password);
}

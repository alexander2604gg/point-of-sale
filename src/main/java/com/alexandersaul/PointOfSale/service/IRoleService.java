package com.alexandersaul.PointOfSale.service;

import com.alexandersaul.PointOfSale.dto.RoleDTO;
import com.alexandersaul.PointOfSale.dto.UserDTO;

import java.util.List;

public interface IRoleService {

    List<RoleDTO> findAllRoles();
    RoleDTO findById (long id);
    RoleDTO save (RoleDTO roleDTO);
    RoleDTO update (RoleDTO roleDTO , long id);
    void delete (long id);

}

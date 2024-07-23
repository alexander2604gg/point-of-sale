package com.alexandersaul.PointOfSale.service;

import com.alexandersaul.PointOfSale.dto.PermissionDTO;
import com.alexandersaul.PointOfSale.entities.Permission;

import java.util.List;

public interface IPermissionService {

    List<PermissionDTO> getAllPermissions();
    PermissionDTO save(PermissionDTO permissionDTO);
    PermissionDTO update (PermissionDTO permissionDTO , long id);
    PermissionDTO findById(long id);
    void delete(long id);

}

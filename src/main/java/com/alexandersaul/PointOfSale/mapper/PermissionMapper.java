package com.alexandersaul.PointOfSale.mapper;

import com.alexandersaul.PointOfSale.dto.PermissionDTO;
import com.alexandersaul.PointOfSale.entities.Permission;
import org.mapstruct.Mapper;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface PermissionMapper {

    PermissionDTO permissionToPermissionDTO (Permission permission);
    Permission permissionDTOToPermission (PermissionDTO permissionDTO);
    Set<PermissionDTO> toPermissionDTOs (Set<Permission> permissions);
    Set<Permission> toPermissions(Set<PermissionDTO> permissionDTOS);

}

package com.alexandersaul.PointOfSale.mapper;

import com.alexandersaul.PointOfSale.dto.RoleDTO;
import com.alexandersaul.PointOfSale.entities.Role;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleDTO roleToRoleDTO (Role role);
    Role roleDTOToRole (RoleDTO role);
    Set<Role> toRoles (Set<RoleDTO> roleDTOS);
    Set<RoleDTO> toRolesDTOs (Set<Role> roles);

}

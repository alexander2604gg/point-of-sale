package com.alexandersaul.PointOfSale.dto;

import com.alexandersaul.PointOfSale.entities.Permission;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleDTO {

    private Long id;
    private String role;
    private Set<PermissionDTO> permissionList;

}

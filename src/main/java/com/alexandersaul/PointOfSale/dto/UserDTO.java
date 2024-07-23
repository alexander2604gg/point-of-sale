package com.alexandersaul.PointOfSale.dto;
import com.alexandersaul.PointOfSale.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

    private Long id;
    private String userName;
    private String password;
    private boolean enabled;
    private boolean accountNotExpired;
    private boolean accountNotBlocked;
    private boolean credentialNotExpired;
    private Set<RoleDTO> rolesList;

}
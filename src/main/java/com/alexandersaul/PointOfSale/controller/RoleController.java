package com.alexandersaul.PointOfSale.controller;

import com.alexandersaul.PointOfSale.dto.RoleDTO;
import com.alexandersaul.PointOfSale.service.IPermissionService;
import com.alexandersaul.PointOfSale.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @GetMapping("/resource")
    @PreAuthorize("permitAll()")
    public ResponseEntity<List<RoleDTO>> getAllRoles() {
        List<RoleDTO> roles = roleService.findAllRoles();
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/resource/{id}")
    @PreAuthorize("permitAll()")
    public ResponseEntity<RoleDTO> getRoleById(@PathVariable long id) {
        RoleDTO role = roleService.findById(id);
        return ResponseEntity.ok(role);
    }

    @PostMapping("/resource")
    @PreAuthorize("permitAll()")
    public ResponseEntity<RoleDTO> saveRole(@RequestBody RoleDTO roleDTO) {

        if (roleDTO == null) {
            return ResponseEntity.badRequest().build();
        }

        RoleDTO newRoleDTO = roleService.save(roleDTO);

        if (newRoleDTO != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(newRoleDTO);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}

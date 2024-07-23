package com.alexandersaul.PointOfSale.controller;

import com.alexandersaul.PointOfSale.dto.PermissionDTO;
import com.alexandersaul.PointOfSale.dto.ProductDTO;
import com.alexandersaul.PointOfSale.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Repeatable;
import java.util.List;

@RestController
@RequestMapping("/api/permission")
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;

    @GetMapping("/resource")
    @PreAuthorize("permitAll()")
    public ResponseEntity<List<PermissionDTO>> getAllPermissions () {
        List<PermissionDTO> permissions = permissionService.getAllPermissions();
        return ResponseEntity.ok(permissions);
    }

    @GetMapping("/resource/{id}")
    @PreAuthorize("permitAll()")
    public ResponseEntity<PermissionDTO> getPermissionById (@PathVariable long id){
        PermissionDTO permission = permissionService.findById(id);
        return ResponseEntity.ok(permission);
    }

    @PostMapping ("/resource")
    @PreAuthorize("permitAll()")
    public ResponseEntity<PermissionDTO> savePermission (@RequestBody PermissionDTO permissionDTO) {

        if(permissionDTO == null){
            return ResponseEntity.badRequest().build();
        }

        PermissionDTO newPermissionDTO = permissionService.save(permissionDTO);

        if(newPermissionDTO != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(newPermissionDTO);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
}

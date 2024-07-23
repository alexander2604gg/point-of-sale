package com.alexandersaul.PointOfSale.controller;

import com.alexandersaul.PointOfSale.dto.UserDTO;
import com.alexandersaul.PointOfSale.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/resource")
    @PreAuthorize("permitAll()")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.findAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/resource/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable long id) {
        UserDTO user = userService.findById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/resource")
    @PreAuthorize("permitAll()")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO) {
        if (userDTO == null) {
            return ResponseEntity.badRequest().build();
        }

        UserDTO newUserDTO = userService.save(userDTO);

        if (newUserDTO != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(newUserDTO);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/resource/{id}")
    @PreAuthorize("permitAll()")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO, @PathVariable long id) {
        if (userDTO == null) {
            return ResponseEntity.badRequest().build();
        }

        UserDTO updatedUserDTO = userService.update(userDTO, id);

        if (updatedUserDTO != null) {
            return ResponseEntity.ok(updatedUserDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/resource/{id}")
    @PreAuthorize("permitAll()")
    public ResponseEntity<Void> deleteUser(@PathVariable long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

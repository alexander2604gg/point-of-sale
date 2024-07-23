package com.alexandersaul.PointOfSale.service.Impl;

import com.alexandersaul.PointOfSale.dto.PermissionDTO;
import com.alexandersaul.PointOfSale.dto.RoleDTO;
import com.alexandersaul.PointOfSale.entities.Permission;
import com.alexandersaul.PointOfSale.entities.Role;
import com.alexandersaul.PointOfSale.mapper.PermissionMapper;
import com.alexandersaul.PointOfSale.mapper.RoleMapper;
import com.alexandersaul.PointOfSale.repository.PermissionRepository;
import com.alexandersaul.PointOfSale.repository.RoleRepository;
import com.alexandersaul.PointOfSale.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RoleService implements IRoleService {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<RoleDTO> findAllRoles() {
        List<Role> roleList = (List<Role>) roleRepository.findAll();
        return roleList.stream()
                .map(roleMapper::roleToRoleDTO)
                .toList();
    }

    @Override
    public RoleDTO findById(long id) {
        Optional<Role> roleOptional = roleRepository.findById(id);
        return roleOptional.map(role -> roleMapper.roleToRoleDTO(role)).orElse(null);
    }

    public RoleDTO save(RoleDTO roleDTO) {

        if (roleDTO == null || roleDTO.getPermissionList() == null) {
            throw new IllegalArgumentException("RoleDTO or its permission list cannot be null");
        }

        Role role = roleMapper.roleDTOToRole(roleDTO);
        Set<Permission> permissions = roleDTO.getPermissionList().stream()
                .map(permissionDTO -> permissionRepository.findById(permissionDTO.getId()).orElse(null))
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());

        role.setPermissionList(permissions);

        Role savedRole = roleRepository.save(role);

        return roleMapper.roleToRoleDTO(savedRole);
    }


    @Override
    public RoleDTO update(RoleDTO roleDTO, long id) {

        Optional<Role> optionalRole = roleRepository.findById(id);
        if(optionalRole.isPresent()){
            Role role = optionalRole.get();
            role.setRole(roleDTO.getRole());
            role.setPermissionList(permissionMapper.toPermissions(roleDTO.getPermissionList()));
            role = roleRepository.save(role); // Save the updated entity
            return roleMapper.roleToRoleDTO(role);
        } else {
            return null;
        }
    }

    @Override
    public void delete(long id) {
        roleRepository.deleteById(id);
    }
}

package com.alexandersaul.PointOfSale.service.Impl;

import com.alexandersaul.PointOfSale.dto.PermissionDTO;
import com.alexandersaul.PointOfSale.entities.Permission;
import com.alexandersaul.PointOfSale.mapper.PermissionMapper;
import com.alexandersaul.PointOfSale.repository.PermissionRepository;
import com.alexandersaul.PointOfSale.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermissionService implements IPermissionService {

    @Autowired
    private PermissionRepository permissionRepository;
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<PermissionDTO> getAllPermissions() {
        List<Permission> permissionList = (List<Permission>) permissionRepository.findAll();
        return permissionList.stream()
                .map(permissionMapper::permissionToPermissionDTO)
                .toList();
    }

    @Override
    public PermissionDTO save(PermissionDTO permissionDTO) {
        Permission permission = permissionRepository.save(permissionMapper.permissionDTOToPermission(permissionDTO));
        return permissionMapper.permissionToPermissionDTO(permission);
    }

    @Override
    public PermissionDTO update(PermissionDTO permissionDTO, long id) {
        Optional<Permission> optionalPermission = permissionRepository.findById(id);
        if(optionalPermission.isPresent()){
            Permission permission = optionalPermission.get();
            permission.setPermissionName(permissionDTO.getPermissionName());
            return permissionMapper.permissionToPermissionDTO(permission);
        } else {
            return null;
        }
    }

    @Override
    public PermissionDTO findById(long id) {
        Optional<Permission> permissionOptional = permissionRepository.findById(id);
        return permissionOptional.map(permission -> permissionMapper.permissionToPermissionDTO(permission)).orElse(null);
    }

    @Override
    public void delete(long id) {
        permissionRepository.deleteById(id);
    }
}

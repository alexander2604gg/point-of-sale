package com.alexandersaul.PointOfSale.service.Impl;

import com.alexandersaul.PointOfSale.dto.UserDTO;
import com.alexandersaul.PointOfSale.entities.Role;
import com.alexandersaul.PointOfSale.entities.UserSec;
import com.alexandersaul.PointOfSale.mapper.RoleMapper;
import com.alexandersaul.PointOfSale.mapper.UserMapper;
import com.alexandersaul.PointOfSale.repository.RoleRepository;
import com.alexandersaul.PointOfSale.repository.UserRepository;
import com.alexandersaul.PointOfSale.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<UserDTO> findAllUsers() {
        List<UserSec> userList = (List<UserSec>) userRepository.findAll();
        return userList.stream()
                .map(userMapper::userToUserDTO)
                .toList();
    }

    @Override
    public UserDTO findById(long id) {
        Optional<UserSec> userOptional = userRepository.findById(id);
        return userOptional.map(user -> userMapper.userToUserDTO(user)).orElse(null);
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        if (userDTO == null || userDTO.getRolesList() == null) {
            throw new IllegalArgumentException("UserDTO or its role list cannot be null");
        }

        userDTO.setPassword(encriptPassword(userDTO.getPassword()));
        UserSec user = userMapper.userDTOToUser(userDTO);
        Set<Role> roles = userDTO.getRolesList().stream()
                .map(roleDTO -> roleRepository.findById(roleDTO.getId()).orElse(null))
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());

        user.setRolesList(roles);

        UserSec savedUser = userRepository.save(user);

        return userMapper.userToUserDTO(savedUser);
    }

    @Override
    public UserDTO update(UserDTO userSec, long id) {
        Optional<UserSec> userSecOptional = userRepository.findById(id);
        if (userSecOptional.isPresent()){
            UserSec newUser = userSecOptional.get();
            newUser.setUserName(userSec.getUserName());
            newUser.setPassword(userSec.getPassword());
            newUser.setRolesList(roleMapper.toRoles(userSec.getRolesList()));
            return userMapper.userToUserDTO(newUser);
        } else {
            return null;
        }
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }
    @Override
    public String encriptPassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }
}

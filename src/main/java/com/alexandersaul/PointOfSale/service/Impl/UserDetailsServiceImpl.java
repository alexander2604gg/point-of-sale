package com.alexandersaul.PointOfSale.service.Impl;

import com.alexandersaul.PointOfSale.entities.UserSec;
import com.alexandersaul.PointOfSale.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserSec userSec = userRepository.findUserSecByUserName((userName)).orElseThrow(()->new UsernameNotFoundException(userName + " was not found"));

        Set<GrantedAuthority> authorityList = new HashSet<>();

        userSec.getRolesList()
                .forEach(role -> authorityList.add(new SimpleGrantedAuthority("ROLE_".concat(role.getRole()))));

        userSec.getRolesList().stream()
                .flatMap(role-> role.getPermissionList().stream())
                .forEach(permission -> authorityList.add(new SimpleGrantedAuthority(permission.getPermissionName())));

        System.out.println(userSec.getUserName() + userSec.getPassword() +  userSec.isEnabled() +  userSec.isAccountNotExpired()+
                userSec.isCredentialNotExpired() +  userSec.isAccountNotBlocked() +  authorityList);

        return new User(userSec.getUserName() , userSec.getPassword() , userSec.isEnabled() , userSec.isAccountNotExpired(),
                userSec.isCredentialNotExpired() , userSec.isAccountNotBlocked() , authorityList);
    }
}

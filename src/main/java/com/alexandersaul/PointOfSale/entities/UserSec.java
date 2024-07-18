package com.alexandersaul.PointOfSale.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "Users")
public class UserSec {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String userName;
    private String password;
    private boolean enabled;
    private boolean accountNotExpired;
    private boolean accountNotBlocked;
    private boolean credentialNotExpired;

    @ManyToMany(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @JoinTable (name = "user_roles" , joinColumns = @JoinColumn(name = "user_id") ,
    inverseJoinColumns = @JoinColumn(name="role_id"))
    private Set<Role> rolesList = new HashSet<>();

}



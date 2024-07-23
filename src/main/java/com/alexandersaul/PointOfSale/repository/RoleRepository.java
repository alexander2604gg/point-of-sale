package com.alexandersaul.PointOfSale.repository;

import com.alexandersaul.PointOfSale.entities.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role,Long> {
}

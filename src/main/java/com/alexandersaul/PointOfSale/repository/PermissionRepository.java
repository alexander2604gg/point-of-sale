package com.alexandersaul.PointOfSale.repository;

import com.alexandersaul.PointOfSale.entities.Permission;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends CrudRepository<Permission,Long> {
}
